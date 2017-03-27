package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.JavaClass.DanhMucAdapter;
import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.R;


public class fragmentEatWhat_DanhMuc extends Fragment {

    private ListView lstDanhMucEatWhat;
    private DanhMucAdapter danhMucAdapter;
    private ArrayList<Item> listViewItemArrayList = new ArrayList<>();

    public fragmentEatWhat_DanhMuc() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (listViewItemArrayList.size() == 0) {
            Item itemDanhMuc = new Item(R.drawable.fd15, "Danh mục", true);
            Item itemSangTrong = new Item(R.drawable.fd1, "Sang trọng", true);
            Item itemBuffet = new Item(R.drawable.fd2, "Buffet", true);
            Item itemNhaHang = new Item(R.drawable.fd3, "Nhà hàng", false);
            Item itemAnVat = new Item(R.drawable.fd4, "Ăn vặt/vỉa hè", false);
            Item itemAnChay = new Item(R.drawable.fd5, "Ăn chay", false);
            Item itemCafe = new Item(R.drawable.fd6, "Café/Dessert", false);
            Item itemQuanAn = new Item(R.drawable.fd7, "Quán ăn", false);
            Item itemBar = new Item(R.drawable.fd8, "Bar/Pub", false);
            Item itemQuanNhau = new Item(R.drawable.fd9, "Quán nhậu", false);
            Item itemBeerclub = new Item(R.drawable.fd10, "Beer club", false);
            Item itemTiemBanh = new Item(R.drawable.fd11, "TIệm bánh", false);
            Item itemTiectannoi = new Item(R.drawable.fd12, "Tiệc tận nơi", false);
            Item itemShopOnline = new Item(R.drawable.fd13, "Shop Online", false);
            Item itemGiaoComVanPhong = new Item(R.drawable.fd14, "Giao cơm văn phòng", false);
            Item itemKhuAmThuc = new Item(R.drawable.fd15, "Khu ẩm thức", false);
            listViewItemArrayList.add(itemDanhMuc);
            listViewItemArrayList.add(itemSangTrong);
            listViewItemArrayList.add(itemBuffet);
            listViewItemArrayList.add(itemNhaHang);
            listViewItemArrayList.add(itemAnVat);
            listViewItemArrayList.add(itemAnChay);
            listViewItemArrayList.add(itemCafe);
            listViewItemArrayList.add(itemQuanAn);
            listViewItemArrayList.add(itemBar);
            listViewItemArrayList.add(itemQuanNhau);
            listViewItemArrayList.add(itemBeerclub);
            listViewItemArrayList.add(itemTiemBanh);
            listViewItemArrayList.add(itemTiectannoi);
            listViewItemArrayList.add(itemShopOnline);
            listViewItemArrayList.add(itemGiaoComVanPhong);
            listViewItemArrayList.add(itemKhuAmThuc);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eat_what__danh_muc, container, false);
        lstDanhMucEatWhat = (ListView) view.findViewById(R.id.lstDanhMucEatWhat);
        danhMucAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewItemArrayList);
        lstDanhMucEatWhat.setAdapter(danhMucAdapter);
        return view;
    }

}
