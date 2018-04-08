package Algorihtm03;

// https://codefights.com
/*
   스도쿠는 숫자 배치 퍼즐입니다.
   목적은 그리드를 구성하는 9x3 서브 그리드의 각 열, 각 행 및 각 9x9 서브 그리드 모두가
   1에서 9까지의 모든 숫자를 한 번에 포함하는 방식으로 9x9 그리드에 숫자를 채우는 것입니다 .
*/

import java.util.Arrays;

public class Algorigtm_sudoku2 {
    public static void main(String[] args) {
        //true
        char[][] grid = {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                        {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                        {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                        {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                        {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                        {'.', '.', '.', '5', '.', '.', '.', '7', '.'} };

        //false
        char[][] grid2 = {{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                        {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                        {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                        {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                        {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                        {'.', '2', '.', '.', '3', '.', '.', '.', '.'}};

        System.out.println(sudoku2(grid));
    }

    static boolean sudoku2(char[][] grid) {
        for (int i = 0; i < 9; i++) {

            char[] row = new char[9];
            char[] square = new char[9];
            char[] column = grid[i].clone();

            for (int j = 0; j < 9; j ++) {
                row[j] = grid[j][i];
                square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (!(validate(column) && validate(row) && validate(square)))
                return false;
        }
        return true;
    }

    static private boolean validate(char[] check) {
        String i = "";
        Arrays.sort(check);
        for (char number : check) {
            if(i.indexOf(number)!=-1 && number!='.')
                return false;
            if(number!='.')
                i+=number;
        }
        return true;
    }

}
/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false.
*/