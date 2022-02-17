import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 14503번 로봇 청소기
	static int[] dy = {-1,0,1,0}; // 0 1 2 3 
	static int[] dx = {0,1,0,-1}; // 북 동 남 서
	static boolean[][] cleaned;
	static char[][] map;
	static Robot robot;
	static int N;
	static int M;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		cleaned = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		robot = new Robot(r, c, d);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());;
			for(int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		while(true) {
			if(robot.cleanning()) count++;
			if(!robot.getNextDir() && !robot.stepBack()) break;
		}
		
		System.out.println(count);
	}
	
	static class Robot{
		int r;
		int c;
		int d;
		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
		boolean cleanning() {
			if(!cleaned[this.r][this.c]) {
				cleaned[this.r][this.c] = true;
				return true;
			}
			return false;
		}
		
		boolean getNextDir() {
			int nd = (this.d+3) % 4;
			int d = 0;
			while(d < 4) {
				int ny = this.r + dy[nd];
				int nx = this.c + dx[nd];
				if(ny < N && nx < M && ny > -1 && nx > -1 && map[ny][nx] == '0' && !cleaned[ny][nx]) {
					this.d = nd;
					this.r = ny;
					this.c = nx;
					return true;
				}
				nd = (nd+3) % 4;
				d++;
			}
			return false;
		}
		
		boolean stepBack() {
			int ny = this.r + dy[(this.d + 2) % 4];
			int nx = this.c + dx[(this.d + 2) % 4];
			if(ny < N && nx < M && ny > -1 && nx > -1 && map[ny][nx] == '0') {
				this.r = ny;
				this.c = nx;
				return true;
			}
			return false;
		}
	}
}
