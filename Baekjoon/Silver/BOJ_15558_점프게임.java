package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558_점프게임 {
	private static class CurLoc { // 현재 위치
		int x, y, time; // 시간에 따라서 방문 처리

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
	private static boolean clearCheck = false; // 클리어하면 true

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dc[0] = dc[1] = k; // k값을 못 받아서 직접 대입해 줌
		map = new int[2][N + k + 1];
		visited = new boolean[2][N + k + 1];

		// 1. 점프게임을 위한 map setting
		for (int i = 0; i < 2; i++) { // 점프 게임은 두줄
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// 2. 점프 게임 동작
		q.add(new CurLoc(0, 0, 0));
		bfs();

		if (clearCheck == false) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}

	}

	// 4가지 동작 - 우측 한칸, 좌측 한칸, 상 한칸 이동 후 우측 k칸, 하 한칸 이동 후 우측 k칸
	static int[] dr = { 1, -1, 0, 0 }; // 상 하 좌 우
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

			visited[0][c.time] = true; // 시간에 따라 칸 없어지는 것 표현
			visited[1][c.time] = true;

		}
	}

}