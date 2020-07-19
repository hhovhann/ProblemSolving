package learning;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestCommonSubsequenceOfTwoStrings {
    static Set<Character> resultList = new LinkedHashSet<>();
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        // "ABAZDC", "BACBAD" => ABAD
        // "AGGTAB", "GXTXAYB" => "GTAB"
        // "aaaa", "aa"    => "aa"
        var resultList = new ArrayList<Character>();
        // given
        String firstString = "ABAZDC";
        String secondString = "GXTXAYB";

        char[] firstChars = firstString.toCharArray();
        int firstSize = firstChars.length;
        char[] secondChars = secondString.toCharArray();
        int secondSize = secondChars.length;

        //then
        System.out.println("Common Subsequence length is: " + lcs1(firstChars, secondChars, firstSize, secondSize));
        System.out.println("Common Subsequence length is: " + lcs(firstChars, secondChars, firstSize, secondSize));
        System.out.println("Common Subsequence is: " + resultList.toString());
        System.out.println("Common Subsequence is: " + builder.toString());
    }

    /*
    Write a function that takes two strings, s1 and s2 and returns the longest common sequence of s1 and s2
     */
    static int lcs(char[] firstChars, char[] secondChars, int firstSize, int secondSize) {
        if (firstSize == 0 || secondSize == 0) {
            return 0;
        }
        if (firstChars[firstSize - 1] == secondChars[secondSize - 1]) {
            return 1 + lcs(firstChars, secondChars, firstSize - 1, secondSize - 1);
        } else {
            return Math.max(lcs(firstChars, secondChars, firstSize, secondSize - 1), lcs(firstChars, secondChars, firstSize - 1, secondSize));
        }
    }

    static String lcs1(char[] firstChars, char[] secondChars, int firstSize, int secondSize){
        int newArraySize = Math.max(firstSize, secondSize);
        char[] filtered =  new char[newArraySize];

      return "";
    }
}