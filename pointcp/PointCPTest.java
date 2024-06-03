import design3.PointCP3;
import design2.PointCP2;
import design5.PointCP5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PointCPTest {

    private static final int NUM_INSTANCES = 1000;
    private static final int NUM_ITERATIONS = 1000000; // Increased iterations

    public static void main(String[] args) {
        List<Long> timesPointCP3GetX = new ArrayList<>();
        List<Long> timesPointCP3GetY = new ArrayList<>();
        List<Long> timesPointCP3GetRho = new ArrayList<>();
        List<Long> timesPointCP3GetTheta = new ArrayList<>();

        List<Long> timesPointCP2GetX = new ArrayList<>();
        List<Long> timesPointCP2GetY = new ArrayList<>();
        List<Long> timesPointCP2GetRho = new ArrayList<>();
        List<Long> timesPointCP2GetTheta = new ArrayList<>();

        // Run the performance test multiple times
        for (int i = 0; i < 10; i++) {
            runPerformanceTest(timesPointCP3GetX, timesPointCP3GetY, timesPointCP3GetRho, timesPointCP3GetTheta,
                    timesPointCP2GetX, timesPointCP2GetY, timesPointCP2GetRho, timesPointCP2GetTheta);
        }

        printResults("PointCP3 getX", timesPointCP3GetX);
        printResults("PointCP3 getY", timesPointCP3GetY);
        printResults("PointCP3 getRho", timesPointCP3GetRho);
        printResults("PointCP3 getTheta", timesPointCP3GetTheta);

        printResults("PointCP2 getX", timesPointCP2GetX);
        printResults("PointCP2 getY", timesPointCP2GetY);
        printResults("PointCP2 getRho", timesPointCP2GetRho);
        printResults("PointCP2 getTheta", timesPointCP2GetTheta);
    }

    private static void runPerformanceTest(List<Long> timesPointCP3GetX, List<Long> timesPointCP3GetY,
                                           List<Long> timesPointCP3GetRho, List<Long> timesPointCP3GetTheta,
                                           List<Long> timesPointCP2GetX, List<Long> timesPointCP2GetY,
                                           List<Long> timesPointCP2GetRho, List<Long> timesPointCP2GetTheta) {
        Random random = new Random();

        PointCP3[] points3 = new PointCP3[NUM_INSTANCES];
        PointCP2[] points2 = new PointCP2[NUM_INSTANCES];

        for (int i = 0; i < NUM_INSTANCES; i++) {
            points3[i] = new PointCP3(random.nextDouble() * 100, random.nextDouble() * 100);
            points2[i] = new PointCP2(random.nextDouble() * 100, random.nextDouble() * 360);
        }

        timesPointCP3GetX.add(measureMethodExecution(points3, PointCP3::getX));
        timesPointCP3GetY.add(measureMethodExecution(points3, PointCP3::getY));
        timesPointCP3GetRho.add(measureMethodExecution(points3, PointCP3::getRho));
        timesPointCP3GetTheta.add(measureMethodExecution(points3, PointCP3::getTheta));

        timesPointCP2GetX.add(measureMethodExecution(points2, PointCP2::getX));
        timesPointCP2GetY.add(measureMethodExecution(points2, PointCP2::getY));
        timesPointCP2GetRho.add(measureMethodExecution(points2, PointCP2::getRho));
        timesPointCP2GetTheta.add(measureMethodExecution(points2, PointCP2::getTheta));
    }

    private static <T extends PointCP5> long measureMethodExecution(T[] points, MethodExecutor<T> executor) {
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            executor.execute(points[i % points.length]);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // Convert to milliseconds
    }

    private static void printResults(String methodName, List<Long> times) {
        Collections.sort(times);
        long median = times.get(times.size() / 2);
        long min = times.get(0);
        long max = times.get(times.size() - 1);

        System.out.println(methodName + ": ");
        System.out.println("Median time: " + median + " ms");
        System.out.println("Minimum time: " + min + " ms");
        System.out.println("Maximum time: " + max + " ms");
        System.out.println();
    }

    @FunctionalInterface
    private interface MethodExecutor<T> {
        void execute(T instance);
    }
}
