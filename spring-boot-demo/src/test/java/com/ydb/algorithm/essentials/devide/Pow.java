package com.ydb.algorithm.essentials.devide;

/**
 * @Author ligeng
 * @Date 19/8/20
 * @Time 上午9:56
 */
public class Pow {
    public static void main(String[] args) {
        Pow solution = new Pow();
        System.out.println(solution.myPow(2,5));
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    private double power(double x, int n) {
        if (n==0) return 1;
        if (n==1) return x;

        double v = power(x, n/2);

        if (n%2 == 0) {
            return v*v;
        } else {
            return v*v*x;
        }
    }
}
