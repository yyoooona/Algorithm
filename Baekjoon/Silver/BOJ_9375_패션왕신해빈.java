package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int clothesNum = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			for (int cn = 0; cn < clothesNum; cn++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String nodata = st.nextToken(); // 의상 이름은 필요 X
				String kindCloth = st.nextToken();
				if (hm.containsKey(kindCloth)) {
					hm.replace(kindCloth, hm.get(kindCloth) + 1);
				} else {
					hm.put(kindCloth, 1);
				}
			}

			int answer = 1;
			for (int num : hm.values()) {
				answer *= (num + 1);
			}
			sb.append(answer - 1).append('\n');
		}

		System.out.println(sb);
	} // end of main
}
