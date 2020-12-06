package com.ds.practice.AlienDictionary;

public class AlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        if (n==0) {
            return false;
        }
        int[] dictionary = new  int[order.length()];
        for(int i =0;i<order.length();i++) {
            dictionary[order.charAt(i)-'a'] = i;
        }

        search: for(int i=0;i<n-1;++i) {
            String w1 = words[i];
            String w2 = words[i+1];
            for (int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    // If they compare badly, it's not sorted.
                    if (dictionary[w1.charAt(j) - 'a'] > dictionary[w2.charAt(j) - 'a'])
                        return false;
                    continue search;
                }
            }

            if (w1.length() > w2.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        AlienDictionary ad = new AlienDictionary();

        System.out.println("\nword=[\"hello\",\"leetcode\"] dictionary=\"hlabcdefgijkmnopqrstuvwxyz\"\nSorted in Lexicographically : "
                + ad.isAlienSorted(new String[]{"hellp", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println("\nword=[\"word\",\"world\",\"row\"] dictionary=\"worldabcefghijkmnpqstuvxyz\"\nSorted in Lexicographically : "
                + ad.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));

        System.out.println("\nword=[\"apple\",\"app\"] dictionary=\"abcdefghijklmnopqrstuvwxyz\"\nSorted in Lexicographically : "
                + ad.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println("\nword=[\"app\",\"apple\"] dictionary=\"abcdefghijklmnopqrstuvwxyz\"\nSorted in Lexicographically : "
                + ad.isAlienSorted(new String[]{"app","apple"}, "abcdefghijklmnopqrstuvwxyz"));

        System.out.println("\nword=[\"kuvp\",\"q\"] dictionary=\"ngxlkthsjuoqcpavbfdermiywz\"\nSorted in Lexicographically : "
                + ad.isAlienSorted(new String[]{"kuvp","q"}, "ngxlkthsjuoqcpavbfdermiywz"));

        System.out.println("\nword=[\"ab\",\"cde\"] dictionary=\"abcdefghijklmnopqrstuvwxyz\"\nSorted in Lexicographically : "
                + ad.isAlienSorted(new String[]{"ac","ac"}, "abcdefghijklmnopqrstuvwxyz"));

    }
}
