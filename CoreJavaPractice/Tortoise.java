import java.util.Arrays;

public class Tortoise {
    public static int[] race(int v1, int v2, int g) {

        if (v1 > v2) return null;

        int secondsNeeded = 1;

        int v2Distance = distance(secondsNeeded, v2);
        int v1Distance = distance(secondsNeeded, v1) + g;

        while (v2Distance != v1Distance) {
            secondsNeeded++;
            v2Distance = distance(secondsNeeded, v2);
            v1Distance = distance(secondsNeeded, v1) + g;
        }

        int[] solution = new int[3];
        System.out.println(secondsNeeded);
        System.out.println( (g*3600) / (v2-v1) );

        solution[2] = secondsNeeded;

        solution[1] = (int) Math.ceil(secondsNeeded / 60);
        System.out.println(solution[1]);
        solution[2] /= 60;
        solution[0] = solution[1] / 60;
        solution[1] /= 60;
        System.out.println(Arrays.toString(solution));
        return solution;

    }

    public static int distance(int seconds, int ratePerHour) {
        double ratePerMinute = ratePerHour / 60.0;
        double ratePerSecond = ratePerMinute / 60.0;
        return (int) (seconds * ratePerSecond);
    }
}

