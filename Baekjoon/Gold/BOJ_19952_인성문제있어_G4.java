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

public class BOJ_19952_�μ������־�_G4 {
	static int R, C, O, F, L, XS, YS, XE, YE; // R: ����, C: ����, O: ��ֹ� ��, F: ��, L: ��ֹ� ����, XS, YS: ����, XE, YE: ������
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

			for (int o = 0; o < O; o++) { // ��ֹ� �Է��ϱ�
				st = new StringTokenizer(br.readLine());
				int ox = Integer.parseInt(st.nextToken());
				int oy = Integer.parseInt(st.nextToken());
				int ol = Integer.parseInt(st.nextToken());

				miro[ox][oy] = ol; // �̷ο� ��ֹ� ��ġ
			}

			bfs(XS, YS, F);
			if (visited[XE][YE] == true) {
				sb.append("���߾�!!" + "\n");
			} else {
				sb.append("�μ� �����־�??" + "\n");
			}
		}
		System.out.println(sb);

	}

	static int[] dx = { -1, 1, 0, 0 }; // �� �� �� ��
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs(int XS, int YS, int F) {
		Queue<Insung> q = new LinkedList<Insung>();
		visited[XS][YS] = true;
		q.add(new Insung(XS, YS, F)); // �������� �� ť�� �߰�

		while (!q.isEmpty()) {

			Insung insung = q.poll();

			if (insung.f <= 0) // ���� ���� 0 ������ ��
				break;

			if (insung.x == XE && insung.y == YE)
				break;

			for (int d = 0; d < 4; d++) { // 4�� Ž��
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
		// �̵������� ���� - ���� ����
		if (nx <= R && ny <= C && nx >= 1 && ny >= 1 && visited[nx][ny] == false) {
			int nl = miro[nx][ny] - miro[insX][insY];
			if (nf >= nl) {
				return true;
			}
		}
		return false;
	}
}
