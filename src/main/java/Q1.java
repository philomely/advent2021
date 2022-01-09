import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Q1 {
    public static void part1() throws IOException {
        int totalInc = 0;
        int last = Integer.MAX_VALUE;
        try(Stream<String> lines = Files.lines(Paths.get("input.txt"))){
            for( String line : (Iterable<String>) lines::iterator ) {
                int current = Integer.parseInt(line);
                if(current > last) {
                    totalInc+=1;
                }
                last = current;
            }
        }
    }

    public static void part2() {
        List<Integer> input = AdventUtil.readIntInput("input1.2.txt");
        int size = input.size();
        int start = 0;
        int cur = 0;
        int totalInc = 0;
        int lastSum = Integer.MAX_VALUE;

            cur = start;
            while(cur + 2< size) {
                int sum = input.get(cur) + input.get(cur + 1) + input.get(cur + 2);
                if(sum > lastSum) {
                    totalInc += 1;
                }
                cur += 1;
                lastSum = sum;
            }

        System.out.println(totalInc);
    }

    public static void main(String[] args) throws IOException {
        part2();
    }
}
