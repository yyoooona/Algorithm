package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_����ī��2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine().trim());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			int card = Integer.parseInt(st.nextToken());

			if (map.containsKey(card)) {
				// �ش� Ű���� ������ value+1
				map.replace(card, map.get(card) + 1);
			} else {
				// Ű ���� ������ 1�� setting
				map.put(card, 1);
			}
		}

		int ans = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < ans; j++) {
			int ansNum = Integer.parseInt(st.nextToken());
			if(map.get(ansNum)==null) sb.append(0).append(" ");
			else sb.append(map.get(ansNum)).append(" ");
		}
		
		System.out.println(sb);
	}
}
