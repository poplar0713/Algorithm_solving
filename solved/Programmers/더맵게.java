import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int n : scoville){
            pq.offer(n);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int n1 = pq.poll();
            int n2 = pq.poll();
            n1 += n2*2;
            pq.offer(n1);
            answer++;
        }
        
        if(pq.size() == 1 && pq.peek() < K) return -1;
        
        return answer;
    }
}