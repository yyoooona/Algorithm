package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int strLen = str.length();
		int c = 0;
		int count = 0;
//		System.out.println(str.substring(0, 2));
		f: while (true) {
			boolean flag = false;

			if (strLen == 0 || strLen == 1) {
				if (strLen == 1) {
					count += 1;
				}
				break;
			}

			for (String s : croatia) {
				if (s.equals(str.substring(0, 2))) {
					str = str.substring(2, str.length());
//					System.out.println("str : " + str);
					count += 1;
					strLen -= 2;
					flag = true;

					break;
				}
				if (str.length() >= 3) {
					if (s.equals(str.substring(0, 3))) {
						str = str.substring(3, str.length());
//						System.out.println("str : " + str);
						count += 1;
						strLen -= 3;
						flag = true;

						break;
					}
				}
			}

			if (flag == false) { // 크로아티아 알파벳이 없을 때
				str = str.substring(1, str.length());
//				System.out.println("str : " + str);
				strLen -= 1;
				count += 1;
			}
		} // end of while문

		System.out.println(count);
	} // end of main
}
