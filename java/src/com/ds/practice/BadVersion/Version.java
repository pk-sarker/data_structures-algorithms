package com.ds.practice.BadVersion;

public class Version {
    int firstBadVersion;
    public Version(int setFirstBadVersion) {
        this.firstBadVersion = setFirstBadVersion;
    }

    public int findFirstBadVersion(int n){
        int left = 0;
        int right = n;
        int midIndex = 0;

        while(left < right) {
            midIndex = left + (right - left)/2;
            if (this.isBadVersion(midIndex)) {
                right = midIndex;
            } else {
                left = midIndex + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        if (n >= this.firstBadVersion) {
            return true;
        }
        return false;
    }
    public static void main(String args[]) {
        Version v = new Version(7);
        System.out.println("N=10 First bad version 7 = check "+v.findFirstBadVersion(10));

        v = new Version(3);
        System.out.println("N=11 First bad version 3 = check "+v.findFirstBadVersion(11));
    }
}
