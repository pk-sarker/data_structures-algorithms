package com.ds.practice.Palindrome;

public class Palindrome {

    public boolean check(String str) {
        int n = str.length();
        for (int i = 0; i <  n/2; i++) {
            if (str.charAt(i) != str.charAt(n-1-i)) {
                return false;
            }
        }
        return true;
    }

    // Check only alphanumeric characters
    // Ignore cases
    public boolean check2(String str) {
        int n = str.length();
        for (int i=0, j=n-1; i<j; i++, j--) {
            while(i<j && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            }
            if (i<j && Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Palindrome pl = new Palindrome();
        System.out.println("\nInput: \"abcdjdcba\" \nOutput: " + pl.check("abcdjdcba"));
        System.out.println("\nInput: \"abccba\" \nOutput: " + pl.check("abccba"));

        System.out.println("\nInput: \"abc c ba\" \nOutput: " + pl.check2("abc c ba"));


    }
}
