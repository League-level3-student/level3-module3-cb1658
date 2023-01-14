package _00_Intro_To_String_Methods;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        if(s1.length()>s2.length()) {
        	return s1;
        }
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if(s.contains("underscores")) {
    		return s.replace(' ', '_');
    	}
    	return s; 
    }
    
    /////////////////////////////////// CONTINUE BELOW ///////////////////////////////////////////////
    
    

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	String s11 = s1.trim();
    	String s21 = s2.trim();
    	String s31 = s3.trim();
    	int lowest = s11.charAt(s11.indexOf(" ")+1);
    	
    	if(s21.charAt(s21.indexOf(" ")+1)<lowest) {
    		lowest = s21.charAt(s11.indexOf(" ")+1);
    	}
    	if(s31.charAt(s31.indexOf(" ")+1)<lowest) {
    		lowest = s31.charAt(s31.indexOf(" ")+1);
    	}
    	
    	if(lowest == s11.charAt(s11.indexOf(" ")+1)) {
    		return s11;
    	}
    	if(lowest == s21.charAt(s21.indexOf(" ")+1)) {
    		return s21;
    	}
    	if(lowest == s31.charAt(s31.indexOf(" ")+1)) {
    		return s31;
    	}
    	return null;
    }
    
    
    
    
    
    
    
    

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(Character.isDigit(s.charAt(i))) {
    			sum = sum + s.charAt(i)-48;
    		}
    	}
        return sum;
    }

    
    
    
    
    
    
    
    
    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int numOccurances = 0;
    	int i = 0;
        int index = s.indexOf(substring, i);
        
		while(index != -1) {
			
			numOccurances++;
			i = index+substring.length();
			
			index = s.indexOf(substring, i);
		}
        return numOccurances;
        
    }
    
    
    
    
    
    
    
    

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
        return Utilities.encrypt(s.getBytes(),(byte) key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        return Utilities.decrypt(s, (byte) key);
    }
    
    
    
    
    
    
    
    
    
    

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
        String[] words = s.split(" ");
        int count = 0;
        for(String i : words) {
        	if(i.endsWith(substring)) {
        		count++;
        	}
        }      
        return count;
    }

    
    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        int firstOcc = s.indexOf(substring);
    	int lastOcc = s.lastIndexOf(substring);
    	
    	return lastOcc-firstOcc-substring.length();
    }
    
    

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
        String ss = s.trim();
        String sss = ss.toLowerCase();
        String ssss = "";
        for(int i = 0; i < sss.length(); i++) {
        	if(Character.isLetterOrDigit(sss.charAt(i))) {
        		ssss += sss.charAt(i);
        	}
        }
        
        Boolean maybe = true;
        
        for(int k = 0; k < ssss.length(); k++) {
        	if(ssss.charAt(k) != ssss.charAt(ssss.length()-k-1)) {
        		maybe = false;
        	}
        }
        
        return maybe;
        
    }
}











class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
