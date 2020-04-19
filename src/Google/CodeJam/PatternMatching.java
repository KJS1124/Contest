package Google.CodeJam;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class PatternMatching {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = in.nextInt();
            String arr[] = new String[n];
            for (int i = 0; i < n; i++) arr[i] = in.nextString();
            String maxString = "";
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (maxString.length() < arr[i].length()) {
                    maxString = arr[i];
                    index = i;
                }
            }
            maxString = maxString.replace("*", "");
            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                int tempIndex = 0;
                int tempIndex2 = 0;

                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) == '*') {
                        String te = arr[i].substring(tempIndex2, j + 1);
                        te = te.replace("*", "");
                        if (te.length() > 0) {
                            if (maxString.indexOf(te, tempIndex) != -1) {
                                tempIndex = maxString.indexOf(te, tempIndex) + te.length();
                                tempIndex2 = j + 1;
                            } else {
                                isPossible = false;
                                break;
                            }
                        } else {
                            tempIndex2 = tempIndex2 + 1;
                        }
                    } else if (arr[i].length() - 1 == j) {
                        String te = arr[i].substring(tempIndex2, j + 1);
                        te = te.replace("*", "");
                        if (te.length() > 0) {
                            if (maxString.indexOf(te, tempIndex) != -1) {
                                tempIndex = maxString.indexOf(te, tempIndex) + te.length();
                                tempIndex2 = j + 1;
                            } else {
                                isPossible = false;
                                break;
                            }
                        } else {
                            tempIndex2 = tempIndex2 + 1;
                        }
                    }
                }
                if (!isPossible) break;

            }
            out.println("Case #" + test + ": " + (isPossible ? maxString : "*"));
        }
    }
}
