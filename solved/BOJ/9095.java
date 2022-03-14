import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { //BOJ 9095번 1,2,3 더하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;
		
		for(int i = 5; i < 11 ; i++)
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		
		for(int t = 0; t < T ; t++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(Integer.toString(dp[n]));
			bw.write("\n");
		}
		bw.flush();
	}
}
