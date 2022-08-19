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

    private int plusBallcount(int number) {
        if (numbers.contains(number)) {
            return 1;
        }

        return 0;
    }

    private void removeNothing(int index) {
        if (!numbers.contains(balls[index])) {
            balls[index] = 0;
        }
    }

    public int countBalls() {
        int ballCount = 0;

        for (int i = 0; i < count; i++) {
            ballCount += plusBallcount(balls[i]);
            removeNothing(i);
        }

        return ballCount;
    }




    public static void main(String[] args) {
        Host host = new Host();
        for (Integer i : host.numbers) {
            System.out.print(i);
        }
        System.out.println();
        host.storeBalls("123");
        System.out.println(host.countBalls());
        System.out.print(Arrays.toString(host.balls));
    }
}
