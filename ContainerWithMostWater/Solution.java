class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int l=0,r=heights.length-1;
        while(l<r){
            int smol=l;
            if(heights[l]>heights[r]){
                smol=r;
            }
            if((heights[smol]*(r-l))>max) max=heights[smol]*(r-l);
            
            if(heights[l]>heights[r]){
                r-=1;
            }else{
                l+=1;
            }
        }
        return max;
    }
}