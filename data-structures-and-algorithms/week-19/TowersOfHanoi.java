import java.io.*;
import java.util.StringTokenizer;
 
public class Hanoi {
    private static class Solution {
        private void hanoi(int n, int from, int to) {
            if (n == 0) return;
            int aux = (1 + 2 + 3) - (from + to);
            hanoi(n - 1, from, aux);
            System.out.println(n + " " + from + " " + to);
            hanoi(n - 1, aux, to);
        }
 
        public void run(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            hanoi(n, 1, 3);
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
