package Algorihtm03;

import java.util.Scanner;

public class Algorigtm_factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = n / 5 + n / 25 + n / 125;
        System.out.println(result);
    }
}
