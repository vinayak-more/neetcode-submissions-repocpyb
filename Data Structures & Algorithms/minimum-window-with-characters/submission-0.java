class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] tMap = new int[256];
        for(int i = 0; i < t.length(); i++){
            tMap[t.charAt(i)]++;
        }
        int[] sMap = new int[256];
        int start = 0, end = 0, min = s.length() + 1;
        String result = "";
        while(end < s.length()){
            sMap[s.charAt(end)]++;
            while(isValidWindow(sMap, tMap)){
                if(min > (end - start + 1)){
                    min = (end - start + 1);
                    result = s.substring(start, end + 1);
                }
                sMap[s.charAt(start)]--;
                start++;
            }
            end++;
        }
        return result;
    }

    private boolean isValidWindow(int[] s, int[] t){
        for(int i = 0; i < s.length; i++){
            if(s[i] < t[i]) return false;
        }
        return true;
    }


}
