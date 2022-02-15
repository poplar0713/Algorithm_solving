import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;

//https://programmers.co.kr/learn/courses/30/lessons/92334
//[프로그래머스] 신고 결과 받기
public class Solution {
	
	static HashMap<String, User> user_map = new HashMap<String, User>();
	static HashMap<String, Integer> reported_user_count = new HashMap<String, Integer>();
	
	public int[] solution(String[] id_list, String[] report, int k) {
		int [] answer = new int[id_list.length];
		
		for(int i = 0; i < id_list.length; i++) {
			User user = new User(id_list[i]);
			user_map.put(id_list[i], user);
		}
		
		for(String s : report) {
			StringTokenizer st = new StringTokenizer(s);
			String name = st.nextToken();
			String badguy = st.nextToken();
			User user = user_map.get(name);
			user.reportUser(badguy);
		}
		
		for(int i = 0; i < id_list.length; i++) {
			User user = user_map.get(id_list[i]);
			int count = 0;
			for(String value : user.report) {
				if(reported_user_count.containsKey(value) && reported_user_count.get(value) >= k) {
					count++;
				}
			}
			answer[i] = count;
		}
		
		return answer;
	}
	
	static class User{
		String username;
		HashSet<String> report = new HashSet<String>();
		User(String username){
			this.username = username;
			report = new HashSet<String>();
		}
		
		boolean reportUser(String name) {
			if(!report.contains(name)) {
				report.add(name);
				if(reported_user_count.containsKey(name)) {
					reported_user_count.replace(name, reported_user_count.get(name)+1);
				} else {
					reported_user_count.put(name, 1);
				}
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
		
		Solution sol = new Solution();
		for(int n : sol.solution(id_list, report, k)) {
			System.out.print(n);
		}
	}
}


