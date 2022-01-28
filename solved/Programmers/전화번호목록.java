import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet <String> set = new HashSet<String>();
        for(int i = 0; i < phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            String now = phone_book[i];
            for(int j = 0; j < now.length(); j++){
                if(set.contains(now.substring(0,j))){
                    return false;
                }
            }
        }
        
        return answer;
    }
}