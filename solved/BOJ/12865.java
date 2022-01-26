import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] item = new int[N+1][2];
		int[][] map = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= N; i++) {
			for(int w = 1; w <= K; w++) {
				if(item[i][0] > w) {
					map[i][w] = map[i-1][w];
					continue;
				}
				map[i][w] = Math.max(map[i-1][w], map[i-1][w-item[i][0]] + item[i][1]);
			}
		}
		System.out.println(map[N][K]);
	}
}
