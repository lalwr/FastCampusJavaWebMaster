package Algorihtm02;

//https://codefights.com
// 반복되지 않는 첫번째 문자열을 반환하시오. 해당 문자가 없으면 '_'을 리턴
// 2개이상이면 먼저 중복인 문자열
public class Algorigtm_firstNotRepeatingCharacter {
    public static void main(String[] args) {
       String s = "abdacaba";
        System.out.println(firstNotRepeatingCharacter(s));
    }

    static char firstNotRepeatingCharacter(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(s.lastIndexOf(c)==s.indexOf(c))
            {
                return c;
            }
        }
        return '_';
    }
}

/*
Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

Example

For s = "abacabad", the output should be
firstNotRepeatingCharacter(s) = 'c'.

There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

For s = "abacabaabacaba", the output should be
firstNotRepeatingCharacter(s) = '_'.

There are no characters in this string that do not repeat.

Input/Output

[execution time limit] 3 seconds (java)

[input] string s

A string that contains only lowercase English letters.

Guaranteed constraints:
1 ≤ s.length ≤ 105.

[output] char

The first non-repeating character in s, or '_' if there are no characters that do not repeat.

*/
