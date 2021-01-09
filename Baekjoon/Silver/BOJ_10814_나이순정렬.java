package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {

	public static class Person implements Comparable<Person> {
		int age, regDate;
		String name;

		public Person(int age, String name, int regDate) {
			super();
			this.age = age;
			this.name = name;
			this.regDate = regDate;
		}

		@Override
		public int compareTo(Person o) {
			if (this.age == o.age) { // this.age == o.age
				return this.regDate - o.regDate;
			}
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Person> pq = new PriorityQueue<Person>();

		// 입력 받기
		for (int tc = 1; tc <= N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int regDate = tc;

			pq.add(new Person(age, name, regDate));
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {
			Person p = pq.poll();
			sb.append(p.age).append(' ').append(p.name).append('\n');
		}

		System.out.println(sb);
	}
}
