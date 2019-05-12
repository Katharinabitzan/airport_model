public enum PlaneType {
    BOEING737("Boeing 737 Max 8", 450),
    BOEING747("Boeing 747", 416),
    HAWKER800("Hawker 800", 2),
    AIRBUSA320("Airbus A320", 186);

    private final String name;
    private final int capacity;

    PlaneType(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity(){
        return capacity;
    }

}

