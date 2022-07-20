import java.util.Arrays;

public class Pro_LV2_전화번호목록 {
    public static void main(String[] args) {
        String[] text = {"119", "97674223", "1195524421"};
        System.out.println(solution(text));
    }

    private static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
