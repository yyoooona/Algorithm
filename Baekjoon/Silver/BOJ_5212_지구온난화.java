package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5212_지구온난화 {
	private static char[][] map;
	private static char[][] ansMap;
	private static Queue<Island> q;
	private static int R;
	private static int C;
	private static int rs, cs, re, ce;

	private static class Island {
		int r, c;

		public Island(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		q = new LinkedList<Island>();

		map = new char[R][C];
		ansMap = new char[R][C];

		// 주어진 map 입력받기
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				ansMap[i][j] = str.charAt(j);
			}
		}

		//
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X')
					q.add(new Island(i, j));
			}
		}

		bfs();

//		printAnsMap();

		checkRStart(0);
		checkCStart(0);
		checkREnd(R - 1);
		checkCEnd(C - 1);

		for (int i = rs; i <= re; i++) {
			for (int j = cs; j <= ce; j++) {
				System.out.print(ansMap[i][j]);
			}
			System.out.println();
		}
	}

	private static void checkCStart(int start) {

		for (int j = start; j < C; j++) { // 열 탐색
			for (int i = 0; i < R; i++) {
				if (ansMap[i][j] == 'X') {
					cs = j;
					return;
				}
			}
		}
	}

	private static void checkRStart(int start) {

		for (int i = start; i < R; i++) { // 행 탐색
			for (int j = 0; j < C; j++) {
				if (ansMap[i][j] == 'X') {
					rs = i;
//					System.out.println("rs : " + rs);
					return;
				}
			}
		}

	}

	private static void checkCEnd(int end) {

		for (int j = end; j >= 0; j--) { // 열 탐색
			for (int i = 0; i < R; i++) {
				if (ansMap[i][j] == 'X') {
					ce = j;
					return;
				}
			}
		}
	}

	private static void checkREnd(int end) {

		for (int i = end; i >= 0; i--) { // 행 탐색
			for (int j = 0; j < C; j++) {
				if (ansMap[i][j] == 'X') {
					re = i;
					return;
				}
			}
		}

	}

	private static void printAnsMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(ansMap[i][j]);
			}
			System.out.println();
		}
	}

	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			Island i = q.poll();

			int count = 0; // 바다의 개수 체크

			for (int k = 0; k < 4; k++) {
				int nr = i.r + dr[k];
				int nc = i.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '.') {
					count += 1;
				}

				if (count == 3) {
					ansMap[i.r][i.c] = '.';
				}
			}

		}
	}
}
