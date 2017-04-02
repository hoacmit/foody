package hoa14110071.chieuthusau.foodyversion1.Object;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by minhh on 4/2/2017.
 */

public class Category {
    int Id;
    String Name;
    byte[] Image;
    byte[] ImagePress;


    public Category(int id, String name, byte[] image, byte[] imagePress) {
        Id = id;
        Name = name;
        Image = image;
        ImagePress = imagePress;
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

    public Bitmap getImagePress() {
        Bitmap bitmap= BitmapFactory.decodeByteArray(ImagePress,0,ImagePress.length);
        return bitmap;
    }

}
