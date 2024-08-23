package Class3_2208;

public class Origin {
    public static void main(String[] args) {
        Deck deck = new Deck();
        final Card[] cards = deck.takeMany(10);
        for (Card card : cards) {
            System.out.println(card.asString());
        }
    }
}