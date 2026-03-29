class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += expand(s, i, i);
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                count += expand(s, i, i + 1);
            }
        }
        return count;
    }

    private int length(int[] nums){
        return nums[1] - nums[0] + 1;
    }

    private int expand(String str, int left, int right){
        int count = 1;
        while(  left > 0 && 
                right < str.length() -1 && 
                str.charAt(left - 1) == str.charAt(right + 1)){
                    left--;
                    right++;
                    count++;
        }
        return count;
    }
    
}
