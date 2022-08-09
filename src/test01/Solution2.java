package test01;

import java.util.*;

class Solution2 {
    private int solution(int[] levels) {
        int answer = 0;

        if (levels.length < 4) {
            return -1;
        }

        Arrays.sort(levels);

        int size = levels.length;

        int cur = size / 4;

        return levels[size - cur];
    }
}