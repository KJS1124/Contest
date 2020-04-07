class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String s:strs){
            int arr[] = new int[26];
            for(char c : s.toCharArray()){
                arr[c-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i=0;i<26;i++){
                if(arr[i]!=0){
                    char c = (char)(i+'a');
                    String temp = c+""+arr[i];
                    key.append(temp);
                }
            }
            if(map.containsKey(key.toString())){
                List<String> temp = map.get(key.toString());
                temp.add(s);
                map.put(key.toString(),temp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key.toString(),list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry e: map.entrySet()){
            List<String> temp = (List<String>)e.getValue();
            ans.add(temp);
        }
        return ans;
    }
}