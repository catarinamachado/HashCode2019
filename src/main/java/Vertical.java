import java.util.ArrayList;
import java.util.List;

public class Vertical {
    PhotoMap pM;
    SlideMap sM;

    public Vertical(PhotoMap pM, SlideMap sM) {
        this.pM = pM;
        this.sM = sM;
    }

    public int numberCommonTags(int id1, int id2) {
        int number = 0;

        Photo photo1 = pM.getPhoto(id1);
        Photo photo2 = pM.getPhoto(id2);

        List<String> common = new ArrayList<String>(photo1.getTags());
        common.retainAll(photo2.getTags());

        return common.size();
    }

    public void addSlide() {
        for(Photo p: pM.getPhotos().values()) {

            int idPhoto = p.getId();


            if (numberCommonTags(1, 2) == 0) {
               // Slide slide = new Slide();
                //sM.add(slide);
            }
        }
    }
}
