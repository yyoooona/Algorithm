package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_���ã�� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N + 1][N + 1];

		// �Է�
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// �÷��̵�-�ͼ�
		for (int r = 1; r <= N; r++) { // ������
			for (int from = 1; from <= N; from++) { // �����
				for (int to = 1; to <= N; to++) { // ������
					if (graph[from][r] + graph[r][to] == 2 || graph[from][to] == 1)
						graph[from][to] = 1;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

	}
}
