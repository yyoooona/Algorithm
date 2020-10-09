package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Insung {
	int x, y, f;

	public Insung(int x, int y, int f) {
		super();
		this.x = x;
		this.y = y;
		this.f = f;
	}
}

public class BOJ_19952_인성문제있어_G4 {
	static int R, C, O, F, L, XS, YS, XE, YE; // R: 세로, C: 가로, O: 장애물 수, F: 힘, L: 장애물 높이, XS, YS: 시작, XE, YE: 목적지
	static StringBuilder sb = new StringBuilder();
	static int[][] miro;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
			XS = Integer.parseInt(st.nextToken());
			YS = Integer.parseInt(st.nextToken());
			XE = Integer.parseInt(st.nextToken());
			YE = Integer.parseInt(st.nextToken());

			miro = new int[R + 1][C + 1];
			visited = new boolean[R + 1][C + 1];

			for (int o = 0; o < O; o++) { // 장애물 입력하기
				st = new StringTokenizer(br.readLine());
				int ox = Integer.parseInt(st.nextToken());
				int oy = Integer.parseInt(st.nextToken());
				int ol = Integer.parseInt(st.nextToken());

				miro[ox][oy] = ol; // 미로에 장애물 배치
			}

			bfs(XS, YS, F);
			if (visited[XE][YE] == true) {
				sb.append("잘했어!!" + "\n");
			} else {
				sb.append("인성 문제있어??" + "\n");
			}
		}
		System.out.println(sb);

	}

	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs(int XS, int YS, int F) {
		Queue<Insung> q = new LinkedList<Insung>();
		visited[XS][YS] = true;
		q.add(new Insung(XS, YS, F)); // 시작점과 힘 큐에 추가

		while (!q.isEmpty()) {

			Insung insung = q.poll();

			if (insung.f <= 0) // 남은 힘이 0 이하일 때
				break;

			if (insung.x == XE && insung.y == YE)
				break;

			for (int d = 0; d < 4; d++) { // 4방 탐색
				int nx = insung.x + dx[d];
				int ny = insung.y + dy[d];
				int nf = insung.f;

				if (isRanged(insung.x, insung.y, nx, ny, nf)) {
					visited[nx][ny] = true;
					nf -= 1;
					q.add(new Insung(nx, ny, nf));
				}
			}

		}
	}

	private static boolean isRanged(int insX, int insY, int nx, int ny, int nf) {
		// 이동지점의 높이 - 현재 높이
		if (nx <= R && ny <= C && nx >= 1 && ny >= 1 && visited[nx][ny] == false) {
			int nl = miro[nx][ny] - miro[insX][insY];
			if (nf >= nl) {
				return true;
			}
		}
		return false;
	}
}
