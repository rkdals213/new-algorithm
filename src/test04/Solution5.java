package test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {

    public static void main(String[] args) {
//        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 2", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        System.out.println(Arrays.toString(solution(commands)));
    }

    private static String[] map;
    private static int[] root;

    public static String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        int size = 4;
        map = new String[size];
        root = new int[size];

        for (int i = 0; i < map.length; i++) {
            map[i] = "EMPTY";
            root[i] = i;
        }

        for (int i = 0; i < commands.length; i++) {
            String[] split = commands[i].split(" ");
            String command = split[0];
            System.out.println(Arrays.toString(split));

            if (command.equals("UPDATE")) {
                if (split.length == 4) {
                    String x = split[1];
                    String y = split[2];
                    String value = split[3];

                    int position = findPosition(x, y);
                    int r = find(position);

                    map[r] = value;

                    for (int j = 0; j < size; j++) {
                        if (find(j) == r) {
                            map[j] = value;
                        }
                    }
                }

                if (split.length == 3) {
                    String from = split[1];
                    String to = split[2];

                    for (int j = 0; j < size; j++) {
                        if (map[j].equals(from)) {
                            map[j] = to;
                        }
                    }
                }

            }

            if (command.equals("MERGE")) {
                String x1 = split[1];
                String y1 = split[2];
                String x2 = split[3];
                String y2 = split[4];

                int position1 = findPosition(x1, y1);
                int position2 = findPosition(x2, y2);

                int r = find(position1);

                String value = map[position1];

                union(position1, position2);

                for (int j = 0; j < size; j++) {
                    if (find(j) == r) {
                        map[j] = value;
                    }
                }
            }

            if (command.equals("UNMERGE")) {
                String x = split[1];
                String y = split[2];

                int position = findPosition(x, y);

                int r = find(position);
                String value = map[r];

                for (int j = 0; j < size; j++) {
                    if (find(j) == r) {
                        root[j] = j;
                        if (position == j) {
                            map[j] = value;
                        } else {
                            map[j] = "EMPTY";
                        }
                    }
                }
            }

            if (command.equals("PRINT")) {
                String x = split[1];
                String y = split[2];

                int position = findPosition(x, y);
                int r = find(position);

                answer.add(map[r]);
            }

            for (int k = 0; k < map.length; k++) {
                System.out.print(map[k] + "\t\t");

                if ((k + 1) % 2 == 0) {
                    System.out.println();
                }
            }

            for (int k = 0; k < map.length; k++) {
                System.out.print(root[k] + "\t\t");

                if ((k + 1) % 2 == 0) {
                    System.out.println();
                }
            }

        }

        String[] a = new String[answer.size()];

        for (int i = 0; i < a.length; i++) {
            a[i] = answer.get(i);
        }

        return a;
    }

    private static int findPosition(String x, String y) {
        return (Integer.parseInt(x) - 1) * 2 + Integer.parseInt(y) - 1;
    }


    private static void union(int a, int b) {
        int ta = find(a);
        int tb = find(b);

        if (ta == tb) return;

        root[tb] = ta;
    }

    private static int find(int t) {
        if (root[t] == t) return t;

        return root[t] = find(root[t]);
    }
}
