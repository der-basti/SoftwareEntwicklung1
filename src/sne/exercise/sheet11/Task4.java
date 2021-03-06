package sne.exercise.sheet11;

import StdLib.StdAudio;
import StdLib.StdIn;

/**
 * Modifizieren Sie das Programm PlayThatTuneDeluxe so, dass sie zusätzlich Harmonien in 
 * zwei Oktaven Entfernung von jeder Note mit der halben Gewichtung hinzufügen.
 * 
 * @author sne
 */
public class Task4 {

    public static double[] sum(double[] a, double[] b, double awt, double bwt) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * awt + b[i] * bwt;
        }
        return c;
    }
    // return a note of given pitch and duration

    public static double[] note(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double[] a = tone(1.0 * hz, duration);
        double[] hi = tone(2.0 * hz, duration);
        double[] lo = tone(0.5 * hz, duration);
        double[] ultra_hi = tone(4.0 * hz, duration);
        double[] ultra_lo = tone(0.25 * hz, duration);
        double[] uh = sum(ultra_hi, ultra_lo, .5, .5);
        double[] h = sum(hi, lo, .5, .5);
        double[] xh = sum(h, uh, .75, .25);
        return sum(a, xh, .5, .5);
    }

    public static double[] tone(double hz, double seconds) {
        int SAMPLE_RATE = 44100;
        int N = (int) (seconds * SAMPLE_RATE);
        double[] a = new double[N + 1];
        for (int i = 0; i <= N; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLE_RATE);
        }
        return a;
    }
    
    public static void main(String[] foo) {
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double[] a = note(pitch, duration);
            StdAudio.play(a);
        }
    }
}
