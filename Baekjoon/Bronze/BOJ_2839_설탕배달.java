package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * �ִ��� ���� ����
 * 5kg ����, 3kg ����
 * N�� 5�� ���� �� - 5kg ���� ��
 * (N��5�� ���� ������)�� 3kg ���� �� - 3kg ������ but 3kg�� ������ ������ ����!
 * 
 */

public class BOJ_2839_������� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int bigPocket = N / 5;
		int smallPocket = 0;
		int rest = N % 5;
		while (true) {
			if (bigPocket == 0 && rest % 3 != 0) {
				System.out.println(-1);
				return;
			}
			if (rest % 3 == 0) {
				smallPocket = rest / 3;
				break;
			} else {
				bigPocket--;
				rest += 5;
			}
		}

		System.out.println(bigPocket + smallPocket);
	}
}
