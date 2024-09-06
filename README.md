# Solution in Java for N-Queens Puzzle

## Problem definition
The n-queens puzzle is the problem of placing n queens on an n x n chessboard so that no two queens can attack each other.

A queen in a chessboard can attack horizontally, vertically, and diagonally.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a unique board layout where the queen pieces are placed. 'Q' indicates a queen and '.' indicates an empty space.

You may return the answer in any order.

Example 1:
Input: n = 4

Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There are two different solutions to the 4-queens puzzle.

Example 2:

Input: n = 1

Output: [["Q"]]
Constraints:

1 <= n <= 8

(Quoted from https://neetcode.io/problems/n-queens)

## Explanation
Backtracking (https://en.wikipedia.org/wiki/Backtracking) includes 3 steps:
- Choose: Select a path to explore
- Explore: Explore the chosen path
- Backtrack: If the chosen path doesn't lead to a solution, backtrack to a previous state and try another path

On the first row, we can place a queen in 1st, 2nd, ..., nth columns. We can start the first cell (1st column on the 1st row). We can't place the queen in the 1st column, or any other cell that are on the same diagonal (ie: 2nd column). 

There are two possiblities for diagonals. For the cells on the positive (or the right) diagonal, difference of x and y coordinates stay same. For example: (2,1) and (3,2). For the other diagonal the sum of them stays the same. For example: (2,1) and (1,2).

We keep trying all possible cells like this by eleminating the cells on the previously used columns or diagonals. If we can reach the last row, that is a solution, so we save this path. Otherwise, we backtrack (ie: undo our last move: remove the queen from the selected cell, and update seen columns and diagonals sets). 
