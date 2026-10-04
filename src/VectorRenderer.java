public class VectorRenderer implements Renderer{
    @Override
    public String renderCircle(int id, double radius){
        return String.format("[Vector] Circle #%d with radius %.1f", id, radius);
    }

    @Override
    public String renderSquare(int id, double side){
        return String.format("[Vector] Square #%d with side %.1f", id, side);
    }
}
