package Class6_0310_02;

import java.util.Arrays;
import java.util.Iterator;

public class Zoo {
    private final Animal[] jaulas;
    private int jaulasCount;

    public Zoo() {
        this.jaulas = new Animal[10];
        this.jaulasCount = 0;
    }

    public void addOwl(String n) {
        if (jaulasCount == 10) throw new IndexOutOfBoundsException("Array cheio!");
        jaulas[jaulasCount] = new Owl(n);
        jaulasCount++;
    }

    public void addLion(String n) {
        if (jaulasCount == 10) throw new IndexOutOfBoundsException("Array cheio!");
        jaulas[jaulasCount] = new Lion(n);
        jaulasCount++;
    }

    public void addWolf(String n) {
        if (jaulasCount == 10) throw new IndexOutOfBoundsException("Array cheio!");
        jaulas[jaulasCount] = new Wolf(n);
        jaulasCount++;
    }

    public Animal[] getJaulas(){
        return jaulas.clone();
    }
}
