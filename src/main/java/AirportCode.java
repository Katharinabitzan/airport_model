public enum AirportCode {
    VIE("Vienna", "Austria"),
    EDI("Edinburgh", "Scotland"),
    NBO("Nairobi", "Kenya"),
    LTN("Luton", "England"),
    GTW("Gatwick", "England"),
    MUN("Munich", "Germany");

    private final String name;
    private final String country;

    AirportCode(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() { return country; }

}