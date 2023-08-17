public class Q3 {
    public static void main(String[] args) {
        draw(0.5, 'b');
    }

    public static void draw(double radius, char color) {
        if (color == 'w') {
            StdDraw.setPenColor(StdDraw.WHITE);
            double x = radius;
            while (x < 1.0) {
                StdDraw.filledCircle(x, 0.5, radius);
                x += 2 * radius;
            }
            draw(radius/2,'b');
        } else {
            StdDraw.setPenColor(StdDraw.BLACK);
            double x = radius;
            while (x < 1.0) {
                StdDraw.filledCircle(x, 0.5, radius);
                x += 2 * radius;
            }
            draw(radius/2,'w');
        }
    }
}
