public class RasterRenderer implements Renderer {
    @Override
    public String renderCircle(int id, double radius) {
        return String.format("[Raster] Circle #%d with pixels (radius: %.1f)", id, radius);
    }

    @Override
    public String renderSquare(int id, double side) {
        return String.format("[Raster] Square #%d with pixels (side: %.1f)", id, side);
    }
}