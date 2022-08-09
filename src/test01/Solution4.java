package test01;

import java.util.*;

class Solution4 {
    private String[] solution(int[] steps_one, String[] names_one, int[] steps_two, String[] names_two, int[] steps_three, String[] names_three) {
        Map<String, Integer> maps = new HashMap<>();

        for (int i = 0; i < steps_one.length; i++) {
            if (maps.containsKey(names_one[i])) {
                maps.replace(names_one[i], maps.get(names_one[i]) + steps_one[i]);
            } else {
                maps.put(names_one[i], steps_one[i]);
            }
        }


        for (int i = 0; i < steps_two.length; i++) {
            if (maps.containsKey(names_two[i])) {
                maps.replace(names_two[i], maps.get(names_two[i]) + steps_two[i]);
            } else {
                maps.put(names_two[i], steps_two[i]);
            }
        }


        for (int i = 0; i < steps_three.length; i++) {
            if (maps.containsKey(names_three[i])) {
                maps.replace(names_three[i], maps.get(names_three[i]) + steps_three[i]);
            } else {
                maps.put(names_three[i], steps_three[i]);
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (String key : maps.keySet()) {
            pq.add(new Point(key, maps.get(key)));
        }

        String[] answer = new String[maps.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll().name;
        }

        return answer;
    }
    private static class Point implements Comparable<Point> {
        String name;
        int count;

        public Point(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            if (this.count == o.count) {
                return this.name.compareTo(o.name);
            }
            return o.count - this.count;
        }
    }
}