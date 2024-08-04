package br.edu.ifsp.list01;

import java.util.Locale;
import java.util.Scanner;

/*
    Um motorista de Uber estipula o preço de uma determinada viagem dada a quantidade de quilômetros percorrida.
    Para viagens de até X km, é cobrado um valor R$ V1 por km. Acima de X km, é cobrado o valor R$ V2.
    Faça um programa que leia X, V1, V2 e a quantidade de quilômetros A da viagem e imprima o valor total
    com duas casas decimais.

    Exemplos de entrada e saída:
    Entrada    	Saída
    100         75.00
    1.50
    1.25
    50
    Entrada    	Saída
    100         187.50
    1.50
    1.25
    150
*/
public class Ex07 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        final int x = scanner.nextInt();
        final double v1 = scanner.nextDouble();
        final double v2 = scanner.nextDouble();
        final double a = scanner.nextDouble();
        final Ex07 ex07 = new Ex07();
        System.out.println(ex07.compute(x,v1,v2,a));
    }

    double compute(int x, double v1, double v2, double a) {
        double preco;

        if (a == 0) {
            preco = 0;
        } else if (a > x) {
            preco = a * v2;
        } else {
            preco = a * v1;
        }

        return Double.parseDouble(String.format(Locale.US, "%.2f", preco));
    }
}
