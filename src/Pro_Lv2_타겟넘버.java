import java.util.function.BiFunction;

public class Pro_Lv2_타겟넘버 {
    private final static BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
    private final static BiFunction<Integer, Integer, Integer> minus = (x, y) -> x - y;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        return DFS(numbers, 0, 0, target);
    }

    private static int DFS(int[] numbers, int cur, int depth, int target) {
        if (depth == numbers.length) {
            if (cur == target) {
                return 1;
            }

            return 0;
        }

        return DFS(numbers, sum.apply(cur, numbers[depth]), depth + 1, target) + DFS(numbers, minus.apply(cur, numbers[depth]), depth + 1, target);
    }
}
