package LeetCode.MonthChallenge;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            if(set.contains(n)) return false;
            set.add(n);
            
            n = squareNumber(n);
        }
        return true;
        
    }
    
    public int squareNumber(int n ){
        int result=0;
        while(n!=0){
            int rem = n%10;
            n/=10;
            result += rem*rem;
        }
        return result;
    }
}