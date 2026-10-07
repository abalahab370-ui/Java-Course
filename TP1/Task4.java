package TP1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount in cents: ");
        int amount = sc.nextInt();

        if (amount < 0 || amount > 9999) {
            System.out.println("Invalid amount");
            sc.close();
            return;
        }

        int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};

        for (int coin : coins) {
            int count = amount / coin;
            amount %= coin;
            System.out.println(coin + "c: " + count);
        }

        sc.close();
    }
}