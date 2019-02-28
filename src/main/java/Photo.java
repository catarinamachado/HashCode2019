import java.util.List;

public class Photo {
    private int id;
    private List<String> tags;
    private static int nextId = 0;
    private boolean isHorizontal;

    public int getId() {
        return id;
    }

    public List<String> getTags() {
        return tags;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public Photo(List<String> tags, boolean isHorizontal) {
        this.id = nextId++;
        this.tags = tags;
        this.isHorizontal = isHorizontal;
        System.out.println("Created Photo: " + this.id);
    }
}
