package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        map = new int[20];
        rank = new int[20];

        for (int i = 0; i < map.length; i++) {
            map[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < a; i++) {
            String[] s = br.readLine().split(" ");

            union(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] != i) {
                set.add(find(i));
            }
        }

        System.out.println(Arrays.toString(map));

        System.out.println(set.size());
    }

    private static int[] map;
    private static int[] rank;

    private static void union(int a, int b) {
        int ta = find(a);
        int tb = find(b);

        if (ta == tb) return;

        if (rank[a] < rank[b]) {
            map[ta] = tb;
        } else {
            map[tb] = ta;

            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }

    }

    private static int find(int t) {
        if (map[t] == t) return t;

        return map[t] = find(map[t]);
    }
}
