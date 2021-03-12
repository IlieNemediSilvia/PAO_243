package unibuc.association;

public class Team {
    private String name;
    private Player leader;

    public Team(String name, Player leader){
        this.name = name;
        this.leader = leader;
    }

    public Player getLeader() {
        return leader;
    }
}
