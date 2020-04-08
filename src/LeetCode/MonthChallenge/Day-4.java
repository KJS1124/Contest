package LeetCode.MonthChallenge;

class Solution {
    public void moveZeroes(int[] nums) {
        int lastInsertion =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i]=nums[lastInsertion];
                nums[lastInsertion] = temp;
                lastInsertion++;
            }
        }
        for(int x : nums){
            System.out.println(x);
        }
        
    }
}