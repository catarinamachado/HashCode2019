import java.util.HashMap;
import java.util.Map;

public class PhotoMap {
    private Map<Integer, PhotoRelationships> photoRelationshipsMap;
    private Map<Integer, Photo> photos;

    public PhotoMap(){
        this.photoRelationshipsMap = new HashMap<>();
    }

    public void add(Photo photo){
        photoRelationshipsMap.forEach((k,v) -> {
            Photo photo1 = photos.get(k);
            v.add(photo);
        });

        PhotoRelationships list = new PhotoRelationships(photo);
        this.photos.put(photo.getId(), photo);
        this.photoRelationshipsMap.put(photo.getId(),list);
    }

    public void createSlideshow(){
        //todo implement
    }
}
