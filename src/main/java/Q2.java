import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Q2 {
    public static void part1() throws IOException {
        List<String> input = AdventUtil.readStrInput("input2.txt");
        int depth = 0;
        int pos = 0;
        for(String s:input) {
            String ss[] = s.split(" ");
            String cmd = ss[0];
            int n = Integer.parseInt(ss[1]);
            if (cmd.equals("forward")) {
                pos += n;
            } else if (cmd.equals("down")) {
                depth += n;
            } else if (cmd.equals("up")) {
                depth -= n;
            }
        }
        System.out.println(depth*pos);
    }

    public static void part2() {
        List<String> input = AdventUtil.readStrInput("input2.txt");
        int depth = 0;
        int pos = 0;
        int aim = 0;
        for(String s:input) {
            String ss[] = s.split(" ");
            String cmd = ss[0];
            int n = Integer.parseInt(ss[1]);
            if (cmd.equals("forward")) {
                pos += n;
                depth += (aim*n);
            } else if (cmd.equals("down")) {
                aim += n;
            } else if (cmd.equals("up")) {
                aim -= n;
            }
        }
        System.out.println(depth*pos);
    }

    public static void main(String[] args) throws IOException {
        part2();
    }
}
