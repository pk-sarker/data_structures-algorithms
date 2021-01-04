package com.ds.practice.LongestCommonPrefix;

public class LongestCommonPrefix {

    // Horizontal Scanning
    // LCM(S1..Sn) = LCM(LCM(LCM(S1,S2),S3)..Sn)
    // so first we compare and get common prefix of S1 and S2
    // Then find common prefix between last prefix and next word/S3
    // First we consider first word is the prefix and then try to compare
    //   if the prefix is not a substring of current word then we truncate the prefix by
    //   removing the last character of the prefix
    public String longestCommonPrefix(String[] words) {
        if (words.length ==0 ) {
            return "";
        }
        String prefix = words[0];
        for(int i=1; i<words.length; i++) {
            System.out.println("Prefix:" +prefix+" word:"+words[i]+", index: "+words[i].indexOf(prefix));
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    // Vertical Scanning
    public String longestCommonPrefixVS(String[] words) {
        if (words.length == 0) {
            return "";
        }
        for(int i=0; i<words[0].length();i++) {
            char c = words[0].charAt(i);
            for(int j=1; j<words.length; j++) {
                if (words[j].length() <= i || c != words[j].charAt(i)) {
                    return words[j].substring(0, i);
                }
            }
        }

        return words[0];
    }
    public static void main(String args[]) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();

        System.out.println("\nInput: [\"flower\",\"flow\",\"flight\"] \nOutput: " + lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("\nInput: [\"flower\",\"flow\",\"flight\"] \nOutput: " + lcp.longestCommonPrefixVS(new String[]{"flower","flow","flight"}));
        System.out.println("\nInput: [\"ab\",\"a\"] \nOutput: " + lcp.longestCommonPrefixVS(new String[]{"ab","a"}));

    }
}
