package Class3_2208_2;

public class Player {
    private final String name;
    private final int number;
    private final String position;
    private boolean isFielded;

    public Player(String name, int number, String position, boolean isFielded) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public void fieldIt(){
        isFielded = true;
    }

    public void outfieldIt(){
        isFielded = false;
    }

    public boolean getIsFielded() {
        return isFielded;
    }

    public String getStateAsString(){
        return String.format("Name: %s%nNumber: %d%nPosition: %s%nisFielded: %s%n", name, number, position, isFielded);
    }
}
