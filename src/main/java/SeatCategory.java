public enum SeatCategory {
    SAVER("Super saver", 0, false, false, false, 0.0),
    ECONOMY("Economy Class", 1, false, false, true, 10.0),
    PREMIUM("Premium Economy Class", 1, false, true, true, 20.0),
    BUSINESS("Business Class", 2, true, true, true, 100.0),
    FIRST("First Class", 3, true, true, true, 200.0);

    private final String name;
    private final int suitcaseAllowance;
    private final boolean loungeEntry;
    private final boolean speedyBoarding;
    private final boolean rebookPossible;
    private final double cost;

    SeatCategory(String name, int suitcaseAllowance, boolean loungeEntry, boolean speedyBoarding, boolean rebookPossible, double cost) {
        this.name = name;
        this.suitcaseAllowance = suitcaseAllowance;
        this.loungeEntry = loungeEntry;
        this.speedyBoarding = speedyBoarding;
        this.rebookPossible = rebookPossible;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getSuitcaseAllowance(){
        return suitcaseAllowance;
    }

    public double getCost() {
        return cost;
    }

    public boolean isLoungeEntry() { return loungeEntry; }
    public boolean isSpeedyBoarding() { return speedyBoarding; }
    public boolean isRebookPossible() { return rebookPossible; }

}
