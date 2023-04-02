import java.util.Arrays;

public class Pro_Lv2_뒤에있는큰수찾기 {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    private static int[] solution(int[] numbers) {
        int[] results = new int[numbers.length];
        Arrays.fill(results, -1);

        for (int i = numbers.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (numbers[j] > numbers[i]) {
                    results[i] = numbers[j];
                    break;
                } else {
                    if (results[j] == -1) {
                        break;
                    } else if (numbers[i] < results[j]) {
                        results[i] = results[j];
                        break;
                    }
                }
            }
        }

        return results;
    }
}
