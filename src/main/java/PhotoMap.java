import java.io.PrintWriter;
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

    public Photo getPhoto(int id) {
        return photos.get(id);
    }

    public Map<Integer, Photo> getPhotos() {
        return this.photos;
    }

    public void add(Photo photo){
        photoRelationshipsMap.forEach((k,v) ->
            v.addToList(photo)
        );

        return min;
    }

    void createSlideshow(){
        try {
        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println(photos.size());

        List<Slide> a = new ArrayList<>();

        for(Slide v : photos.values()) {
            System.out.println(v.getSlidePhotos());
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

        a.forEach(x -> writer.println((x.getSlidePhotos())));
        writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paraString(){
        int i = 0;
        for(Slide p: this.photos.values()){
            System.out.println("Foto nr: " + p.getId());
            for(String s: p.getTags()){
                System.out.println("Tag " + i + ": " + s);
                i++;
            }
            System.out.println("É horizontal: " + p.isHorizontal());
            i = 0;
        }

    }
}
