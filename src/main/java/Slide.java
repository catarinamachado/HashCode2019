import java.util.List;

class Slide {
    private int id;
    private List<String> tags;
    private String slidePhotos;
    private static int nextId = 0;
    private boolean isHorizontal;

    int getId() {
        return id;
    }

    List<String> getTags() {
        return tags;
    }

    boolean isHorizontal() {
        return isHorizontal;
    }

    Slide(List<String> tags, boolean isHorizontal) {
        this.id = nextId++;
        this.tags = tags;
        this.isHorizontal = isHorizontal;
        this.slidePhotos = Integer.toString(id);
    }

     String getSlidePhotos() {
        return slidePhotos;
    }

    public void setSlidePhotos(String slidePhotos) {
        this.slidePhotos = slidePhotos;
    }
}
