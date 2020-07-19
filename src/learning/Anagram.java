package learning;

public class Anagram {
    public static void main(String[] args) {
        int[] charCount1 = getChars("hawyk");
        int[] charCount2 = getChars("aykh");

        int delta = getDelta(charCount1, charCount2);

        System.out.println("Delta: " + delta);
    }

    private static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return -1;
        }
        int delta = 0;
        for (int i = 0; i < array1.length; i++) {
            delta += Math.abs(array1[i] - array2[i]);
        }
        return delta;
    }

    static int[] getChars(String s) {
        int length = s.length();
        int[] charsCount = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = c - offset; // letter
            charsCount[code]++;
        }
        return charsCount;
    }
}
