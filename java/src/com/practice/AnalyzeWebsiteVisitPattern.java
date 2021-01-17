package com.practice;

import java.util.*;

/**
 * We are given some website visits: the user with name username[i] visited the website
 * website[i] at time timestamp[i].
 *
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of
 * their visits.  (The websites in a 3-sequence are not necessarily distinct.)
 *
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution,
 * return the lexicographically smallest such 3-sequence.
 *
 * Input:
 * username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output:
 * ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 */
public class AnalyzeWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<String> result = new ArrayList<>();
        // 1. group each single visit, add in a single list, list[name, timestap, web] and then put in
        // list of visits
        List<List<String>> visits = new ArrayList<>();
        for(int i=0; i<n; i++) {
            List<String> visit = new ArrayList<>();
            visit.add(username[i]);
            visit.add(""+timestamp[i]);
            visit.add(website[i]);
            visits.add(visit);
        }
        // 2. Sort the visits by timestamp
        visits.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> visit1, List<String> visit2) {
                return Integer.parseInt(visit1.get(1))-Integer.parseInt(visit2.get(1));
            }
        });
        // 3. Group visits by user, Create each users visited mapping
        Map<String, List<String>> userVisits = new HashMap<>();
        for (List<String> visit : visits) {
            List<String> visitedWebsites = userVisits.getOrDefault(visit.get(0), new ArrayList<String>());
            visitedWebsites.add(visit.get(2));
            userVisits.put(visit.get(0), visitedWebsites);
        }
        // 34. find each user list and build all 3-sequences and count by map
        // {3seq => count}
        Map<String, Integer> sequenceMap = new HashMap<>();
        int maxCount = 0;
        StringBuilder maxSeq = new StringBuilder();
        for(String user: userVisits.keySet()) {
            List<String> userVisitList = userVisits.get(user);
            if (userVisitList.size() < 3) {
                continue;
            }
            Set<String> subSequence = getSubSequence(userVisitList);

            for(String seq : subSequence) {
                int count = sequenceMap.getOrDefault(seq, 0)+1;
                sequenceMap.put(seq, count);
                if (count > maxCount) {
                    maxCount = count;
                    maxSeq.setLength(0);
                    maxSeq.append(seq);
                } else if(count == maxCount && seq.compareTo(maxSeq.toString()) < 0) {
                    maxSeq.setLength(0);
                    maxSeq.append(seq);
                }
            }
        }
        if (maxSeq.length()>0) {
            String[] websiteList = maxSeq.toString().split("_");
            for(String web : websiteList) {
                result.add(web);
            }
        }
        return result;
    }

    public Set<String> getSubSequence(List<String> websites) {
        Set<String> set = new TreeSet<>();
        int n = websites.size();
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    // website1_website2_website3
                    set.add(websites.get(i) + "_" + websites.get(j) + "_" + websites.get(k));
                }
            }
        }
        return set;
    }

    public static void main(String args[]) {
        AnalyzeWebsiteVisitPattern obj = new AnalyzeWebsiteVisitPattern();
        String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[]{1,2,3,4,5,6,7,8,9,10};
        String[] website = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};
        List<String> result = obj.mostVisitedPattern(username, timestamp, website);

        System.out.println(result);

        username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary","pijus","pijus","pijus"};
        timestamp = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        website = new String[]{"home","career","about","home","career","maps","abcd","home","career","about", "home","career","abcd"};
        List<String> result1 = obj.mostVisitedPattern(username, timestamp, website);

        System.out.println(result1);
    }

}
