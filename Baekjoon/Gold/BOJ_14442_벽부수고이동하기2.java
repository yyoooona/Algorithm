package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2 {
	private static class Move {
		int x, y, count, crush; // count 총 이동 횟수, crush은 벽 뿌순 횟수

		public Move(int x, int y, int count, int crush) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.crush = crush;
		}
	}

	private static int[][] map;
	private static int R;
	private static int C;
	private static int K;
	private static boolean[][][] visited;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][K+1]; // K 벽이 뿌서진 수

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

	private static void bfs(int x, int y, int count, int crush) {
		Queue<Move> q = new LinkedList<Move>();
		q.add(new Move(x, y, count, crush));

		while (!q.isEmpty()) {
			Move m = q.poll();

			if (m.x == R - 1 && m.y == C - 1) {
				min = Math.min(m.count, min);
			}

			for (int k = 0; k < 4; k++) {
				int nr = m.x + dr[k];
				int nc = m.y + dc[k];

				if (nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc][m.crush])
					continue; // 범위 체크

				if (m.crush <= K && map[nr][nc] == 0) { // 1. 벽을 뿌수지 않고 이동할 때
					visited[nr][nc][m.crush] = true;
					q.add(new Move(nr, nc, m.count + 1, m.crush));
				} else if (m.crush < K && map[nr][nc] == 1) { // 2. 벽을 뿌수고 이동할 때
					visited[nr][nc][m.crush] = true;
					q.add(new Move(nr, nc, m.count + 1, m.crush + 1));
				}
			}
		}
	}
}
