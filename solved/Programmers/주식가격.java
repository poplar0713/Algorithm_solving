import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i = 0; i < prices.length; i++){
            while(!stack.empty() && prices[stack.peek()] > prices[i]){
                int now = stack.pop();
                answer[now] = i - now;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int top = stack.pop();
            answer[top] = prices.length-1 - top;
        }
        
        return answer;
    }
}