class Solution {
    private String s1;
    private String s2;
    private String s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return solve(0, 0, 0);
    }

    private boolean solve(int i, int j, int k){
        if(k == s3.length()) return true;
        
        if(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
            return solve(i + 1, j, k+1) || solve(i, j + 1, k + 1);
        }
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            return solve(i + 1, j, k+1);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            return solve(i, j + 1, k + 1);
        }
        return false;
    }
}
