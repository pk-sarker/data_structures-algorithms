package com.practice;

/**
 * Given two strings S and T, return if they are equal when both
 * are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class BackspaceCompare {

    public static boolean backspaceCompare(String S, String T) {
        int idx_s = S.length() - 1, idx_t = T.length() - 1;
        int skipCountS = 0, skipCountT = 0;

        while(idx_s >= 0 || idx_t>=0) {

            // point to last non-back space char in S
            while(idx_s>=0) {
                if (S.charAt(idx_s) == '#') {
                    skipCountS++;
                    idx_s--;
                } else if (skipCountS> 0) {
                    skipCountS--;
                    idx_s--;
                } else {
                    break;
                }
            }

            // point to last non-back space char in T
            while(idx_t>=0) {
                if (T.charAt(idx_t) == '#') {
                    skipCountT++;
                    idx_t--;
                } else if (skipCountT> 0) {
                    skipCountT--;
                    idx_t--;
                } else {
                    break;
                }
            }

            if (idx_s >= 0 && idx_t >= 0 && S.charAt(idx_s) != T.charAt(idx_t)) {
                return false;
            }
            // if one string is reached to the beginning and another has still chars to reach beginning
            // aab , ab
            if ((idx_s>=0) != (idx_t >= 0)) {
                return false;
            }
            idx_s--;
            idx_t--;
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println("\nInput: S=\"ab#c\" T=\"ad#c\" \nOutput: " +
                BackspaceCompare.backspaceCompare("ab#c", "ad#c"));

        System.out.println("\nInput: S=\"ab##\" T=\"c#d#\" \nOutput: " +
                BackspaceCompare.backspaceCompare("ab##", "c#d#"));

        System.out.println("\nInput: S=\"a##c\" T=\"#a#c\" \nOutput: " +
                BackspaceCompare.backspaceCompare("a##c", "#a#c"));

        System.out.println("\nInput: S=\"a##c\" T=\"#a#c\" \nOutput: " +
                BackspaceCompare.backspaceCompare("a##c", "#a#c"));
    }
}
