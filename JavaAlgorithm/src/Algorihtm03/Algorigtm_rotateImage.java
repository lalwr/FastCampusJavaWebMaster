package Algorihtm03;

// https://codefights.com
// 이미지를 나타내는 n x n 차원 행렬이 주어집니다. 이미지를 시계 방향으로 90도 회전하십시오.
// 알고리즘 설명 : https://code.i-harness.com/ko/q/a617
public class Algorigtm_rotateImage {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5}, {6, 7, 8 ,9, 10}, {11, 12, 13 ,14, 15}, {16, 17, 18 ,19, 20}, {21, 22, 23 ,24, 25}};
        rotateImage(a);
        
        /* display */
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] rotateImage(int[][] a) {
        int n = a.length;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n-i-1; j++){
                System.out.println("i: " + i + " j: " + j);
                System.out.println("tmpe :" + a[i][j]);
                System.out.println("a[i][j] : " + a[i][j] + " a[n-j-1][i] : " + a[n-j-1][i]);
                System.out.println("a[n-j-1][i] : " + a[n-j-1][i] + " a[n-1-i][n-1-j] : " + a[n-1-i][n-1-j]);
                System.out.println("a[n-1-i][n-1-j] : " + a[n-1-i][n-1-j] + " a[j][n-1-i] : " + a[j][n-1-i]);
                System.out.println("a[j][n-1-i] : " + a[j][n-1-i] + " temp : " + a[i][j]);
                System.out.println("------------------------------");
                int temp = a[i][j];
                a[i][j] = a[n-j-1][i];
                a[n-j-1][i] = a[n-1-i][n-1-j];
                a[n-1-i][n-1-j] = a[j][n-1-i];
                a[j][n-1-i] = temp;
            }
        }
        return a;
    }
}
/*
Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

Example

For

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 100,
a[i].length = a.length,
1 ≤ a[i][j] ≤ 104.

[output] array.array.integer
*/
