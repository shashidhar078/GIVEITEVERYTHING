class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String,List<String>> res=new HashMap<>();
        
        for(String str:strs)
        {
            int[] ch=new int[26];
            for(char c:str.toCharArray())
            {
                int i=c-'a';
                ch[i]++;
            }
            String s=Arrays.toString(ch);
            if(!res.containsKey(s))
            res.put(s,new ArrayList<>());
            res.get(s).add(str);
        }
        return new ArrayList<>(res.values());
    }
}