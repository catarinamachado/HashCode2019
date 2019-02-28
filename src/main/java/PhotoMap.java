import java.util.*;

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

    void createSlideshow(){
        System.out.println(photos.size());
        List<Slide> a = new ArrayList<>();

        for(Slide v : photos.values()) {
            boolean done = false;
            if(a.isEmpty()) a.add(v);
            else {
                for (int i = 0; i < a.size(); i++) {
                    Slide x = a.get(i);
                    if (min(x, v) > 0) {
                        a.add(i, v);
                        done = true;
                        break;
                    }
                }
                if(!done)
                    a.add(v);
            }
        }

        a.forEach(x -> System.out.println(x.getSlidePhotos()));
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
