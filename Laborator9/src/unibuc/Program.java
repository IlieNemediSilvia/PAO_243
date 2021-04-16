package unibuc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Program {
    public static void main(String[] args) {
        try {
            List<User> users = Files.readAllLines(Paths.get("data/users.csv")).stream()
                    .map(line -> new User(line.split(",")))
                    .collect(Collectors.toList());
            System.out.println(String.format("Total users: %d", users.stream().count()));
            List<Task> tasks = Files.readAllLines(Paths.get("data/tasks.csv")).stream()
                    .map(line -> new Task(line.split(",")))
                    .collect(Collectors.toList());
            System.out.println(String.format("Total tasks: %d", tasks.stream().count()));

            System.out.println("Critical tasks: ");
            tasks.stream().filter(t -> t.getPriority().equals(Priority.CRITICAL))
                    .sorted(Comparator.comparing(Task::getCreatedDate))
                    .forEach(System.out::println);

            System.out.println("First 10 users: ");
            users.stream().sorted(Comparator.comparing(User::getLastName))
                    .limit(10)
                    .forEach(System.out::println);
            tasks.get(0).assignTo(users.get(5));
            tasks.get(8).assignTo(users.get(2));
            tasks.get(10).assignTo(users.get(12));
            tasks.get(7).assignTo(users.get(12));

            System.out.println("Users that have tasks assigned: ");
            tasks.stream().filter(t-> t.getAssignee() != null)
                    .map(Task::getAssignee).distinct()
                    .forEach(System.out::println);

            tasks.get(0).getObservers().add(users.get(10));

            System.out.println("Observers:");
            tasks.stream().filter(t-> !t.getObservers().isEmpty())
                    .flatMap(t-> t.getObservers().stream())
                    .distinct().forEach(System.out::println);

            System.out.println(tasks.stream().max(Comparator.comparing(Task::getDaysToImplement)).get());
            System.out.println(tasks.stream().min(Comparator.comparing(Task::getCreatedDate).reversed()).get());
            System.out.println(String.format("Total days to implement: %d ",
                    tasks.stream().map(t -> t.getDaysToImplement()).reduce(0, (x, y) -> x+y)));

            System.out.println("Task to do:");
            List<Task> tasksToDo = tasks.stream()
                    .filter(t -> t.getStatus().equals(Status.IN_PROGRESS) || t.getStatus().equals(Status.OPEN))
                    .collect(Collectors.toList());
            tasksToDo.stream().forEach(System.out::println);

            String busyUsers = tasks.stream().filter(t -> t.getStatus().equals(Status.IN_PROGRESS))
                    .map(t -> t.getAssignee().getLastName() + " " + t.getAssignee().getFirstName())
                    .distinct()
                    .collect(Collectors.joining(";"));
            System.out.println("Busy users: " + busyUsers);

            System.out.println("Average time to solve a task: " + tasks.stream().collect(averagingInt(Task::getDaysToImplement)));
            System.out.println("Total time to solve a task: " + tasks.stream().collect(summingInt(Task::getDaysToImplement)));
            System.out.println("Tasks by type: ");
            tasks.stream().collect(groupingBy(Task::getType)).entrySet()
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue().size()));
            System.out.println("Tasks by priority: ");
            tasks.stream().collect(groupingBy(Task::getPriority, counting())).entrySet()
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
