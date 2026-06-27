package KokoEatingBanana;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=0;
        for(int p:piles){
            if(p>r){
                r=p;
            }
        }
        int res=r;
        while(l<=r){
            int k=(l+r)/2; 
            long totalTime=0;
            for(int p:piles){
                totalTime+=p/k;
                if(p%k!=0) {
                    totalTime++;
                }
            }
            if(totalTime<=h){
                res=k;
                r=k-1;
            }else{
                l=k+1;
            }
        }
        return res;
    }
}

