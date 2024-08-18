import java.io.*;
import java.util.StringTokenizer;

public class VerySimpleProblem {
    private static class Solution {
        private void run(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            int left = 0;
            int right = (int) 1e9; // 10 to the power of 9
            int answer = -1;
            n--; //First copy will be printed in Math.min(x,y) time. Next copies will utilize both printers.

            while (left<=right) {
                int middle = left+(right-left)/2;
                //(middle/x) copies on the first printer
                //(middle/y) copies on the second printer
                if (middle/x + middle/y >= n) {
                    answer = middle;
                    right = middle -1;
                }else {
                    left = middle+1;
                }

            }
            System.out.println(Math.min(x,y) + answer);



        }

    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new Inputreader(inputStream);
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

        public int nextInt() {
            return 0;
        }
    }

    public String next() {
        StringTokenizer tokenizer;
        while (tokenizer == null || !tokenizer.hasMoreTokens()){
            try{
                tokenizer = new StringTokenizer(reader.readline());
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
}
