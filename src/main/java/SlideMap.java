import java.util.HashMap;
import java.util.Map;

public class SlideMap {
    private Map<Integer, Slide> slides;

    public SlideMap(){
        this.slides = new HashMap<>();
    }

    public void add(Slide slide){
        this.slides.put(slide.getId(), slide);
    }



    public void paraString(){
        int i = 0;
        for(Slide p: this.slides.values()){
            System.out.println("Foto nr: " + p.getId());
            for(String s: p.getTags()){
                System.out.println("Tag " + i + ": " + s);
                i++;
            }
            i = 0;
        }

    }

}
