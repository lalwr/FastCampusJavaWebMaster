import java.util.Scanner;

//https://www.acmicpc.net/problem/2947
public class Algorithm_Bubble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count  = 0;
        int[] array = new int[5];

        array[0] = sc.nextInt();
        array[1] = sc.nextInt();
        array[2] = sc.nextInt();
        array[3] = sc.nextInt();
        array[4] = sc.nextInt();

        int j = 1;
        boolean change = false;

        while(true){
            for(int i =0 ; i <= 3; i++){
                if( array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    change = true;
                    System.out.println(array[0] + " " + array[1] + " " + array[2] + " " + array[3] + " " + array[4]);
                }
                j++;
            }

            if( change == false){
                break;
            }

            j =1;
            change = false;
        }


    }
}
