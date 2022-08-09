package test02;

public class Solution1 {
    public static void main(String[] args) {
        String a = "abcdefghijklmnopqrstuvwxy";
        String b = "abcdefghijklmnopqrstuvwxyz";

        long pow = (long) Math.pow(a.length(), b.length() - 1);
        System.out.println(pow);

        dfs(a, b, 0, new char[b.length() - 1]);
    }


    private static void dfs(String delimiter, String element, int depth, char[] array) {
        if (depth == delimiter.length()) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < delimiter.length(); i++) {
                sb.append(element.charAt(i));
                sb.append(array[i]);
            }
            sb.append(element.charAt(element.length() - 1));
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < delimiter.length(); i++) {
            array[depth] = delimiter.charAt(i);
            dfs(delimiter, element, depth + 1, array);
        }
    }
}
