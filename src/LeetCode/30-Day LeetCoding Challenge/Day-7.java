class Solution {
    public int countElements(int[] arr) {
        int count[] = new int[1005];
        for(int x:arr){
            count[x]++;
        }
        int countAns=0;

        for(int i=0;i<count.length;i++){
            if(count[i]!=0 && count[i+1]!=0){
                countAns+=count[i];
            }
        }
        return countAns;
    }
}