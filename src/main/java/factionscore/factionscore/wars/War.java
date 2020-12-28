package factionscore.factionscore.wars;

public class War {
    public void setAggressorFactionName(String name) {
        this.aggressorFactionName = name;
    }

    public String getAggressorFactionName() {
        return aggressorFactionName;
    }

    public void setDefenderFactionName(String name) {
        this.defenderFactionName = name;
    }

    public String getDefenderFactionName() {
        return  defenderFactionName;
    }

    private String aggressorFactionName;
    private String defenderFactionName;
}