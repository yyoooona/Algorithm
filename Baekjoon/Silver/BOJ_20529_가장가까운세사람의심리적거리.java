package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20529_가장가까운세사람의심리적거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			int tc = Integer.parseInt(br.readLine());
			int[][] mbti = new int[tc][4];
			int min = Integer.MAX_VALUE;

			// mbti값 넣어주기 ()
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < tc; i++) {
				String str = st.nextToken();
				for (int j = 0; j < 4; j++) {
					mbti[i][j] = str.charAt(j);
				}
			}

			a: for (int i = 0; i < tc - 2; i++) {
				for (int j = i + 1; j < tc - 1; j++) {
					for (int k = j + 1; k < tc; k++) {
						int num = 0;
						for (int s = 0; s < 4; s++) {
							if (mbti[i][s] != mbti[j][s])
								num += 1;
							if (mbti[j][s] != mbti[k][s])
								num += 1;
							if (mbti[k][s] != mbti[i][s])
								num += 1;
							if (num >= 100000)
								break;
						}
						if (num == 0) {
							min = 0;
							break a;
						}
						min = Math.min(min, num);
					}
				}
			} // 각 테스트 케이스
			sb.append(min).append('\n');
		} // end of T(전체 테스트 케이스)
		System.out.println(sb);
	}// end of main
}
