package com.practice;

import java.util.*;

public class AnalyzeWebsiteVisitPatternOptimized {
    private class Node {
        String name;
        int time;
        String web;

        public Node(String name, int time, String web) {
            this.name = name;
            this.time = time;
            this.web = web;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.name.equals(n2.name) ? n1.time - n2.time : n1.name.compareTo(n2.name));
        for (int i = 0; i < username.length; i++) {
            Node node = new Node(username[i], timestamp[i], website[i]);
            queue.add(node);
        }

        Map<List<String>, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            List<String> webList = new ArrayList<>();
            Node first = queue.poll();
            webList.add(first.web);
            while (!queue.isEmpty() && queue.peek().name.equals(first.name)) {
                Node temp = queue.poll();
                webList.add(temp.web);
            }
            helper(webList, map);
        }

        PriorityQueue<List<String>> res = new PriorityQueue<>((n1, n2) -> map.get(n2) == map.get(n1) ? (n1.get(0).equals(n2.get(0)) ? (n1.get(1).equals(n2.get(1)) ? (n1.get(2).compareTo(n2.get(2))) : n1.get(1).compareTo(n2.get(1))) : n1.get(0).compareTo(n2.get(0))) : map.get(n2) - map.get(n1));
        for (List<String> a: map.keySet()) {
            res.add(a);
        }
        return res.poll();
    }

    void helper(List<String> list, Map<List<String>, Integer> map) {
        if (list.size() < 3) return;
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < list.size()-2; i++) {
            for (int j = i+1; j < list.size()-1; j++) {
                for (int k = j+1; k < list.size(); k++) {
                    helper1(list, map, i, j, k, set);
                }
            }
        }
    }

    void helper1(List<String> list, Map<List<String>, Integer> map, int i, int j, int k, Set<List<String>> set) {
        List<String> out = new ArrayList<>();
        out.add(list.get(i));
        out.add(list.get(j));
        out.add(list.get(k));
        if (set.contains(out)) return;
        set.add(out);
        if (!map.containsKey(out)) {
            map.put(out, 1);
        } else {
            map.put(out, map.get(out)+1);
        }
    }

    public static void main(String args[]) {
        AnalyzeWebsiteVisitPatternOptimized obj = new AnalyzeWebsiteVisitPatternOptimized();
        String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[]{1,2,3,4,5,6,7,8,9,10};
        String[] website = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};
        List<String> result = obj.mostVisitedPattern(username, timestamp, website);

        System.out.println(result);
    }
}
