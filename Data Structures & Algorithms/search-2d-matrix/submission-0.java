class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
		int n = matrix[0].length;
		int left = 0, right = m * n - 1, mid, x, y;
		while(left <= right) {
			mid = (left + right) / 2;
			x = mid / n;
			y = mid % n;
			if(matrix[x][y] == target) return true;
			if(matrix[x][y] < target) left = mid + 1;
			else right = mid - 1;
		}
		return false;
    }
}
