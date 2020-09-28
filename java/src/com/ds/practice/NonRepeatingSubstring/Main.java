package com.ds.practice.NonRepeatingSubstring;

public class Main {

    public static void main(String args[]) {
        NonRepeatingSubstringBruteForce nrssBF = new NonRepeatingSubstringBruteForce();
        System.out.println("Input string: a \n  Max non-repeating substring length: " + nrssBF.getNonRepeatingSubstring("a"));
        System.out.println("Input string: <Empty> \n  Max non-repeating substring length: " + nrssBF.getNonRepeatingSubstring(""));
        System.out.println("Input string: aa \n  Max non-repeating substring length: " + nrssBF.getNonRepeatingSubstring("aa"));
        System.out.println("Input string: ab \n  Max non-repeating substring length: " + nrssBF.getNonRepeatingSubstring("ab"));
        System.out.println("Input string: aab \n  Max non-repeating substring length: " + nrssBF.getNonRepeatingSubstring("aab"));
        System.out.println("Input string: dacdbc \n  Max non-repeating substring length: " + nrssBF.getNonRepeatingSubstring("dacdbc"));
        System.out.println("Input string: bcadgadga \n  Max non-repeating substring length: " + nrssBF.getNonRepeatingSubstring("bcadgadga"));

        System.out.println("\n----- Using two pointer or sliding window ---- ");
        NonRepeatingSubstringTwoPointer nrssTP = new NonRepeatingSubstringTwoPointer();

        System.out.println("Input string: a \n  Max non-repeating substring length: " + nrssTP.getNonRepeatingSubstring("a"));
        System.out.println("Input string: <Empty> \n  Max non-repeating substring length: " + nrssTP.getNonRepeatingSubstring(""));
        System.out.println("Input string: aa \n  Max non-repeating substring length: " + nrssTP.getNonRepeatingSubstring("aa"));
        System.out.println("Input string: ab \n  Max non-repeating substring length: " + nrssTP.getNonRepeatingSubstring("ab"));
        System.out.println("Input string: aab \n  Max non-repeating substring length: " + nrssTP.getNonRepeatingSubstring("aab"));
        System.out.println("Input string: dacdbc \n  Max non-repeating substring length: " + nrssTP.getNonRepeatingSubstring("dacdbc"));
        System.out.println("Input string: bcadgadga \n  Max non-repeating substring length: " + nrssTP.getNonRepeatingSubstring("bcadgadga"));

        System.out.println("\n----- Using two pointer or sliding window : Optimized ---- ");
        NonRepeatingSubstringTwoPointerOptimized nrssOpt = new NonRepeatingSubstringTwoPointerOptimized();

        System.out.println("Input string: a \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("a"));
        System.out.println("Input string: <Empty> \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring(""));
        System.out.println("Input string: aa \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("aa"));
        System.out.println("Input string: ab \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("ab"));
        System.out.println("Input string: aab \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("aab"));
        System.out.println("Input string: dacdbc \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("dacdbc"));
        System.out.println("Input string: bcadgadga \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("bcadgadga"));
        System.out.println("Input string: tmmzuxt \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("tmmzuxt"));
        System.out.println("Input string: aabaab!bb \n  Max non-repeating substring length: " + nrssOpt.getNonRepeatingSubstring("aabaab!bb"));


    }
}
