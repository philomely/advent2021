import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q18 {
    public static class EList {
        class Node{
            int v;
            int d;
            Node pre = null;
            Node next = null;
            Node(int v, int d) {
                this.v = v;
                this.d = d;
            }
        }

        public void addNode(int v, int d) {
            Node n = new Node(v, d);
            if(head == null) {
                head = tail = n;
            } else {
                n.pre = tail;
                tail.next = n;
                tail = n;
            }
        }

        Node head, tail = null;
        int offsetD = 0;
        EList(String in) {
            int d = 0;
            StringBuilder num = new StringBuilder();
            boolean readingNum = false;
            for(int i = 0; i<in.length(); i++) {
                char c = in.charAt(i);
                if(c == '[') {
                    d++;
                    readingNum = false;
                } else if(c== ']') {
                    if(readingNum) {
                        int n = Integer.parseInt(num.toString());
                        addNode(n, d);
                        num = new StringBuilder();
                    }
                    d--;
                    readingNum = false;
                } else if(c== ',') {
                    if(readingNum) {
                        int n = Integer.parseInt(num.toString());
                        addNode(n, d);
                        num = new StringBuilder();
                    }
                    readingNum = false;
                } else {
                    num.append(c);
                    readingNum = true;
                }
            }
        }

        @Override
        public String toString(){
            StringBuilder result = new StringBuilder();
            Node last = null;
            Node cur = head;
            boolean newPair = false;
            int braceDepth = 0;
            while(cur!=null) {
                if(last!=null) {

                    result.append(',');
                }

                if(cur.d>braceDepth) {
                    int k = cur.d - braceDepth;
                    braceDepth+=k;
                    while(k-->0)
                        result.append('[');
                    result.append(cur.v);
                    newPair = false;
                } else if(cur.d==braceDepth) {
                    if(newPair) {
                        result.append('[');
                        result.append(cur.v);
                        braceDepth++;

                    } else {
                        result.append(cur.v);
                        result.append(']');
                        braceDepth--;

                        Node t = last;
                        while(t!=null && t.pre!=null && t.d - t.pre.d == 1 && braceDepth>0) {
                            result.append(']');
                            braceDepth--;
                            t = t.pre;
                        }
                    }
                    if(braceDepth == 0) {
                        newPair = true;
                    } else {
                        newPair = false;
                    }

                } else {
                    int k = braceDepth - cur.d ;
                    while(k-->0)
                        result.append(']');
                    braceDepth-=k;
                    newPair = true;
                    result.append(cur.v);
                }
                last = cur;
                cur = cur.next;
            }
            int k = braceDepth;
            while(k-->0)
                result.append(']');
            return result.toString();
        }

        void add(EList l) {
            offsetD++;
            tail.next = l.head;
            l.head.pre = tail;
            process();
        }

        void process() {
            boolean go = true;
            while(go) {
                go = explode();
                if(go) continue;
                go = split();
            }
        }

        boolean explode() {
            Node last = head;
            Node cur = head.next;

            while(cur != null) {
                if(cur.d + offsetD > 4 &&  cur.d == last.d) {

                    if(last.pre!=null) {
                        last.pre.v += last.v;
                        last.pre.next = cur;
                        cur.pre = last.pre;
                    } else {
                        head = cur;
                        cur.pre = null;
                    }
                    if(cur.next!=null) {
                        cur.next.v+=cur.v;
                    }
                    cur.v = 0;
                    cur.d-=1;
                    Node t = cur.next;
                    int lastD = cur.d;
                    while(t!=null && t.d==lastD) {
                        t.d-=1;
                        t = t.next;
                        lastD--;
                    }
                    t = cur.pre;
                    lastD = cur.d;
                    while(t!=null && t.d==cur.d) {
                        t.d-=1;
                        t = t.pre;
                        lastD--;
                    }

                    return true;
                }
                last = cur;
                cur = cur.next;
            }
            return false;
        }

        public boolean split() {
            EList.Node cur = head;
            while(cur!=null && cur.v>=10) {
                int val = cur.v/2;
                int _val = cur.v-val;
                cur.v=val;
                cur.d+=1;
                Node newNode = new Node(_val, cur.d);
                newNode.next = cur.next;
                newNode.pre = cur;
                newNode.next.pre = newNode;
                cur.next = newNode;
                Node t = cur.next;
                while(t!=null && t.d<cur.d) {
                    t.d+=1;
                    t = t.next;
                }
                t = cur.pre;
                while(t!=null && t.d<cur.d) {
                    t.d+=1;
                    t = t.pre;
                }
                return true;
            }
            return false;
        }
    }



    public static void part1() throws IOException {
        List<String> input = AdventUtil.readStrInput("input18.txt");
        EList e1 = new EList(input.get(0));
        System.out.println(e1);
        EList e2 = new EList(input.get(1));
        //e1.add(e2);
        System.out.println(e2);
    }

    public static void part2() {
        List<String> input = AdventUtil.readStrInput("input18.txt");
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
        //part1();
        String s =
                "/a/../../b/../c//.//";
        String[] ss = s.split("/");
        Map copy = new LinkedHashMap<Integer, Integer>();
    }
}
