package hoa14110071.chieuthusau.foodyversion1.Object;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by minhh on 3/21/2017.
 */

public class ListDatabase {
    int Id;
    String Name;
    byte[] Image;

    public ListDatabase(int id, String name, byte[] image) {
        Id = id;
        Name = name;
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Bitmap getImage() {
        Bitmap bitmap= BitmapFactory.decodeByteArray(Image,0,Image.length);
        return bitmap;
    }


}
