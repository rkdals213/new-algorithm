import java.util.LinkedList;
import java.util.Queue;

public class Pro_Lv2_미로탈출 {
    public static void main(String[] args) {
        String[] map1 = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        String[] map2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        System.out.println(solution(map1));
        System.out.println(solution(map2));
    }

    private static char[][][] map;
    private static boolean[][][] visited;
    private static final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()][2];
        visited = new boolean[maps.length][maps[0].length()][2];

        for (int i = 0; i < maps.length; i++) {
            char[] line = maps[i].toCharArray();
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j][0] = line[j];
                map[i][j][1] = line[j];
            }
        }
        Point startPoint = findPoint();

        if (startPoint == null) {
            return -1;
        }

        return BFS(startPoint);
    }

    private static int BFS(Point startPoint) {
        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);

        while (!q.isEmpty()) {
            Point currentPoint = q.poll();

            for (int[] dir : dirs) {
                int nextX = currentPoint.x + dir[0];
                int nextY = currentPoint.y + dir[1];

                if (isNotIn(nextX, nextY) || isNotPath(nextX, nextY, currentPoint.lever) || visited(nextX, nextY, currentPoint.lever)) {
                    continue;
                }

                if (currentPoint.lever == 1 && map[nextX][nextY][currentPoint.lever] == 'E') {
                    return currentPoint.step + 1;
                }

                if (map[nextX][nextY][currentPoint.lever] == 'L') {
                    visited[nextX][nextY][1] = true;
                    q.add(new Point(nextX, nextY, 1, currentPoint.step + 1));
                } else {
                    visited[nextX][nextY][currentPoint.lever] = true;
                    q.add(new Point(nextX, nextY, currentPoint.lever, currentPoint.step + 1));
                }
            }
        }

        return -1;
    }

    private static boolean visited(int nextX, int nextY, int lever) {
        return visited[nextX][nextY][lever];
    }

    private static Point findPoint() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j][0] == 'S') {
                    return new Point(i, j, 0, 0);
                }
            }
        }

        return null;
    }

    private static boolean isNotIn(int x, int y) {
        return x < 0 || x >= map.length || y < 0 || y >= map[0].length;
    }

    private static boolean isNotPath(int x, int y, int l) {
        return map[x][y][l] == 'X';
    }

    private static class Point {
        int x;
        int y;
        int lever;
        int step;

        public Point(int x, int y, int lever, int step) {
            this.x = x;
            this.y = y;
            this.lever = lever;
            this.step = step;
        }
    }
}
