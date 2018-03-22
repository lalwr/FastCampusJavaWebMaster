import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Algorithm_WordSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        String array[] = new String[count];

        HashSet hs = new HashSet();
        for(int i =0; i < count; i++){
            hs.add(sc.nextLine());
        }

        int size = hs.size();
        String[] wordArray = new String[size];
        hs.toArray(wordArray);

        Arrays.sort(wordArray, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for(int i=0; i<size; i++){

        }

        Arrays.sort(wordArray);

        for(int i =0; i < wordArray.length; i++){
            System.out.println(wordArray[i]);
        }

    }
}
