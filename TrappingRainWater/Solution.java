package TrappingRainWater;

class Solution {
    public int trap(int[] height) {
        int maxl=0,maxr=0;
        int l=0,r=height.length-1;
        int res=0;
        while (l<r){
            if(height[l]<height[r]||height[l]==height[r]){
                if(height[l]<maxl){
                    res+=maxl-height[l];
                }else{ 
                    maxl=height[l];
                }
                l++;
            }else {
                if(height[r]<maxr){
                    res+=maxr-height[r];
                }else{ 
                    maxr=height[r];
                }
                r--;
            }
        }
        return res;
    }
}

