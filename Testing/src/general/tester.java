package general;

public class tester {

	public static void main(String[] args) {
		String segment = "111";
		String oldSeq = "11100011";
		int index = oldSeq.indexOf(segment);
		String newSeq = oldSeq.substring(0,index) + oldSeq.substring(index + segment.length());
		
		System.out.println(newSeq);
	}
}
