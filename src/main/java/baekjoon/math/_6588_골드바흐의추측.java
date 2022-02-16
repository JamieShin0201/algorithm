package baekjoon.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _6588_골드바흐의추측 {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> primes = new ArrayList<>();
        boolean[] check = new boolean[MAX + 1];
        check[0] = true;
        check[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (check[i]) {
                continue;
            }

            primes.add(i);
            for (int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }

        while (true) {
            int number = sc.nextInt();
            if (number == 0) {
                break;
            }

            for (int i = 1; i < primes.size(); i++) {
                int prime = primes.get(i);
                if (!check[number - prime]) {
                    System.out.println(number + " = " + prime + " + " + (number - prime));
                    break;
                }
            }
        }
    }
}
