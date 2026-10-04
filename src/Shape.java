public abstract class Shape {
    private final int id;
    protected Renderer renderer;

    public Shape(int id, Renderer renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Renderer cannot be null");
        }
        this.id = id;
        this.renderer = renderer;
    }

    public int getId() {
        return id;
    }

    public void setImplementation(Renderer renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Renderer cannot be null");
        }
        this.renderer = renderer;
    }

    public abstract String execute();
}