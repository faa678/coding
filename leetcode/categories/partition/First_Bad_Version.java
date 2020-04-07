package com.faa.leetcode.partition;

public class First_Bad_Version {

    private static boolean isBadVersion(int n)  {
        if(n < 5) return false;
        return true;
    }
    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(isBadVersion(m)) r = m - 1;
            else if(!isBadVersion(m)) l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(7));
    }

}
