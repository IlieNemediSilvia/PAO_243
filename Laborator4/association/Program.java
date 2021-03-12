package unibuc.association;

public class Program {
    public static void main(String[] args) {
        Engine engine = new Engine("diesel", 1.6f);
        Car car = new Car("red", engine);
        System.out.println(engine == car.engine);
        engine.capacity = 2f;
        System.out.println(car.engine.capacity);

        Player player = new Player("Alin Ionescu", "football");
        Team team = new Team("Barcelona", player);
        System.out.println(player == team.getLeader());
        player.setSport("tennis");
        System.out.println(team.getLeader().getSport());
        Team team2 = new Team("Real Madrid", player);
        System.out.println(player == team2.getLeader());
    }
}
