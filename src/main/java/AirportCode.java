public enum AirportCode {
    VIE("Vienna", "Austria", "Europe"),
    EDI("Edinburgh", "Scotland", "Europe"),
    NBO("Nairobi Jomo Kenyatta", "Kenya", "Africa"),
    LTN("Luton", "England", "Europe"),
    GTW("Gatwick", "England", "Europe"),
    MEL("Melbourne", "Australia", "Australia"),
    MUN("Munich", "Germany", "Europe");

    private final String name;
    private final String country;
    private final String region;

    AirportCode(String name, String country, String region) {
        this.name = name;
        this.country = country;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public String getCountry() { return country; }

    public String getRegion() {return region; }
}