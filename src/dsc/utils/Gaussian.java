/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc.utils;

import StdLib.StdOut;
import sne.utils.Out;

/**
 *
 * @author david
 */
public class Gaussian {

    public static double phi(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public static double phi(double x, double mu, double sigma) {
        return phi((x - mu) / sigma) / sigma;

    }

    public static double Phi(double z) {
        if (z < -8.0) {
            return 0.0;
        }
        if (z > 8.0) {
            return 1.0;
        }
        double sum = 0.0, term = z;
        for (int i = 3; sum + term != sum; i += 2) {
            sum = sum + term;
            term = term * z * z / i;
        }
        return 0.5 + sum * phi(z);
    }

    public static double Phi(double z, double mu, double sigma) {
        return Phi((z - mu) / sigma);
    }

    public static double PhiInverse(double mu, double sigma, double y) {
        int epsilon = 6;
        double z = 0.5;
        while (Out.round(Phi(z, mu, sigma), epsilon) != Out.round(y, epsilon)) {

            if (y < Phi(z, mu, sigma)) {
                z = z / 2;
            } else {
                z = z + z / 2;
            }
//            System.out.println(z + " " + Phi(z, mu, sigma));
        }
        return z;
    }
    

    public static double PhiInverse2(double y) {
        return PhiInverse2(y, .00000001, -8, 8);
    }

    public static double PhiInverse2(double y, double delta, double lo, double hi) {
        double m = lo + (hi - lo) / 2;
        if (hi - lo < delta) {
            return m;
        }
        if (Gaussian.Phi(m) > y) {
            return PhiInverse2(y, delta, lo, m);
        } else {
            return PhiInverse2(y, delta, m, hi);
        }
    }
}