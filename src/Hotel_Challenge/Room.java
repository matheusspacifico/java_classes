package Hotel_Challenge;

public class Room {
    private final int number;
    private final double price;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public String asString(){
        return String.format("Room %d: R$%.2f", number, price);
    }

    public double getPrice(){
        return price;
    }

    public int getNumber(){
        return number;
    }
}
