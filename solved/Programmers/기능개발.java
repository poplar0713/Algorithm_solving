import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int tasks = speeds.length;
        Queue<Fu> queue = new LinkedList<Fu>();
        ArrayList<Fu> list = new ArrayList<Fu>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < tasks; i++){
            Fu f = new Fu(progresses[i], speeds[i]);
            list.add(f);
        }
        
        int n = 0;
        while(tasks > n){
            int fin = 0;
            for(int i = 0; i < tasks; i++){
                Fu now = list.get(i);
                if(!now.isFin){
                    list.get(i).work();
                    queue.add(list.get(i));
                }
            }
            while(!queue.isEmpty()){
                Fu now = queue.poll();
                if(now.prog >= 100){
                    ++fin;
                    now.isFin = true;
                }
                else queue.clear();
            }
            
            if(fin > 0){
                result.add(fin);
            }
            
            n += fin;
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    class Fu {
        int speed = 0;
        int prog = 0;
        boolean isFin = false;
        
        Fu(int prog, int speed){
            this.prog = prog;
            this.speed = speed;
        }
        
        void work(){
            this.prog += speed;
        }
    }
}