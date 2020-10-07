package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static boolean[][] map;
	static boolean[] check;
	static int V;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken()); // 시작 점

		map = new boolean[V + 1][V + 1];
		check = new boolean[V + 1];

		for (int t = 0; t < E; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = true;
			map[c][r] = true;
		}

		dfs(S);
		sb.append("\n");
		check = new boolean[V + 1]; // check 배열 false로 초기화

		sb.append(S).append(" ");
		bfs(S);
		System.out.println(sb);
	}

	private static void dfs(int s) {
		sb.append(s).append(" ");
		check[s] = true;
		for (int e = 1; e < V + 1; e++) {
			if (map[s][e] == true && check[e] == false) {
				check[e] = true;
				dfs(e);
			}
		}
	}

	private static void bfs(int S) {
		q.add(S);
		check[S] = true;
		while (!q.isEmpty()) {
			int num = q.poll();
			for (int c = 1; c <= V; c++) {
				if (map[num][c] == true && check[c] == false) {
					check[c] = true;
					sb.append(c).append(" ");
					q.add(c);
				}
			}
		}
	}
}
