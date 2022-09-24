package test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {

    public static void main(String[] args) {
        long[] numbers = {63};
//        long[] numbers = {1000000000000000L};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (long number : numbers) {
            String binaryString = toBinary(number);

            System.out.println(binaryString);

            boolean result = true;

            double height = 0;

            while (Math.pow(2, height) - 1 != binaryString.length()) {
                height++;
            }

            breakPoint : for (int i = 1; i < height; i++) {
                int start = (int) (Math.pow(2, i) - 1);
//                System.out.println("start " + start);

                int jump = (int) Math.pow(2, i + 1);
//                System.out.println("jump " + jump);

                int child = (int) Math.pow(2, i - 1);
//                System.out.println("child " + child);

                int jumpCount = (int) Math.pow(2, height - i - 1) - 1;
//                System.out.println(jumpCount);

                start -= jump;

                for (int j = 0; j <= jumpCount; j++) {
                    start += jump;
                    if (binaryString.charAt(start) == '1') {
                        continue;
                    }

                    if (binaryString.charAt(start - child) == '1' || binaryString.charAt(start + child) == '1') {
                        result = false;
                        break breakPoint;
                    }
                }
            }

            if (result) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }

        int[] a = new int[answer.size()];

        for (int i = 0; i < a.length; i++) {
            a[i] = answer.get(i);
        }

        return a;
    }

    private static String toBinary(long number) {
        StringBuilder sb = new StringBuilder();
        while (number >= 1) {
            long v = number % 2;
            sb.append(v);
            number /= 2;
        }

        String binary = sb.reverse().toString();

        System.out.println(binary);

        double n = 1;

        while (true) {
            double v = Math.pow(2, n) - 1;
            if (v >= binary.length()) {
                return padLeftZeros(binary, (int) (v));
            }
            n++;
        }
    }

    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

}
