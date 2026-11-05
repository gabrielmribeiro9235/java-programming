package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int C = scanner.nextInt();
        int[] prices = new int[N];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scanner.nextInt();
        }

        int minPrice = prices[0] + C, maxProfit = 0;

        for (int price : prices) {
            if (price + C < minPrice) {
                minPrice = price + C;
            } else if (price > minPrice) {
                maxProfit += price - minPrice;
                minPrice = price;
            }
        }

        System.out.println(maxProfit);
    }
}
