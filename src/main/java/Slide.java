import java.util.List;

public class Slide {
    private String ids;
    private int id1;
    private int id2;
    private List<String> tags;
    private Photo photo1;
    private Photo photo2;
    private int nrPhotos;

    public int getId() {
        return id1;
    }

    public String getIds() {
        return ids;
    }

    public List<String> getTags() {
        return tags;
    }

    //quando é foto horizontal
    public Slide(Photo photo1) {
        this.id1 = photo1.getId();
        this.ids = String.valueOf(id1);
        this.tags = photo1.getTags();
        this.nrPhotos = 1;
    }

    //quando a fotos verticais
    public Slide(Photo photo1, Photo photo2) {
        this.id1 = photo1.getId();
        this.id2 = photo2.getId();
        this.ids = id1 + " " + id2;
        this.tags = photo1.getTags();
        this.tags.addAll(photo2.getTags());
        this.nrPhotos = 2;
    }
}
