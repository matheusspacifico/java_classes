package Class2_0108;

import java.util.Locale;
import java.util.Scanner;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o tamanho do array: ");
        final int tamanho = scanner.nextInt();
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            System.out.printf("Digite o valor %d do array: ", i+1);
            array[i] = scanner.nextInt();
        }
        System.out.print("Array digitado: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
        final Ex09 ex09 = new Ex09();
        System.out.println(ex09.compute(array));
    }

    String compute(int[] input) {
        final int tamanho = (input.length) - 1; // - 1 porque o ultimo numero do array é irrelevante
        int somaIdades = 0;
        int deMaior = 0;
        int idosos = 0;

        for (int idade : input) {
            if (idade < 0) break;
            if (idade >= 18) deMaior++;
            if (idade > 75) idosos++;
            somaIdades += idade;
        }

        final double media = (double)somaIdades / tamanho;
        final double porcentagemIdoso = (double)idosos / tamanho * 100;

        return String.format(Locale.US, "%.2f %d %.2f%%", media, deMaior, porcentagemIdoso);
    }
}
