
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class PhotoRelationships {
    private Photo photo;
    private List<Pair<Photo,Integer>> photos;

    PhotoRelationships(Photo photo){
        this.photo = photo;
        this.photos = new ArrayList<>();
    }

    void addToList(Photo newPhoto) {
        int min, e, comuns = 0, d;

        for(String tag : photo.getTags()) {
            if(newPhoto.getTags().contains(tag))
                comuns++;
        }

        e = photo.getTags().size() - comuns;
        d = newPhoto.getTags().size() - comuns;

        min = e;
        if (comuns < min) min = comuns;
        if(d < min) min = d;

        Pair<Photo, Integer> a = new Pair<>(newPhoto, min);
        photos.add(a);
    }
}
