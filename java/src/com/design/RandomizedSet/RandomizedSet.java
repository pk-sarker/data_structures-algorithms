package com.design.RandomizedSet;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    Map<Integer, Integer> hashMap = new HashMap<>();
    List<Integer> list =  new ArrayList<>();

    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }

        hashMap.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        }
        int lastIndex = list.size()-1;
        Integer index = hashMap.get(val);
        list.set(index, list.get(lastIndex));
        hashMap.put(list.get(lastIndex), index);
        list.remove(lastIndex);
        hashMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        if (list.size()==1) {
            return list.get(0);
        }
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String args[]) {
        // ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
        //[[], [1], [2], [2], [], [1], [2], []]
        RandomizedSet rs = new RandomizedSet();
        System.out.print(rs.insert(1) + " ");
        System.out.print(rs.remove(2) + " ");
        System.out.print(rs.insert(2) + " ");
        System.out.print(rs.getRandom() + " ");
        System.out.print(rs.remove(1) + " ");
        System.out.print((rs.insert(2) + " "));
        System.out.print(rs.getRandom() + " ");
        // true, false, true, 2, true, false, 2

    }
}
