import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sec = 1;
        int remain = truck_weights.length;
        int now_weight = 0;
        Queue<Truck> bridge = new LinkedList<Truck>();
        int tNum = 0;
        
        Truck tail = new Truck(-1,-1);
        
        while(remain > 0){
            if(tNum < truck_weights.length && bridge.size() < bridge_length && now_weight + truck_weights[tNum] <= weight) {
                bridge.add(new Truck(bridge_length, truck_weights[tNum]));
                now_weight += truck_weights[tNum];
                tNum++;
            }
            
            bridge.add(tail);
            
            while(true){
                Truck now = bridge.poll();
                if(now.s == -1){
                    break;
                }
                --now.s;
                if(now.s == 0){
                    now_weight -= now.w;
                    --remain;
                } else {
                    bridge.add(now);
                }
            }
            sec++;
        }
        
        return sec;
    }
    
    class Truck {
        int s;
        int w;
        
        Truck(int s, int w){
            this.s = s;
            this.w = w;
        }
    }
}