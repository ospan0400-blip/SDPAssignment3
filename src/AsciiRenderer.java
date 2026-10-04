public class AsciiRenderer implements Renderer {
    @Override
    public String renderCircle(int id, double radius) {
        return String.format("[ASCII] Circle #%d (o) r=%.1f", id, radius);
    }

    @Override
    public String renderSquare(int id, double side) {
        return String.format("[ASCII] Square #%d [] s=%.1f", id, side);
    }
}