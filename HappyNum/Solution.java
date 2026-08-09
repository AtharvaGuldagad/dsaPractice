package HappyNum;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        while(!seen.contains(n)){
            seen.add(n);
            n=sumOfSq(n);
            if(n==1) return true;
        }
        return false;
    }
    int sumOfSq(int n){
        int res=0;
        while(n>0){
            int digit=n%10;
            digit=digit*digit;
            res=res+digit;
            n=n/10;
        }
        return res;
    }
}

