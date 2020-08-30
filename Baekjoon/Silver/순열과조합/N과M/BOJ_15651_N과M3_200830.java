package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3_S3 {
	// 중복 순열
	static int N, R;	// 1~N까지의 숫자 중 R개를 뽑아 순서가 유의미한 중복순열
						// 중복 순열이기 때문에 isSelected check 불필요
	static int[] numbers, input;	// numbers 는 뽑은 순열, input은 입력 숫자배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		R = Integer.parseInt(tk.nextToken());
		input = new int[N];
		numbers = new int[R];
		for(int i=0; i<N; i++) {
			input[i]=i+1;
		}
		
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if(cnt==R) {
			for(int i=0; i<R; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			numbers[cnt]=input[i];
			permutation(cnt+1);
		}
	}
}
