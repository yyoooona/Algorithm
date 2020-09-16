# BufferedWriter StringBuilder보다 메모리 더 작게 쓴다

## BufferedWriter 사용법

BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.append( );
bw.newLine();

# Comparator정렬 사용법

Arrays.sort(p, new Comparator<Person>(){
// unimplement method 구현
@Override
	public int compare(Person o1, Person o2) {
				
		return 0;
	}

});