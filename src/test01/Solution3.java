package test01;

class Solution3 {
    private boolean[] visited;
    private int answer = -1;

    private int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, int depth) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (k >= dungeons[i][0]) {
                    dfs(k - dungeons[i][1], dungeons, depth + 1);

                }
                visited[i] = false;
            }
        }

        if (depth > answer) {
            answer = depth;
        }
    }
}