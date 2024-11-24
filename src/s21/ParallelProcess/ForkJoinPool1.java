package s21.ParallelProcess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinPool1 {
    public static void main(String[] args) throws Exception {

        int numbersLength = 100_000;
        long[] numbers = new Random().longs(numbersLength,
                1, numbersLength).toArray();

        long sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

        ForkJoinPool threadpool = ForkJoinPool.commonPool();

        List<Callable<Long>> tasks = new ArrayList<>();

        int taskNo = 10;
        int splitCount = numbersLength / taskNo;
        for (int i = 0; i < taskNo; i++) {
            int start = i * splitCount;
            int end = start + splitCount;
            tasks.add(() -> {
                long tasksum = 0;
                for (int j = start; j < end; j++) {
                    tasksum += (long) numbers[j];
                }
                return tasksum;
            });
        }

        List<Future<Long>> futures = threadpool.invokeAll(tasks);

        System.out.println("CPUs: "+Runtime.getRuntime().availableProcessors());
        System.out.println("Parallelism = " + threadpool.getParallelism());
        System.out.println("Pool Size = " + threadpool.getPoolSize());
        System.out.println("Steal Count = " + threadpool.getStealCount());
        long taskSum = 0;
        for (Future<Long> future : futures) {
            taskSum += future.get();
        }

        System.out.println("Thread pool Sum = " + taskSum);

        threadpool.shutdown();

        System.out.println(threadpool.getClass().getName());

    }
}
