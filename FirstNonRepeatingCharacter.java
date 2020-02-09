/*
Given a string, find the first non-repeating character. 
For example, if the input string is “GoldmanSachs”, then output should be ‘G’ and if input string is “GoldmanGold”, then output should be ‘m’.
*/

/* Explanation: Brute force approach would be to have 2 pointers and check for each letter if it exists in the later part of                 the string. For example, ptr1 is at G(0th index), and pt2 will loop through the string oldmanSachs(string
                from 1st index to end of the string). But the time complexity would be O(n^2). 
                Better approach would be to store the count of each letter. For example in string "GoldmanGold", count for
                'G','o', 'l', 'd', would be 2 each and 'm' would be 1. so we'll return the index of 'm'. To store we can
                either use set, map or count array. To find the character, we need to traverse the array and to return the
                index of 'm',we'll have to traverse the string again, so time complexity would be O(n).
                But if we already store the index of the characters, traversing the string again won't be required anymore.
                We can use map to store the count and index with character as a key. Although, the time complexity would be
                O(n), this approach will save the time to traverse the string second time. And the space complexity would be
                O(n) as we'll be storing all the characters in the string.
            */
            
/*Approach: 1) To create a custom class CountAndIndex, with two variables count and index. To maintain the count of the
               characters and the index of the first occurence.
            2) Create Hashmap of type 'Character, CountAndIndex'.
            3) Traverse the string and update the hashmap. If character is encountered first time, store its index, else
               increment the count.
            4) Traverse the map to find the first non-repeating character.            
            */
           
           
import java.util.HashMap;
import java.util.Map;

class CountAndIndex {
	public int count = 0;
	public int index = -1;

	CountAndIndex(int index) {
		count = 1;
		this.index = index;
	}

	public void coundIncrementor() {
		this.count++;
	}

}

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String str = "GoldmanGold";
		char op = findNonRepeatingChar(str);
		System.out.println(op);
	}

	private static char findNonRepeatingChar(String str) {
		Map<Character, CountAndIndex> characterCount = new HashMap<Character, CountAndIndex>();

		for (int i = 0; i < str.length(); i++) {
			if (characterCount.containsKey(str.charAt(i)))
				characterCount.get(str.charAt(i)).coundIncrementor();
			else
				characterCount.put(str.charAt(i), new CountAndIndex(i));
		}

		char result = 0;

		for (Map.Entry<Character, CountAndIndex> entry : characterCount.entrySet()) {
			if (entry.getValue().count == 1 && result > entry.getValue().index)
				result = entry.getKey();
		}
		return result;
	}
}
            
              
             

