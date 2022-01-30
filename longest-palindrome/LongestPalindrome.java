import java.io.*;
import java.util.*;

public class LongestPalindrome {
    public LongestPalindrome() {
        System.out.println("hello");
    }

    public void printmessage() { System.out.println("message"); }

    public String getLongestPalindrome(String input) {
        // decompose
        Map<Character, Integer> occurrences = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            Integer currentOccur = occurrences.get(currentLetter);
            if (currentOccur != null) {
                occurrences.put(currentLetter, currentOccur+1);
            } else {
                occurrences.put(currentLetter, 1);
            }
        }
        // recursively recompose into longest palindrome
        String k = String.valueOf(occurrences.keySet().toArray());
        System.out.println(k);
        String thelongestPalindrome = this.recompose(occurrences, k, "");
        return thelongestPalindrome;
    }

    public String recompose(Map<Character, Integer> numOccur, String mapKeys, String accum) {
        
        if (mapKeys.length() > 0)  {
            StringBuilder updatedAccumBuilder = new StringBuilder();
            String updatedAccum;
            char currentKey = mapKeys.charAt(0);
            int nums = numOccur.get(currentKey);
            if (nums % 2 == 0) {
                for (int j = 0; j < nums/2; j++) {
                    updatedAccumBuilder.append(currentKey);
                }
                // add to ends
                updatedAccum = updatedAccumBuilder.toString() + accum + updatedAccumBuilder.toString();
            } else if (accum.length() % 2 == 0) {
                for (int j = 0; j < nums; j++) {
                    updatedAccumBuilder.append(currentKey);
                }
                // add to center if length() of accum is even
                updatedAccum = accum.substring(0, accum.length()/2) + updatedAccumBuilder.toString() + accum.substring(accum.length()/2);
            } else {
                updatedAccum = accum;
            }
            this.recompose(numOccur, mapKeys.substring(1), updatedAccum);
        }
        return accum;
    } 
}