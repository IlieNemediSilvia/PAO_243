package pao.unibuc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static pao.unibuc.WorkFlow.from;
import static pao.unibuc.WorkFlow.shutDown;

public class Main {
    public static void main(String[] args) {
                from(linesFromCsvFilesInFolder("data/input"))
               .transform(convertLineToCity())
               .filter(districtNotNull())
               .aggregate(byDistrict(), groupByDistrict())
               .sort(ascendingByDistrictName())
               .transform(convertDistrictToString())
               .aggregate(byConstant(true), groupAllLines())
               .to(saveAllLinesToCsvFile("data/output"));

                waitForExit();
    }
    private static void waitForExit(){
        System.out.println("Copy csv files into data/input. Type 'exit' to quit.");
        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                if(scanner.hasNextLine() && "exit".equalsIgnoreCase(scanner.nextLine())){
                    shutDown();
                    break;
                }
            }
        }
    }
    private static Supplier<List<?>> linesFromCsvFilesInFolder(String path){
        return () ->
            Arrays.stream(Paths.get(path).toFile().listFiles())
                    .filter(file -> file.isFile() && file.getName().toLowerCase().endsWith(".csv"))
                    .flatMap(file -> {
                        List<String> lines = Collections.emptyList();
                        try {
                            lines = Files.readAllLines(file.toPath());
                            file.delete();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return lines.stream();
                    }).collect(Collectors.toList());
    }
    private static Consumer<Exchange> convertLineToCity(){
        return exchange -> exchange.setBody(new City(exchange.getBody(String.class)));
    }
    private static Predicate<Exchange> districtNotNull(){
        return exchange -> exchange.getBody(City.class).getDistrict() != null;
    }
    private static Function<Exchange, Object> byDistrict(){
        return exchange -> exchange.getBody(City.class).getDistrict();
    }
    private static Aggregator<Exchange> groupByDistrict(){
        return (oldExchange, newExchange) ->{
            City city = newExchange.getBody(City.class);
            District district = (oldExchange == null) ? new District(city.getDistrict()) : oldExchange.getBody(District.class);
            district.addCity(city);
            return new Exchange(district);
        };
    }
    private static Comparator<Exchange> ascendingByDistrictName(){
        return (firstExchange, secondExchange) -> firstExchange.getBody(District.class).getName()
                .compareTo(secondExchange.getBody(District.class).getName());
    }
    private static Consumer<Exchange> convertDistrictToString(){
        return exchange -> exchange.setBody(exchange.getBody(District.class).toString());
    }
    private static Function<Exchange, Object> byConstant (Object constant){
        return exchange -> constant;
    }
    public static Aggregator<Exchange> groupAllLines(){
        return (oldExchange, newExchange) ->{
            String line = newExchange.getBody(String.class);
            StringBuilder builder = (oldExchange == null) ? new StringBuilder() : oldExchange.getBody(StringBuilder.class);
            builder.append(line).append(System.getProperty("line.separator"));
            return new Exchange(builder);
        };
    }
    private static Consumer<Exchange> saveAllLinesToCsvFile(String path){
        return exchange -> {
            String target = String.format("%s/%s.csv", path, exchange.getId());
            try {
                Files.writeString(Paths.get(target), exchange.getBody(StringBuilder.class).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
