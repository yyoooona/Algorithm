package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Color {
	int x, y;
	char color;

	public Color(int x, int y, char color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
}

public class BOJ_10026_적록색약 {
	private static Queue<Color> q;
	private static boolean[][] visited;
	private static char[][] map;
	private static int N;
	private static int count = 0;
	private static int CBcount = 0;
	private static char[][] CBmap;
	private static boolean flag = false;

	public static void main(String[] args) throws Exception {
		/*
		 * 1. R,G,B가 적힌 map 만들기 2. BFS
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		CBmap = new char[N][N]; // color blind map
		visited = new boolean[N][N];

		// 1. map setting
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				CBmap[i][j] = map[i][j] = str.charAt(j);
				if (CBmap[i][j] == 'G') {
					CBmap[i][j] = 'R'; // 적록색약 'G'를 'R'로 대체
				}
			}
		}

//		System.out.println("Nomal Map");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//
//		System.out.println("Color Blind Map");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(CBmap[i][j]);
//			}
//			System.out.println();
//		}

		// 적록색약 아닌 사람일 때
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					q = new LinkedList<Color>();
					q.add(new Color(i, j, map[i][j]));
					bfs();
				}
			}
		}

		// 적록 색약일 때
		visited = new boolean[N][N];
		flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					q = new LinkedList<Color>();
					q.add(new Color(i, j, CBmap[i][j]));
					bfs();
				}
			}
		}

		System.out.print(count+" ");
		System.out.println(CBcount);

	}

	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		// 해당 색깔 찾아서 4방 탐색
		// 방문 체크

		while (!q.isEmpty()) {
			Color c = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = c.x + dr[k];
				int nc = c.y + dc[k];

				// nr, nc가 map 범위안에 있고 visited 배열이 false? nColor와 c.color가 같은 곳만 갈수 있어
				if (flag == false) {
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == false && c.color == map[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Color(nr, nc, c.color));
					}
				} else {
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == false
							&& c.color == CBmap[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Color(nr, nc, c.color));
					}
				}
			}
		}

		if (flag == false) {
			count++;
		} else
			CBcount++;
	}
}
