//challenge: “Implement a method to perform basic string compression using the counts of repeated characters.
//for example, the string “aabcccccaaa” would become “a2b1c5a3”.
//if the “compressed” string would not become smaller than the original string,
//your method should return the original string.”

import java.lang.StringBuffer;

public class SimpleCompression {
	public static void main(String[] args) {
				
		// simple input checking
		if(args.length < 1) {
			System.out.println("usage: java SimpleCompression <input string>");
			System.exit(1);	
		}
		
		String s = new String(args[0]);
		StringBuffer compressed = new StringBuffer();

		int count = 1;			
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i-1) == s.charAt(i)) { //if we encounter the same character repeatedly, increment counter
				count += 1;
			} else { //otherwise reset the current sequence and counter
				compressed.append(s.charAt(i-1) + Integer.toString(count));
				count = 1;
			}
		}
		//when loop exits, last char and its' count are not yet appended.
		compressed.append(s.charAt(s.length()-1) + Integer.toString(count));
		System.out.println(compressed.length() <= s.length() ? compressed : s);		
	}
}
