class Solution {
    private static final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(dp[i][j] == 0){
                    max = Math.max(max, solve(i, j, matrix, dp));
                }
            }
        }
        return max;
    }

    private int solve(int i, int j, int[][] matrix, int[][] dp){
        if(dp[i][j] != 0) return dp[i][j];
        int max = 0;
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= matrix.length) continue;
            if(y < 0 || y >= matrix[x].length) continue;
            if(matrix[x][y] <= matrix[i][j]) continue;
            max = Math.max(max, solve(x, y, matrix, dp));
        }
        return dp[i][j] = max + 1;
    }
}
