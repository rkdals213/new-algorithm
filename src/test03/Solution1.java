package test03;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public int solution(int[] T) {
        List<Integer> sister = new ArrayList<>();
        List<Integer> brother = new ArrayList<>();

        for (int i = 0; i < T.length; i++) {
            if (sister.size() < T.length / 2) {
                if (sister.contains(T[i])) {
                    brother.add(T[i]);
                } else {
                    sister.add(T[i]);
                }
            } else {
                brother.add(T[i]);

            }
        }

        return (int) sister.stream().distinct().count();
    }
}
