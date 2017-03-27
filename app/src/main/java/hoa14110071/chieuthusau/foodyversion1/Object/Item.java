package hoa14110071.chieuthusau.foodyversion1.Object;

/**
 * Created by minhh on 3/21/2017.
 */

public class Item {
    int imgAnh;
    String txtName;
    boolean check;

    public Item(int imgAnh, String txtName, boolean check) {
        this.imgAnh = imgAnh;
        this.txtName = txtName;
        this.check = check;
    }

    public int getImgAnh() {
        return imgAnh;
    }

    public void setImgAnh(int imgAnh) {
        this.imgAnh = imgAnh;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
