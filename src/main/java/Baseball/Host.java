package Baseball;

import java.util.*;

public class Host {
    private final static Random random = new Random();
    private final static int count = 3;
    private final static int min = 1;
    private final static int max = 9;
    private final List<Integer> numbers;
    private int[] balls;

    private Host() {
        this.numbers = generateNumbers();
    }
    private static int generate1to9() {
        return random.nextInt(max - min + 1) + min;
    }
    private static List<Integer> generateNumbers() {
        Set<Integer> numberSet = new HashSet<>(count, 1);
        while (numberSet.size() < count) {
            numberSet.add(generate1to9());
        }

        return new ArrayList<>(numberSet);
    }

    public void storeBalls(String input) {
        int[] store = new int[count];

        for (int i = 0; i < count; i++) {
            store[i] = input.charAt(i) - '0';
        }

        balls = store;
    }

    private int plusBall(int number) {
        if (numbers.contains(number)) {
            return 1;
        }

        return 0;
    }

    public int countBalls() {
        int ballCount = 0;

        for (int i = 0; i < count; i++) {
            ballCount += plusBall(balls[i]);
        }

        return ballCount;
    }

    public int plusStrike(int index) {
        if (balls[index] == numbers.get(index)) {
            return 1;
        }

        return 0;
    }

    public int countStrike() {
        int strikeCount = 0;

        for (int i = 0; i < count; i++) {
            strikeCount += plusStrike(i);
        }

        return strikeCount;
    }
}
