//https://programmers.co.kr/learn/courses/30/lessons/77485
//행렬테두리회전하기
public class Solution {
	static int[][] map;
    
    static void generateMap(int rows, int columns){
        map = new int[rows+1][columns+1];
        int num = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++){
                map[i][j] = num++;
            }
        }
    }
    
    static int rotate(int[] q){  //행1 = [0], 열1 = [1], 행2 = [2], 열2 = [3]
        int min = Integer.MAX_VALUE;
        int x0fin = map[q[0]][q[3]];
        int x1fin = map[q[2]][q[1]];
        
        min = Math.min(x0fin, min);
        min = Math.min(x1fin, min);
        for(int i = q[3]; i > q[1]; i--) {
            map[q[0]][i] = map[q[0]][i-1];
            min = Math.min(map[q[0]][i], min);
        }
        for(int i = q[1]; i < q[3]; i++) {
            map[q[2]][i] = map[q[2]][i+1];
            min = Math.min(map[q[2]][i], min);
        }
        
        for(int i = q[2]; i > q[0]+1; i--){
            map[i][q[3]] = map[i-1][q[3]];
            min = Math.min(map[i][q[3]], min);
        }
        for(int i = q[0]; i < q[2]-1; i++){
            map[i][q[1]] = map[i+1][q[1]];
            min = Math.min(map[i][q[1]], min);
        }
        map[q[0]+1][q[3]] = x0fin;
        map[q[2]-1][q[1]] = x1fin;
        
        return min;
    } 
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int [queries.length];
        generateMap(rows, columns);
        for(int i = 0; i < queries.length; i++){
            answer[i] = rotate(queries[i]);
            
            for(int j = 1; j <= rows; j++) {
            	for(int n = 1; n <= columns; n++) {
            		System.out.print(map[j][n] + " ");
            	}
            	System.out.println();
            }
            System.out.println();
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		 
		int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
		
		Solution sol = new Solution();
		for(int n : sol.solution(3, 3, queries)) {
			System.out.print(n);
		}
	}
}


