package armstrongnumbers;

import java.math.BigInteger;
import java.util.Set;

import static java.lang.System.nanoTime;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Runner {

    private Armstrong armstrong = new Armstrong();

    public void exec(int level) {
        long start = nanoTime();

        Set<String> aNumbers = armstrong.level(level);

        long duration = SECONDS.convert(nanoTime() - start, NANOSECONDS);
        print(aNumbers, duration);

    }

    private void print(Set<String> set, long duration) {
        set.stream().map(BigInteger::new).sorted().forEach(System.out::println);
        System.out.printf(">> Found %d numbers in  %d sec\n", set.size(), duration);
    }

    public static void main(String[] args) {
        final Runner runner = new Runner();
        runner.exec(5);
    }
}
