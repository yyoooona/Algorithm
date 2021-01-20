package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Current { // queue에서 들고다닐 정보
	int x, y;

	public Current(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class BOJ_3187_양치기꿍 {
	private static int width;
	private static int height;
	private static char[][] map;
	private static boolean[][] visited;
	private static int sheep = 0; // 전체 양 수
	private static int wolf = 0; // 전체 늑대 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		map = new char[width][height];
		visited = new boolean[width][height];

		// 1. map 입력받기
		for (int i = 0; i < width; i++) {
			String str = br.readLine();
			for (int j = 0; j < height; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 2. 각 구역 visited 체크하면서 v개수, k개수 받아서
		// v>=k 이면 v, v<k이면 k를 전체 늑대, 양개수에 더하기
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (visited[i][j] == false && (map[i][j] == '.' || map[i][j] == 'v' || map[i][j] == 'k')) {
					bfs(i, j); // 한 영역마다 bfs 순회
				}
			}
		}

		// 답 출력
		System.out.println(sheep + " " + wolf);
	}

	private static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int x, int y) {
		int curSheep = 0;
		int curWolf = 0;
		Queue<Current> q = new LinkedList<Current>();
		visited[x][y] = true;
		q.add(new Current(x, y));
		while (!q.isEmpty()) {
			Current c = q.poll();

			if (map[c.x][c.y] == 'v')
				curWolf += 1;
			else if (map[c.x][c.y] == 'k')
				curSheep += 1;
			for (int k = 0; k < 4; k++) {
				int nr = c.x + dr[k];
				int nc = c.y + dc[k];

				if (nr >= 0 && nr < width && nc >= 0 && nc < height && map[nr][nc] != '#' && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					q.add(new Current(nr, nc));
				}
			}
		}
		// 만약에 queue 가 비었을때 == 해당 영역을 모두 돌았을 때
		// v와 k 비교해서 전체 양, 늑대 수 변경

		if (curSheep > curWolf)
			sheep += curSheep;
		else
			wolf += curWolf;
	}
}
