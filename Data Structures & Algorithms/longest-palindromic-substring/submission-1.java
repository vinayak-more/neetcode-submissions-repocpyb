class Solution {
    public String longestPalindrome(String s) {
        int[] max = {0,0};
        for(int i = 0; i < s.length(); i++){
            int[] curr = expand(s, i, i);
            if(length(curr) > length(max)) max = curr;
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                curr = expand(s, i, i + 1);
                if(length(curr) > length(max)) max = curr;
            }
        }

        return s.substring(max[0], max[1] + 1);

    }

    private int length(int[] nums){
        return nums[1] - nums[0] + 1;
    }

    private int[] expand(String str, int left, int right){
        while(  left > 0 && 
                right < str.length() -1 && 
                str.charAt(left - 1) == str.charAt(right + 1)){
                    left--;
                    right++;
        }
        return new int[] {left, right};
    }

    
}
