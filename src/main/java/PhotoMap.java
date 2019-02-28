import java.util.HashMap;
import java.util.Map;

public class PhotoMap {
    private Map<Integer, PhotoRelationships> photoRelationshipsMap;
    private Map<Integer, Photo> photos;

    public PhotoMap(){
        this.photoRelationshipsMap = new HashMap<Integer, PhotoRelationships>();
    }

    public void add(Photo photo){
        PhotoRelationships list = new PhotoRelationships();
        //todo algoritmo
        this.photoRelationshipsMap.put(photo.getId(),list);
    }

    public void createSlideshow(){
        //todo implement
    }
}
