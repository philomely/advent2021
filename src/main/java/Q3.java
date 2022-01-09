import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public static void part2() {
        List<String> input = AdventUtil.readStrInput("input3.txt");
        int len = input.get(0).length();
        int[] c = new int[len];
        List<String> remain = input;
        String p1="", p2="";
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < remain.size(); i++) {
                String cur = remain.get(i);
                c[k] += Character.getNumericValue(cur.charAt(k));
            }
            char mostc = '0';
            int mid = remain.size()/2;
            if(remain.size()%2==1) {
                mid += 1;
            }
            if(c[k]>=mid) {
                mostc = '1';
            }
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < remain.size(); i++) {
                String cur = remain.get(i);
                if(cur.charAt(k)==mostc) {
                    tempList.add(cur);
                }
            }
            remain = tempList;
            if(remain.size()==1) {
                p1 = remain.get(0);
                break;
            }
        }

        remain = input;
        c = new int[len];
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < remain.size(); i++) {
                String cur = remain.get(i);
                c[k] += Character.getNumericValue(cur.charAt(k));
            }
            char mostc = '0';
            int mid = remain.size()/2;
            if(remain.size()%2==1) {
                mid += 1;
            }
            if(c[k]<mid) {
                mostc = '1';
            }
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < remain.size(); i++) {
                String cur = remain.get(i);
                if(cur.charAt(k)==mostc) {
                    tempList.add(cur);
                }
            }
            remain = tempList;
            if(remain.size()==1) {
                p2 = remain.get(0);
                break;
            }
        }
        System.out.println(b2d(p1)*b2d(p2));
    }

    public static int b2d(String b) {
        int n = 0;
        int factor = 1;
        for(int i = b.length()-1; i>=0; i--) {
            if(b.charAt(i)=='1') {
                n += factor;

            }
            factor *= 2;
        }
        return n;
    }

    public static void part1() {
        List<String> input = AdventUtil.readStrInput("input2.txt");
        int factor = 1;
        int g = 0;
        int e = 0;
//        for(int i = len-1; i>=0; i--) {
//            if(c[i]>lines/2) {
//                g += factor;
//            } else {
//                e += factor;
//            }
//            factor*=2;
//        }
        System.out.println(g*e);
    }

    public static void main(String[] args) throws IOException {
        part2();
    }
}
