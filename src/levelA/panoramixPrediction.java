package levelA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class panoramixPrediction {
    private void solve() {
        int first = nextInt();
        int second = nextInt();
        int next = 0;

        for (int i = first + 1; i < second + 1; i++) {
            if (i == 2 || i == 3 || i == 5 || i == 7 || (i % 2 > 0 && i % 3 > 0 && i % 5 > 0 && i % 7 > 0)) {
                next = i;
                break;
            }

        }

        System.out.println(second == next ? "YES" : "NO");
    }


    public static void main(String[] args) {
        new panoramixPrediction().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            this.reader = reader;
            this.writer = writer;
            this.tokenizer = null;
            solve();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    private int nextInt(int radix) {
        return Integer.parseInt(nextToken(), radix);
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong(int radix) {
        return Long.parseLong(nextToken(), radix);
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return IntStream.range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
        return IntStream.range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    private double[][] nextDoubleMatrix(final int n, final int m) {
        return IntStream.range(0, n).mapToObj(i -> nextArrD(m)).toArray(double[][]::new);
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    private void printf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void print(Object o) {
        writer.print(o);
    }

    private void println() {
        writer.println();
    }

    private void println(Object o) {
        print(o);
        println();
    }

    private void flush() {
        writer.flush();
    }
}
