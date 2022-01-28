import java.util.*;

class Solution {
    static HashMap<String, Integer> kinds =  new HashMap<String, Integer>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for(int i = 0; i < clothes.length; i++){
            if(!kinds.containsKey(clothes[i][1])){
                kinds.put(clothes[i][1], 2);
            }
            else{
                kinds.replace(clothes[i][1], kinds.get(clothes[i][1]) + 1);
            }
        }
        
        int[] list = new int[kinds.size()];
        int i = 0;
        Set set = kinds.keySet();
        Iterator iterator = set.iterator();
        
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            list[i] = kinds.get(key);
            i++;
        }
        
        for(int n = 0 ; n < list.length; n++){
            answer *= list[n];
        }
        
        return answer-1;
    }
}