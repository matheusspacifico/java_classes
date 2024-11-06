package Class7_1710;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            palavras.add(scanner.nextLine());
        }

        StringJoiner joiner = new StringJoiner("; ");
        palavras.forEach(joiner::add);
        System.out.println(joiner);

        Collections.sort(palavras);
        palavras.stream().distinct().forEach(System.out::println);
        // OR Set<String> palavrasDistinct = new HashSet<>(palavras);

        Map<String, Long> frequencyMap = palavras.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        scanner.close();
    }
}
