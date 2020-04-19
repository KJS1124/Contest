package LeetCode.MonthChallenge;

class Day1 {
    public int singleNumber(int[] nums) {
        int x =0;
        for(int n:nums) x^=n;
        return x;
    }
}