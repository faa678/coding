package com.faa.leetcode.partition;

public class Sqrt {

    public int mySqrt(int x) {
        int result = 0;

        int l = 1, r = (x >> 1);//位操作优先级小于＋
//        while(l <= r) {
//            int mid = l + (r - l) / 2;
//            int mul = mid * mid;//会越界的
//            if(mul > x) r = mid - 1;
//            else if(mul < x) l = mid + 1;
//            else return mid;
//
//        }

        while(l <= r) {
            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if(sqrt == mid) return mid;
            else if(sqrt > mid) l = mid + 1;
            else r = mid - 1;
        }

        return r;//sqrt != mid时，跳出循环之前肯定是左小于x, 右大于x。l > r跳出循环
    }

    static int partition(int n, int t) {

        int l = 0, r = n;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(mid == t) return mid;
            else if(mid < t) l = mid + 1;
            else r = mid - 1;
        }

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(8));
        System.out.println(partition(100, 105));
    }
}
