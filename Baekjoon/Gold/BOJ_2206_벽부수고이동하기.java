package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs문제 (최단거리)
 * visited 방문배열 체크 -> visited[][][]
 * 불가능할 때 -1 출력
 * 
 */

public class BOJ_2206_벽부수고이동하기 {

	private static class Move {
		int x, y, count, num; // count 총 이동 횟수, num은 벽 뿌순 횟수

		public Move(int x, int y, int count, int num) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.num = num;
		}
	}

	private static int[][] map;
	private static int R;
	private static int C;
	private static boolean[][][] visited;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][2]; // 0은 한개도 벽을 안뿌수는 경우, 1은 벽을 한개 뿌수는 경우

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0, 1, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dc = { 1, 0, -1, 0 };

	private static void bfs(int x, int y, int count, int num) {
		Queue<Move> q = new LinkedList<Move>();
		q.add(new Move(x, y, count, num));

		while (!q.isEmpty()) {
			Move m = q.poll();
			if (m.x == R - 1 && m.y == C - 1) {
				min = Math.min(m.count, min);
			}

			for (int k = 0; k < 4; k++) {
				int nr = m.x + dr[k];
				int nc = m.y + dc[k];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 1 && visited[nr][nc][m.num] == false
						&& m.num < 2) { // 벽을 안뿌술때
					visited[nr][nc][m.num] = true;
					q.add(new Move(nr, nc, m.count + 1, m.num));
				} else if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 1 && visited[nr][nc][1] == false
						&& m.num == 0) { // 벽을 뿌술때
					visited[nr][nc][1] = true;
					q.add(new Move(nr, nc, m.count + 1, m.num + 1));
				}
			}
		}
	}
}
