package Urna_Challenge;

public class Main {
    private static final int NUMERO_DE_ELEITORES = 2;

    public static void main(String[] args) {
        UrnaImpl urna = new UrnaImpl();

        for (int i = 1; i <= NUMERO_DE_ELEITORES; i++) {
            System.out.println("\n--- Eleitor " + i + " ---");
            urna.votar();
        }

        System.out.println("\n--- Resultado Final ---");
        urna.imprimir();
    }
}
