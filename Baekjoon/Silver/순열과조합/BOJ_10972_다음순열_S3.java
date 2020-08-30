package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972_��������_S3 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(tk.nextToken());
		}
		
//		Arrays.sort(numbers);
		
//		do {
//			System.out.println(Arrays.toString(numbers));
//		}
//		while(nextPermutation(numbers));
		if(nextPermutation(numbers)) {
			
			for(int i=0;i<numbers.length;i++) {
				sb.append(numbers[i]).append(" ");
			}
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
		
	}
	
	static boolean nextPermutation(int[] numbers) {
		
		int i = N-1;
		// 1. �ڿ������� ������ ã��
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		if(i==0) return false;	// ���� �����
		
		// 2. ������ ���� ��(i-1��ġ)�� �ڿ��� �� ���� ���� ����� �� ã��
		int j = N-1;
		while(numbers[i-1]>=numbers[j])--j;
		
		// 3. i-1��ġ���� j��ġ�� ��ȯ (swap)
		swap(numbers, i-1, j);
		
		// 3. i��ġ���� �� �ڱ��� �������� ����
		int k = N-1;
		while(i<k) {
			swap(numbers, i++, k--);
		}
		
		return true; // ���� �����
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
