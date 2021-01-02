package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class word {
	String voca;
	int vLen; // �ܾ� ����

	public word(String voca, int vLen) {
		super();
		this.voca = voca;
		this.vLen = vLen;
	}
}

public class BOJ_1181_�ܾ�����_S5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		word[] arr = new word[num];

		for (int i = 0; i < num; i++) {
			// num Ƚ����ŭ �Է� �ޱ�
			String str = br.readLine();
			arr[i] = new word(str, str.length());
		}

//		comparator ���� ���
		Arrays.sort(arr, new Comparator<word>() {

			@Override
			public int compare(word o1, word o2) {
				if (o1.vLen == o2.vLen) {
					// ���� ���̰� ���� ���
					return (o1.voca).compareToIgnoreCase(o2.voca);
				}
				return o1.vLen - o2.vLen;
			}

		});

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			// �ߺ� ���ڿ� ó���� ��¹����� ����
			if (i<arr.length-1 && (arr[i].voca).equals(arr[i + 1].voca))
				continue;
			bw.append(arr[i].voca);
			bw.newLine();
//			sb.append(arr[i].voca).append('\n');
		}
		bw.flush();
	}
}
