package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int[][] lecture = new int[num][2];

		for (int tc = 0; tc < num; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lecture[tc][0] = Integer.parseInt(st.nextToken()); // 강의 시작시간
			lecture[tc][1] = Integer.parseInt(st.nextToken()); // 강의 끝 시간

		}

		Arrays.sort(lecture, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				int result = o1[0] - o2[0];
				if (result != 0)
					return result;
				else
					return o1[1] - o2[1];
			}
		});

		for (int i = 0; i < num; i++) {
			if (!pq.isEmpty() && pq.peek() <= lecture[i][0]) {
				pq.poll();
			}
			pq.add(lecture[i][1]);
		}

		System.out.println(pq.size());
	}
}
