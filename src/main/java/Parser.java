import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


public class Parser{
    public static void main(String[] args) {
        String filename = "b_lovely_landscapes.txt";

        int i=0;
        int nPhotos=-1;
        ArrayList<String> list = new ArrayList<>();
        boolean position;
        int nTags = -1;
        ArrayList<String> tags = new ArrayList<>();

        Photo p;
        Slide slide;
        PhotoMap pM= new PhotoMap();
        SlideMap sM= new SlideMap();


        try (Stream<String> stream = Files.lines(Paths.get(filename))) {

            stream.forEach(s -> list.add(s));

        } catch (IOException e) {
            e.printStackTrace();
          }
            
            for(String s: list){

                if(i==0){
                    nPhotos = Integer.valueOf(s);
                    i++;
                }
                else{
                    
                    String[] splited = s.split("\\s+");
                    
                    position = splited[0].equals("H");
                    nTags = Integer.valueOf(splited[1]);
                    for(int j=2; j<nTags+2; j++){
                        tags.add(splited[j]);
                    }

                    p = new Photo(tags, position);

                    Photo array[] = new Photo[2];
                    int nr = 0;

                    if(position) {
                        slide = new Slide(p);
                        sM.add(slide);
                    } else if(nr == 0) {
                        array[nr] = p;
                        nr = 1;
                    } else {
                        slide = new Slide(array[0], array[1]);
                        array[nr] = p;
                        nr = 0;
                        sM.add(slide);
                    }

                    tags = new ArrayList<>();
                }
            }
            
            pM.paraString();
        }


}

