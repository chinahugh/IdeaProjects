package com.test;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Solution solution= new Solution();
        int[] nums=new int[]{1,7,2,15};
        int target=9;
        int[] ss=solution.twoSum(nums,target);
        System.out.println(ss[0]);
        System.out.println(ss[1]);
    }
}
