package Baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Host {
    private final static Random random = new Random();
    private final static int count = 3;
    private final static int min = 1;
    private final static int max = 9;
    private final int[] numbers;

    private Host() {
        this.numbers = generateNumbers();
    }
    private static int generate1to9() {
        return random.nextInt(max - min + 1) + min;
    }
    private static int[] generateNumbers() {
        Set<Integer> numberSet = new HashSet<>(count, 1);
        while (numberSet.size() < count) {
            numberSet.add(generate1to9());
        }

        return numberSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] ints = generateNumbers();
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
