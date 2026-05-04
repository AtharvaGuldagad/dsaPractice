package MinInRotatedArr;
//weird to grasp the idea of binary search here, but the key is to find the pivot point where the array is rotated.
public class Solution {
    public int findMin(int[] nums) {
        int min=0,max=nums.length-1;
        if (nums[min]<=nums[max]) return nums[0];
        int mid;
        while(min<=max){
            mid=(min+max)/2;
            if(nums[mid]>nums[nums.length-1]){
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return nums[min];
    }
}
