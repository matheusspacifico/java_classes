package Class2_0108;

/*
    A avenida principal da cidade de Algoritmopolis possui limite de velocidade de L km/h.
    Se o motorista ultrapassar essa velocidade, é aplicado uma multa de R$ M, mais R$ A
    por cada km acima do limite. Faça um programa que leia o limite L, o valor da multa M,
    o valor adicional A e a velocidade V captada pelo radar e informe o valor total da multa.
    Considere L e V sempre como números inteiros. Apresente a resposta com duas casas decimais.

    Exemplos de entrada e saída:
    Entrada	    Saída
    60          200.00
    150.00
    10.00
    65

    Entrada	    Saída
    60          0.00
    150.00
    10.00
    50
*/

import java.util.Locale;
import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // troca a virgula pelo ponto no terminal
        final int L = scanner.nextInt();
        final double m = scanner.nextDouble();
        final double a = scanner.nextDouble();
        final int v = scanner.nextInt();
        final Ex05 ex05 = new Ex05();
        System.out.println(ex05.compute(L, m, a, v));
    }

    String compute(int L, double m, double a, int v) {
        if (v <= L) return "0.00";

        int aboveSpeed = v - L;
        double multa = m + (aboveSpeed * a);

        return String.format(Locale.US, "%.2f", multa);
    }
}