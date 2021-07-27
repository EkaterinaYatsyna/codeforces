package levelA;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class amusingJokeHashTable {
    private void solve() {

        String name = nextToken() + nextToken();
        String str = nextToken();

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            String letter = Character.toString(str.charAt(i));
            hashMap.put(letter, hashMap.get(letter) == null ? 1 : hashMap.get(letter) + 1);
        }

        boolean yes = yes(hashMap, name);

        System.out.println(yes ? "YES" : "NO");


    }

    private static boolean yes(HashMap<String, Integer> hashMap, String name) {
        for (int i = 0; i < name.length(); i++) {
            String letter = Character.toString(name.charAt(i));
            Integer val = hashMap.get(letter);
            if (val == null || val == 0) {
                return false;
            } else if (val == 1) {
                hashMap.remove(letter);
            } else {
                hashMap.put(letter, val - 1);
            }
        }
        return hashMap.isEmpty();
    }

    public static void main(String[] args) {
        new amusingJokeHashTable().run();
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
