package com.ds.practice.GroupAnagrams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)  {
            return new ArrayList();
        }
        HashMap<String, List> res = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] charAr = strs[i].toCharArray();
            Arrays.sort(charAr);
            String key = String.valueOf(charAr);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList());
            }
            res.get(key).add(strs[i]);
        }
        return new ArrayList(res.values());
    }

    public static void main(String args[]) {
        GroupAnagrams ga = new GroupAnagrams();

        System.out.println("\nInput: [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"] \nOutput:"+ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));

    }
}
