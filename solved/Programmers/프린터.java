import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Task> pq = new PriorityQueue<>();
        Queue<Task> q = new LinkedList<Task>();
        
        int answer = 0;
        for(int i = 0; i < priorities.length; i++){
            Task t = new Task(i, priorities[i]);
            pq.offer(t);
            q.offer(t);
        }
        
        int n = 1;
        int max = pq.poll().prio;
        while(true){
            Task now = q.poll();
            if(now.prio == max){
                if(now.num == location){
                    answer = n;
                    break;
                }
                max = pq.poll().prio;
                n++;
            } else {
                q.offer(now);
            }
        }
        return answer;
    }
    
    class Task implements Comparable<Task>{
        int prio;
        int num;
        Task(int num, int prio){
            this.num = num;
            this.prio = prio;
        }
        
        public int compareTo(Task o){
            return -(this.prio - o.prio);
        }
    }
}