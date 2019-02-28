import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PhotoMap {
    private Map<Integer, Slide> photos;

    PhotoMap(){
        this.photos = new HashMap<>();
    }

    void add(Slide slide){
        this.photos.put(slide.getId(), slide);
    }

    private int min(Slide first, Slide newPhoto) {
        int min, e, comuns = 0, d;

        for(String tag : first.getTags()) {
            if(newPhoto.getTags().contains(tag))
                comuns++;
        }

        e = first.getTags().size() - comuns;
        d = newPhoto.getTags().size() - comuns;

        min = e;
        if (comuns < min) min = comuns;
        if(d < min) min = d;

        return min;
    }

    private boolean noInicio(Slide first, Slide last, Slide newPhoto) {
        return min(first, newPhoto) > min(last, newPhoto);
    }

    public void createSlideshow(){
        System.out.println(photos.size());
        LinkedList<String> a = new LinkedList<>();
        Slide first = null;
        Slide last = null;

        for(Slide v : photos.values()) {
            if(first == null) {
                first = last = v;
                a.add(v.getSlidePhotos());
            } else {
                if(noInicio(first, last, v)) {
                    first = v;
                    a.addFirst(v.getSlidePhotos());
                } else {
                    last = v;
                    a.addLast(v.getSlidePhotos());
                }
            }
        }

        a.forEach(System.out::println);
    }

    void paraString(){
        int i = 0;
        for(Slide p: this.photos.values()){
            System.out.println("Foto nr: " + p.getId());
            for(String s: p.getTags()){
                System.out.println("Tag " + i + ": " + s);
                i++;
            }
            System.out.println("É horizontal: " + p.isHorizontal());
        }

    }
}
