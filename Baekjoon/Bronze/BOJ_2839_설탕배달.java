package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * ÃÖ´ëÇÑ ÀûÀº ºÀÁö
 * 5kg ºÀÁö, 3kg ºÀÁö
 * NÀ» 5·Î ³ª´« ¸ò - 5kg ºÀÁö ¼ö
 * (NÀ»5·Î ³ª´« ³ª¸ÓÁö)¸¦ 3kg ³ª´« ¸ò - 3kg ºÀÁö¼ö but 3kg·Î ³ª´©¾î ¶³¾îÁú ¶§¸¸!
 * 
 */

public class BOJ_2839_¼³ÅÁ¹è´Ş {
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
