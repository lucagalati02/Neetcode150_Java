import java.io.*;
import java.util.*;

public class MathAndGeometry {
    public List<Integer> spiralOrder(int[][] matrix) {
        //https://neetcode.io/problems/spiral-matrix
        //32:29
        int l = matrix.length;
        if (l == 0) return new ArrayList<>();
        int w = matrix[0].length;
        int total = l * w;

        boolean[][] visited = new boolean[l][w];
        List<Integer> result = new ArrayList<>(total);

        int row = 0, col = 0;
        char dir = 'E';

        while (result.size() < total) {
            result.add(matrix[row][col]);
            visited[row][col] = true;

            if (dir == 'E') {
                if (col + 1 < w && !visited[row][col + 1]) {
                    col++;
                } else {
                    dir = 'S';
                    row++;
                }
            }
            else if (dir == 'S') {
                if (row + 1 < l && !visited[row + 1][col]) {
                    row++;
                } else {
                    dir = 'W';
                    col--;
                }
            }
            else if (dir == 'W') {
                if (col - 1 >= 0 && !visited[row][col - 1]) {
                    col--;
                } else {
                    dir = 'N';
                    row--;
                }
            }
            else {
                if (row - 1 >= 0 && !visited[row - 1][col]) {
                    row--;
                } else {
                    dir = 'E';
                    col++;
                }
            }
        }

        return result;
    }

}
