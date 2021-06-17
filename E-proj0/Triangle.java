
public class Triangle {
   

    public static void main(String[] args) {

        // read in bounding box and rescale
        double x0 = System.in.readDouble();
        double y0 = System.in.readDouble();
        double x1 = System.in.readDouble();
        double y1 = System.in.readDouble();
        StdDraw.setXscale(x0, x1);
        StdDraw.setYscale(y0, y1);

        // for bigger points
        StdDraw.setPenRadius(0.005);

        // to speed up performance, defer displaying points
        StdDraw.enableDoubleBuffering();

        // plot points, one at a time
        while (!System.in.isEmpty()) {
            double x = System.in.readDouble();
            double y = System.in.readDouble();
            StdDraw.point(x, y);
        }

        // display all of the points now
        StdDraw.show();

    }
}
