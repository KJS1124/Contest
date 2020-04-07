package VirtualContestCodeforces.Codeforces2;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class TaskB {
    static int minZeros = 100000;
    static String str;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int divide5[][] = new int[n][n];
        int divides2[][] = new int[n][n];
        boolean isDivisibleBy5[][] = new boolean[n][n];
        boolean isDivisibleBy2[][] = new boolean[n][n];
        boolean isZero = false;
        int zeroi = -1;
        int zeroj = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = in.nextInt();
                if (x == 0) {
                    isZero = true;
                    zeroi = i;
                    zeroj = j;
                } else {
                    while (x % 5 == 0) {
                        divide5[i][j]++;
                        x /= 5;
                    }
                    while (x % 2 == 0) {
                        divides2[i][j]++;
                        x /= 2;
                    }
                }
            }
        }
        int best5[][] = new int[n][n];
        int best2[][] = new int[n][n];
        findMinPath(n, divide5, isDivisibleBy5, zeroi, zeroj, best5);
        findMinPath(n, divides2, isDivisibleBy2, zeroi, zeroj, best2);
        int best = Math.min(isZero ? 1 : (int) 1e9, Math.min(best2[n - 1][n - 1], best5[n - 1][n - 1]));
        if (isZero && best == 1) {
            out.println(best);
            for (int i = 0; i < zeroi; i++)
                out.print('D');
            for (int i = 0; i < zeroj; i++)
                out.print('R');
            for (int i = 0; i < n - zeroi - 1; i++)
                out.print('D');
            for (int i = 0; i < n - zeroi - 1; i++)
                out.print('R');
            out.println();

        } else if (best == best5[n - 1][n - 1]) {
            out.println(best);
            print(n - 1, n - 1, best5, isDivisibleBy5, out);
            out.println();
        } else {
            out.println(best);
            print(n - 1, n - 1, best2, isDivisibleBy2, out);
            out.println();
        }
    }

    private void print(int i, int j, int[][] best2, boolean isDivible[][], OutputWriter out) {
        if (i == 0 && j == 0)
            return;
        if (i < 0 || j < 0)
            return;
        if (isDivible[i][j]) {

            print(i, j - 1, best2, isDivible, out);
            out.print("R");
        } else {
            print(i - 1, j, best2, isDivible, out);
            out.print("D");
        }
    }

    private void findMinPath(int n, int[][] divide5, boolean[][] isDivisibleBy5, int zeroi, int zeroj, int[][] best5) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                best5[i][j] = (int) 1e9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    if (zeroi != 0 && zeroj != 0)
                        best5[i][j] = divide5[i][j];
                } else {
                    if (i > 0 && best5[i - 1][j] + divide5[i][j] < best5[i][j])
                        best5[i][j] = best5[i - 1][j] + divide5[i][j];
                    if (j > 0 && best5[i][j - 1] + divide5[i][j] < best5[i][j]) {
                        best5[i][j] = best5[i][j - 1] + divide5[i][j];
                        isDivisibleBy5[i][j] = true;
                    }
                }
            }
        }
    }


}
