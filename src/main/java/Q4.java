import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4 {
    public static void part1() throws IOException {
        List<String> input = AdventUtil.readStrInput("input4.txt");
        String nums = input.get(0);
        int len = input.size() - 1;
        Map<String, Integer> c2pos = new HashMap<>();
        int pos = 0;
        for(int i = 2; i<len; i++) {
            if(! input.get(i).isEmpty()) {
                String[] strs = input.get(i).split("\\s+");
                for(int j = 0; j<strs.length; j++) {
                    c2pos.put(strs[j], pos);
                    pos+=1;
                }
            }
        }
        int blockNum = len/6;
        int[] counter = new int[blockNum];
        for(int i = 0; i<nums.length(); i++) {
            char c = nums.charAt(i);
            int _pos = c2pos.get(c);
            int line = _pos/5;
            int lineInBlock = _pos%5;
            counter[line]+=1;
            if(line == 5) {
                int blockN = line/5;
                int start = blockN*6;
                int sum = 0;
                for(int k = 0; k<5; k++ ) {
                    if(k != lineInBlock) {
                        String s = input.get(start + k);
                        String[] strs = s.split(" ");
                        for(int n = 0; n < 5; n++) {
                            sum += Integer.parseInt(strs[n]);
                        }
                    }
                }
                System.out.println(sum * Character.getNumericValue(c));
                break;
            }
        }
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
        part1();
    }
}
