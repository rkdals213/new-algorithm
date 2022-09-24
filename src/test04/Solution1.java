package test04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] term = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(solution(today, term, privacies)));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String registerDate = split[0];
            String type = split[1];

            String term = Arrays.stream(terms)
                    .filter(it -> it.contains(type))
                    .findFirst()
                    .get()
                    .split(" ")[1];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate target = LocalDate.parse(registerDate, formatter).plusMonths(Long.parseLong(term)).minusDays(1);
            LocalDate todayDate = LocalDate.parse(today, formatter);

            if (target.isBefore(todayDate)) {
                answer.add(i + 1);
            }
        }
        int[] a = new int[answer.size()];

        for (int i = 0; i < a.length; i++) {
            a[i] = answer.get(i);
        }

        return a;
    }
}
