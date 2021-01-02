package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {
	static int area = 0;
	static boolean[][] visited;
	static int R, C;
	static ArrayList<Integer> areaArr = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];

		for (int k = 0; k < T; k++) { // T개의 직사각형에 해당하는 면적에 visited 처리
			st = new StringTokenizer(br.readLine());
			int cs = Integer.parseInt(st.nextToken()); // 시작점 c좌표
			int rs = Integer.parseInt(st.nextToken()); // 시작점 r좌표
			int ce = Integer.parseInt(st.nextToken());
			int re = Integer.parseInt(st.nextToken());

			for (int i = cs; i < ce; i++) {
				for (int j = rs; j < re; j++) {
					visited[j][i] = true;
				}
			}

		}

		int count = 0;

		for (int p = 0; p < R; p++) {
			for (int q = 0; q < C; q++) {
				if (!visited[p][q]) {
					count += 1;
					area = 0;
					dfs(p, q);
					areaArr.add(area);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		Collections.sort(areaArr);
		sb.append(count).append('\n');

		for (int num : areaArr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}

	static int[] dr = { 1, -1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 }; // 상 하 좌 우

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		area += 1;

		for (int d = 0; d < 4; d++) {
			int row = r + dr[d];
			int col = c + dc[d];

			if (row >= R || col >= C || row < 0 || col < 0 || visited[row][col] == true) {
				// 범위를 벗어나거나 이미 방문한 지점이면
				continue;
			} else {
				dfs(row, col);
			}
		}
	}
}
