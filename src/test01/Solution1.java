package test01;

class Solution1 {
    private int solution(String s) {
        int cur = 0;
        int max = -1;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(cur)) {
                if (i - cur == 2) {
                    int now = Integer.parseInt(s.substring(cur, i + 1));
                    if (now > max) {
                        max = now;
                    }
                }
            } else {
                cur = i;
            }
        }

        return max;
    }
}
