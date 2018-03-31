package Algorihtm02;

import java.util.HashSet;

//https://codefights.com
// 2개 이상인 숫자 찾기
// 2개 이상인 숫자가 2개 이상인경우 2번쨰 발생한 중복 숫자의 인덱스가 작은 것을 숫자를 출력한다.
public class Algorigtm_firstDuplicate {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 1, 5, 2};
        int[] b = {2, 4, 3, 5, 1};

        System.out.println(firstDuplicate(b));

    }

    static int  firstDuplicate(int[] a) {
        HashSet<Integer> set = new HashSet();
        for (int i=0; i<a.length; i++){
            if(set.contains(a[i])){
                return a[i];
            }
            else{
                set.add(a[i]);
            }
        }
        return -1;
    }
}
/*
Note: Write a solution with O(n) time complexity and O(1) additional space complexity, since this is what you would be asked to do during a real interview.

Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number for which the second occurrence has the minimal index. In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence has a smaller index than the second occurrence of the other number does. If there are no such elements, return -1.

Example

For a = [2, 3, 3, 1, 5, 2], the output should be
firstDuplicate(a) = 3.

There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than than second occurrence of 2 does, so the answer is 3.

For a = [2, 4, 3, 5, 1], the output should be
firstDuplicate(a) = -1.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 105,
1 ≤ a[i] ≤ a.length.

[output] integer

The element in a that occurs in the array more than once and has the minimal index for its second occurrence. If there are no such elements, return -1.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}


*/
