import java.util.*;

public class Pro_Lv2_무인도여행 {
    public static void main(String[] args) {
        String[] map1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] map2 = {"XXX", "XXX", "XXX"};

        System.out.println(Arrays.toString(solution(map1)));
        System.out.println(Arrays.toString(solution(map2)));
    }

    private static char[][] map;
    private static boolean[][] visited;
    private static final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            char[] line = maps[i].toCharArray();
            System.arraycopy(line, 0, map[i], 0, maps[i].length());
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (visited[i][j] || isNotPath(i, j)) {
                    continue;
                }

                visited[i][j] = true;
                result.add(BFS(new Point(i, j)));
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        return result.stream()
                .mapToInt(it -> it)
                .sorted()
                .toArray();
    }

    private static int BFS(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        int result = 0;

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();
            result += map[currentPoint.x][currentPoint.y] - 48;

            for (int[] dir : dirs) {
                int nextX = currentPoint.x + dir[0];
                int nextY = currentPoint.y + dir[1];

                if (isNotIn(nextX, nextY) || isNotPath(nextX, nextY) || visited(nextX, nextY)) {
                    continue;
                }

                visited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY));
            }
        }

        return result;
    }


    private static boolean isNotIn(int x, int y) {
        return x < 0 || x >= map.length || y < 0 || y >= map[0].length;
    }

    private static boolean isNotPath(int x, int y) {
        return map[x][y] == 'X';
    }

    private static boolean visited(int nextX, int nextY) {
        return visited[nextX][nextY];
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
