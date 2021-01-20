package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Current { // queue���� ���ٴ� ����
	int x, y;

	public Current(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class BOJ_3187_��ġ��� {
	private static int width;
	private static int height;
	private static char[][] map;
	private static boolean[][] visited;
	private static int sheep = 0; // ��ü �� ��
	private static int wolf = 0; // ��ü ���� ��

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		map = new char[width][height];
		visited = new boolean[width][height];

		// 1. map �Է¹ޱ�
		for (int i = 0; i < width; i++) {
			String str = br.readLine();
			for (int j = 0; j < height; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 2. �� ���� visited üũ�ϸ鼭 v����, k���� �޾Ƽ�
		// v>=k �̸� v, v<k�̸� k�� ��ü ����, �簳���� ���ϱ�
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (visited[i][j] == false && (map[i][j] == '.' || map[i][j] == 'v' || map[i][j] == 'k')) {
					bfs(i, j); // �� �������� bfs ��ȸ
				}
			}
		}

		// �� ���
		System.out.println(sheep + " " + wolf);
	}

	private static int[] dr = { -1, 1, 0, 0 }; // �� �� �� ��
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
		// ���࿡ queue �� ������� == �ش� ������ ��� ������ ��
		// v�� k ���ؼ� ��ü ��, ���� �� ����

		if (curSheep > curWolf)
			sheep += curSheep;
		else
			wolf += curWolf;
	}
}
