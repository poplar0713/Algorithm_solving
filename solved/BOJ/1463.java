import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { //1463번 1로 만들기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		for(int i = 1; i < n; i++) {
			if(i > 1 && dp[i] == 0) continue;
			if(i+1<=n) {
				if(dp[i+1] == 0) dp[i+1] = dp[i]+1;
				else dp[i+1] = Math.min(dp[i]+1, dp[i+1]);
			}
			if(i*2<=n) {
				if(dp[i*2] == 0) dp[i*2] = dp[i]+1;
				else dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
			}
			if(i*3<=n) {
				if(dp[i*3] == 0) dp[i*3] = dp[i]+1;
				else dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
			}
		}
		
		System.out.println(dp[n]);
	}
}
