package flab.week3;

/*
'1'은 땅, '0'은 물일때 섬이 만들어지는 개수를 구하는 문제

https://gamjatwigim.tistory.com/146  참고
 */

public class NumberOfIslands_200 {

    class Solution {
        public int numIslands(char[][] grid) {

            int count = 0;

            for(int i=0; i<grid.length; i++){

                for(int j=0; j<grid[i].length; j++){
                    if(grid[i][j] == '1'){
                        mark(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

         public void mark(char[][] grid, int row, int col){  // 재귀함수

            grid[row][col] = '-';

            if(row < grid.length - 1 && grid[row+1][col] == '1'){
                mark(grid, row+1, col); // 상
            }
            if(row > 0 && grid[row-1][col] == '1'){
                mark(grid, row-1, col); // 하
            }
            if(col > 0 && grid[row][col-1] == '1'){
                mark(grid, row, col-1); // 좌
            }
            if(col < grid[row].length - 1 && grid[row][col+1] == '1'){
                mark(grid, row, col+1); //우
            }
        }
    }
}
