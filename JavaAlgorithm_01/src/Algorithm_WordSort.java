import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

//https://www.acmicpc.net/problem/1181
public class Algorithm_WordSort {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i, j, n = Integer.parseInt(in.readLine()), len, tmp, size;

        HashSet<String> hs = new HashSet<>(); //순서 상관없이 중복 제거하여 저장
        for(i=0;i<n;i++) hs.add(in.readLine()); //한줄씩 읽어서 저장

        size = hs.size();
        String arr[] = new String[size];
        hs.toArray(arr); //array 형태로 변환

        Arrays.sort(arr, new Comparator<String>(){ //길이순으로 문자 정렬
            public int compare(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
            }
        });

        for(i=0;i<size;i++){ //문자 길이별 사전순 정렬
            len = arr[i].length();
            for(j=i+1;j<size;j++){
                tmp = arr[j].length();
                if(len != tmp) break;
            }
            Arrays.sort(arr, i, j);
            i = j-1;
        }

        for(i=0;i<size;i++) System.out.println(arr[i]);
        in.close();

    }
}
