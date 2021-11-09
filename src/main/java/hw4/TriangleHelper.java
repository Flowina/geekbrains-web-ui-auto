package hw4;

public class TriangleHelper {
    public static double square(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException();
        }
        double p = (a + b + c) / 2;
        double s = Math.sqrt((p - a) * (p - b) * (p - c) * p);

        return s;
    }

}
