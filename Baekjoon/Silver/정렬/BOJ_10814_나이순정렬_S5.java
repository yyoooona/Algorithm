package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person {
	int age;
	String name;

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

}

public class BOJ_10814_나이순정렬_S5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		int num = Integer.parseInt(br.readLine());
		Person[] p = new Person[num];

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			p[i] = new Person(age, name);
		}

		Arrays.sort(p, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {

				return o1.age - o2.age;
			}

		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(Person person:p) {
			bw.append(person.age+" "+person.name);
			bw.newLine();
		}
		bw.flush();
	}
}
