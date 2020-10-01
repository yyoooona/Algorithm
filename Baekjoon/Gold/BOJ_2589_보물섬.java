package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Treasure {
	int x, y, t; // x 좌표, y 좌표, 최단시간(t)

	public Treasure(int x, int y, int t) {
		super();
		this.x = x;
		this.y = y;
		this.t = t;
	}
}

public class BOJ_2589_보물섬 {
	static Queue<Treasure> q = new LinkedList<Treasure>();
	static int R, C;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// map 확인
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		// map을 0,0부터 R,C까지 돌아
		// * BFS는 최단거리 구하는 것!!

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					q.add(new Treasure(i, j, 0));
//					visited = new boolean[R][C]; // visited 배열을 초기화
					for (int p = 0; p < R; p++) {
						for (int q = 0; q < C; q++) {
							visited[p][q] = false;
						}
					}
					visited[i][j] = true; // 처음 들어간 지점 visited 체크 해줘야돼!
					bfs();
				}
			}
		}

		System.out.println(max);

	}

	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 }; // 상 하 좌 우

	private static void bfs() {
		while (!q.isEmpty()) {
			Treasure t = q.poll();
			max = Math.max(max, t.t);
			for (int d = 0; d < 4; d++) {
				int dx = t.x + dr[d];
				int dy = t.y + dc[d];
				int time = t.t;

				if (isRanged(dx, dy)) {
					visited[dx][dy] = true;
					q.add(new Treasure(dx, dy, time + 1));
				}
			}
		}
	}

	private static boolean isRanged(int dx, int dy) {
		if (dx < 0 || dx >= R || dy < 0 || dy >= C || map[dx][dy] == 'W' || visited[dx][dy] == true) {
			return false;
		}
		// 좌표가 map의 범위안에 있고, 방문하지 않은 육지(L)일 때
		return true;
	}
}
