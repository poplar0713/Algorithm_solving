import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 2178 미로탐색
	
	static char[][] map;
	static boolean[][] vi;
	static int[] dy = {-1,0,0,1};
	static int[] dx = {0,-1,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int answer = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		vi = new boolean[N][M];
		
		for(int i = 0; i < N; i++) 
			map[i] = br.readLine().toCharArray();
		
		Queue<int[]> q = new LinkedList<int[]>();
		int[] temp = {0,0,1};
		vi[0][0] = true;
		q.offer(temp);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if(ny > -1 && nx > -1 && ny < N && nx < M && !vi[ny][nx] && map[ny][nx] == '1') {
					if(ny == N-1 && nx == M-1) {
						answer = Math.min(now[2] + 1, answer);
						continue;
					}
					vi[ny][nx] = true;
					int[] next = {ny, nx, now[2] + 1};
					q.offer(next);
				}
			}
		}
		
		System.out.println(answer);
	}
}
