package Class2_0108;

import java.util.Locale;
import java.util.Scanner;

/*
    Sabe-se que uma lata de tinta tem um custo C e é capaz de pintar uma área de M metros quadrados.
    Faça um programa que leia a largura L, a altura A de uma parede, o valor C de uma lata de tinta e
    o rendimento M desta lata. Após isso, imprima quantas latas de tintas são necessárias e o custo
    total (com duas casas decimais). Assuma que não é possível comprar lata de tinta fracionada.

    Exemplos de entrada e saída:
    Entrada   	Saída
    4           4 20.00
    3
    5
    3

    Entrada	    Saída
    10.0        3 15.00
    2.0
    5.0
    7
*/

import java.util.Locale;

public class Ex06 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        final double L = scanner.nextDouble();
        final double a = scanner.nextDouble();
        final double c = scanner.nextDouble();
        final double m = scanner.nextDouble();
        final Ex06 ex06 = new Ex06();
        System.out.println(ex06.compute(L, a, c, m));
    }

    String compute(double L, double a, double c, double m) {
        final double area = L * a;
        int latas;
        double preco;

        if (area == 0 || m == 0) {
            latas = 0;
            preco = 0;
        } else if (m > area) {
            latas = 1;
            preco = c;
        } else {
            latas = (int)Math.ceil(area / m);
            preco = latas * c;
        }

        return String.format(Locale.US, "%d %.2f", latas, preco);
    }
}
