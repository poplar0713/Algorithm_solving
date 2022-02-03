import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Task> q = new LinkedList<Task>();
        for(int i = 0; i < priorities.length; i++){
            Task t = new Task(i, priorities[i]);
            pq.offer(priorities[i]);
            q.offer(t);
        }
        
        int n = 1;
        int max = pq.poll();
        while(true){
            Task now = q.poll();
            if(now.prio == max){
                if(now.num == location){
                    return n;
                }
                max = pq.poll();
                n++;
            } else {
                q.offer(now);
            }
        }
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