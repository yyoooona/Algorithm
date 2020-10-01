package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Treasure {
	int x, y, t; // x ��ǥ, y ��ǥ, �ִܽð�(t)

	public Treasure(int x, int y, int t) {
		super();
		this.x = x;
		this.y = y;
		this.t = t;
	}
}

public class BOJ_2589_������ {
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

		// map Ȯ��
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		// map�� 0,0���� R,C���� ����
		// * BFS�� �ִܰŸ� ���ϴ� ��!!

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					q.add(new Treasure(i, j, 0));
//					visited = new boolean[R][C]; // visited �迭�� �ʱ�ȭ
					for (int p = 0; p < R; p++) {
						for (int q = 0; q < C; q++) {
							visited[p][q] = false;
						}
					}
					visited[i][j] = true; // ó�� �� ���� visited üũ ����ߵ�!
					bfs();
				}
			}
		}

		System.out.println(max);

	}

	static int[] dr = { -1, 1, 0, 0 }; // �� �� �� ��
	static int[] dc = { 0, 0, -1, 1 }; // �� �� �� ��

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
		// ��ǥ�� map�� �����ȿ� �ְ�, �湮���� ���� ����(L)�� ��
		return true;
	}
}
