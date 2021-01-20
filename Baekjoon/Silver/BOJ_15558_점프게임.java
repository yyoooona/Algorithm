package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558_�������� {
	private static class CurLoc { // ���� ��ġ
		int x, y, time; // �ð��� ���� �湮 ó��

		public CurLoc(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

	private static int k;
	private static int N;
	private static int[][] map;
	private static Queue<CurLoc> q = new LinkedList<CurLoc>();
	private static boolean[][] visited;
	private static boolean clearCheck = false; // Ŭ�����ϸ� true

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dc[0] = dc[1] = k; // k���� �� �޾Ƽ� ���� ������ ��
		map = new int[2][N + k + 1];
		visited = new boolean[2][N + k + 1];

		// 1. ���������� ���� map setting
		for (int i = 0; i < 2; i++) { // ���� ������ ����
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// 2. ���� ���� ����
		q.add(new CurLoc(0, 0, 0));
		bfs();

		if (clearCheck == false) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}

	}

	// 4���� ���� - ���� ��ĭ, ���� ��ĭ, �� ��ĭ �̵� �� ���� kĭ, �� ��ĭ �̵� �� ���� kĭ
	static int[] dr = { 1, -1, 0, 0 }; // �� �� �� ��
	static int[] dc = { k, k, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			CurLoc c = q.poll();

//			System.out.println(c.x + " " + c.y);

			if (c.y + k >= N) {
//				System.out.println("nr : " + c.x + " " + "nc : " + c.y + " ");
				clearCheck = true;
				break;
			}

			for (int p = 0; p < 4; p++) {
				int nr = c.x + dr[p];
				int nc = c.y + dc[p];
				if (nr >= 0 && nc > c.time && nr < 2 && visited[nr][nc] != true && map[nr][nc] == 1) {
					visited[nr][nc] = true;

					q.add(new CurLoc(nr, nc, c.time + 1));
				}
			}

			visited[0][c.time] = true; // �ð��� ���� ĭ �������� �� ǥ��
			visited[1][c.time] = true;

		}
	}

}