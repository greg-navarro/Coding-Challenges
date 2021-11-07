import java.io.*;
import java.util.*;

class LongestPalindrome {
    public static String getLongestPalidrome(String input) {
        // decompose
        Map<char, int> occurrences = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (occurrences.keys().contains(input[i])) {
                occurrences.put(input[i], occurrences.get(input[i])+1);
            } else {
                occurrences.put(input[i], 1);
            }
        }
        // recursively recompose into longest palindrome
        String k = occurrences.keys().join();
        String longestPalindrome = LongestPalindrome.recompose(occurrences, k, "");
    }

    public static String recompose(Map<char, int> numOccur, String mapKeys, String accum) {
        if (mapKeys.length > 0)  {
            StringBuilder updatedAccumBuilder;
            String updatedAccum;
            Char currentKey = mapKeys[0];
            int nums = numOccur.get(currentKey);
            if (nums % 2 == 0) {
                for (int j = 0; j < nums/2; j++) {
                    updatedAccumBuilder.append(currentKey);
                }
                // add to ends
                updatedAccum = updatedAccumBuilder.toString() + accum + updatedAccumBuilder.toString();
            } else if (accum.length % 2 == 0) {
                for (int j = 0; j < nums; j++) {
                    updatedAccumBuilder.append(currentKey);
                }
                // add to center if length of accum is even
                updatedAccum = accum.substring(0, accum.length/2) + updatedAccumBuilder.toString + accum.substring(accum.length/2);
            } else {
                updatedAccum = accum;
            }
            LongestPalindrome.recompose(numOccur, mapKeys.substring(1), updatedAccum)
        }
        return accum;
    } 
}