package BinarySort;

class Solution {
    public int search(int[] nums, int target) {
        int max=nums.length-1;
        int min=0;
        int mid=(max+min)/2;
        if(target==nums[min]){
            return min;
        } else if(target==nums[max]){
            return max;
        }
        while(max>mid&&min<mid){
            if(target==nums[mid]){
                return mid;
            } else if(target>nums[mid]){
                min=mid;
            } else{
                max=mid;
            }
            mid=(max+min)/2;
        }
        return -1;
    }
}

