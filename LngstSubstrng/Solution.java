package LngstSubstrng;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int res=1;
        for(int i=0;i<s.length();i++){
            Set<Character> seen = new HashSet<>();
            seen.add(s.charAt(i));
            for (int j=i+1;j<s.length();j++){
                if(!seen.contains(s.charAt(j))){
                    seen.add(s.charAt(j));
                    if(seen.size()>res) res=seen.size();
                }else{
                    break;
                }
            }        
        }
        return res;
    }
}