package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Wrestler implements Comparable<Wrestler> {
	int num, power, ring, winPoint;

	public Wrestler(int num, int power, int ring, int winPoint) {
		super();
		this.num = num;
		this.power = power;
		this.ring = ring;
		this.winPoint = winPoint;
	}

	@Override
	public int compareTo(Wrestler o) {
		return this.winPoint - o.winPoint;
	}
}

public class BOJ_1900_·¹½½·¯ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Wrestler[] list = new Wrestler[N];

		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list[tc] = new Wrestler(tc + 1, p, r, 0);
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				Wrestler first = list[i];
				Wrestler second = list[j];

				if (first.power + (first.ring * second.power) > second.power + (second.ring * first.power)) {
					list[i].winPoint += 1;
				} else {
					list[j].winPoint += 1;
				}
			}
		}

		Arrays.sort(list, Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			System.out.println(list[i].num);
		}
	}
}
