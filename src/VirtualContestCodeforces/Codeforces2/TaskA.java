package VirtualContestCodeforces.Codeforces2;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.*;

public class TaskA {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list1.add(in.nextString());
            list2.add(in.nextInt());
        }
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            addToMap(list1, list2, max, map, i);
        }


        max = 0;
        for (int x : map.values())
            max = Math.max(max, x);


        List<String> win = new ArrayList<>();
        for (Map.Entry e : map.entrySet())
            if ((int) e.getValue() == max)
                win.add((String) e.getKey());
        map.clear();
        for (int i = 0; i < list1.size(); i++) {
            addToMap(list1, list2, max, map, i);

            if (map.get(list1.get(i)) >= max && win.contains(list1.get(i))) {
                System.out.println(list1.get(i));
                break;
            }
        }
    }

    private void addToMap(List<String> list1, List<Integer> list2, int max, Map<String, Integer> map, int i) {
        if (map.containsKey(list1.get(i))) {
            int x = map.get(list1.get(i));
            x += list2.get(i);
            map.put(list1.get(i), x);
        } else {
            map.put(list1.get(i), list2.get(i));
        }

    }

}
