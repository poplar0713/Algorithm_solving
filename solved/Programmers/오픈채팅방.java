import java.util.*;

class Solution {
    
    static HashMap<String, String> nickName = new HashMap<String, String>();
    static ArrayList<Action> actions = new ArrayList<Action>();
    
    public void decode(String input){
        StringTokenizer st = new StringTokenizer(input);
        String act = st.nextToken();
        String id = st.nextToken();
        if(act.equals("Leave"))
            actions.add(new Action(id, 1));
        else {
            String nN = st.nextToken();
            nickName.put(id, nN);
            if(act.equals("Enter"))
                actions.add(new Action(id, 0));
        }
    }
    
    public String[] solution(String[] record) {
        for(String input : record)
            decode(input);
        String[] answer = new String[actions.size()]; 
        for(int i = 0; i < answer.length; i++)
            answer[i] = actions.get(i).getAction();
        return answer;
    }
    
    class Action {
        String id;
        int act;
        Action(String id, int act){
            this.id = id;
            this.act = act;
        }
        
        String getAction(){
            StringBuilder sb = new StringBuilder(nickName.get(id));
            switch(this.act){
                case 0 :
                    sb.append("님이 들어왔습니다.");
                    break;
                case 1 :
                    sb.append("님이 나갔습니다.");
                    break;
                default :
                    break;
            }
            return sb.toString();
        }
    }
}