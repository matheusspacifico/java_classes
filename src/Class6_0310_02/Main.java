package Class6_0310_02;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Zoo z = new Zoo();
            z.addOwl("c1");
            z.addOwl("c2");
            z.addOwl("c3");
            z.addOwl("c4");
            z.addLion("l1");
            z.addLion("l2");
            z.addLion("l3");
            z.addWolf("w1");
            z.addWolf("w2");
            z.addWolf("w3");

            Animal[] jaulas = z.getJaulas();

            for (Animal a : jaulas) {
                a.makeSound();
                if (a instanceof Lion) ((Lion) a).run();
                if (a instanceof Wolf) ((Wolf) a).run();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
