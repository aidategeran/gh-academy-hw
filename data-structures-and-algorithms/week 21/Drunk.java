import java.io.*;
import java.util.*;
 
public class Drunk {
    private static class Solution {
        public void run(InputReader in, PrintWriter out) {
            Queue<Integer> f = new LinkedList<>();
            Queue<Integer> s = new LinkedList<>();
            for (int i = 0, x; i < 5; i++) {
                x = in.nextInt();
                f.offer(x);
            }
            for (int i = 0, x; i < 5; i++) {
                x = in.nextInt();
                s.offer(x);
            }
            int answer = 0;
            while (!f.isEmpty() && !s.isEmpty() && answer < 1000000) {
                int x = f.poll();
                int y = s.poll();
                if ((x == 0 && y == 9) || (!(y == 0 && x == 9) && x > y)) {
                    f.offer(x);
                    f.offer(y);
                                  } else {
                    s.offer(x);
                    s.offer(y);
                }
                answer++;
            }
            if (answer == 1000000) {
                out.println("botva");
            } else {
                if (f.isEmpty()) {
                    out.println("second " + answer);
                } else {
                    out.println("first " + answer);
                }
            }
        }
    }
 
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solution = new Solution();
        solution.run(in, out);
      out.close();
    }
 
    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
  }
