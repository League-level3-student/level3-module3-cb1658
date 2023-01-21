package _02_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
    	str = str.toLowerCase();
    	    	
    	ArrayList<String> arrlist = new ArrayList<String>();
    	
    	ArrayList<Integer> indexList = new ArrayList<Integer>();
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(!Character.isWhitespace(str.charAt(i))) {
    			indexList.add(i);
    		}
    	}
    	
    	
    	for(int k = 0; k < indexList.size(); k++) {
    		StringBuilder bob = new StringBuilder();
    		for(int a = 0; a < str.length(); a++) {
    			if(a == indexList.get(k)) {
    				bob.append(Character.toUpperCase(str.charAt(a)));
    			}
    			else {
    				bob.append(str.charAt(a));
    			}
    		}
    		arrlist.add(bob.toString());
    	}
   
        return arrlist;
    }
}































































//    	for(int i = 0; i< str.length(); i++) {
//    		StringBuilder bob = new StringBuilder();
//    		int memory = i;
//    		
//    		for(int k = 0; k< str.length(); k++) {
//    			char a = str.charAt(k);
//    			if(!Character.isWhitespace(a) && k == i) {
//    				bob.append(Character.toUpperCase(a));
//    			}
//    			else if(Character.isWhitespace(a) && k == i){
//    				memory = k;
////    				 	while(Character.isWhitespace(a)) {
////    				 		if(Character.isWhitespace(str.charAt(memory))) {
////    				 			bob.append(str.charAt(memory));
////    				 			if(memory == str.length()-1) {
////    				 				break;
////    				 			}
////    				 			memory += 1;
////    				 			a = str.charAt(memory);
////    				 		}
////
////    				 		else {
////    				 			bob.append(Character.toUpperCase(str.charAt(memory)));
////    				 		}
////    				 	}
//    				 	
//    			}
//    			else {
//    				bob.append(a);
//    			}
//
//    		}
//    		arrlist.add(bob.toString());
//    	}
//     