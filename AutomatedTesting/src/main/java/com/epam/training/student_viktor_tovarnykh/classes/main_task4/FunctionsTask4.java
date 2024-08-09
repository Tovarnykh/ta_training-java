package com.epam.rd.autotasks;

public class FunctionsTask4 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static double sumGeometricElements(int a1, double t, int alim) {

        if (t>0 && t<1) {
            if (a1>alim && a1>0) {
                if (alim>=0) {
                    double x=a1;
                    double sum = 0;
                    while(x>alim) {
                        sum = sum +x;
                        x=x*t;
                        if(x<0.001) break;
                    }
                    sum = Math.round(sum);
                    return sum;
                }
                else throw new IllegalArgumentException();
            }
            else throw new IllegalArgumentException();
        }
        else throw new IllegalArgumentException();
    }
}
