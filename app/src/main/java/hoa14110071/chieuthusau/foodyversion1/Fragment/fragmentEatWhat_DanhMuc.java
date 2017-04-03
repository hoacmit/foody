package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.JavaClass.DanhMucAdapter;
import hoa14110071.chieuthusau.foodyversion1.Object.ListDatabase;
import hoa14110071.chieuthusau.foodyversion1.R;


public class fragmentEatWhat_DanhMuc extends Fragment {

    private ListView lstDanhMucEatWhat;
    private DanhMucAdapter danhMucAdapter;
    private ArrayList<ListDatabase> listViewListArrayListDatabase = new ArrayList<>();

    public fragmentEatWhat_DanhMuc() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (listViewListArrayListDatabase.size() == 0) {
//            ListDatabase listDanhMuc = new ListDatabase(R.drawable.fd15, "Danh mục", true);
//            ListDatabase listSangTrong = new ListDatabase(R.drawable.fd1, "Sang trọng", true);
//            ListDatabase listBuffet = new ListDatabase(R.drawable.fd2, "Buffet", true);
//            ListDatabase listNhaHang = new ListDatabase(R.drawable.fd3, "Nhà hàng", false);
//            ListDatabase listAnVat = new ListDatabase(R.drawable.fd4, "Ăn vặt/vỉa hè", false);
//            ListDatabase listAnChay = new ListDatabase(R.drawable.fd5, "Ăn chay", false);
//            ListDatabase listCafe = new ListDatabase(R.drawable.fd6, "Café/Dessert", false);
//            ListDatabase listQuanAn = new ListDatabase(R.drawable.fd7, "Quán ăn", false);
//            ListDatabase listBar = new ListDatabase(R.drawable.fd8, "Bar/Pub", false);
//            ListDatabase listQuanNhau = new ListDatabase(R.drawable.fd9, "Quán nhậu", false);
//            ListDatabase listBeerclub = new ListDatabase(R.drawable.fd10, "Beer club", false);
//            ListDatabase listTiemBanh = new ListDatabase(R.drawable.fd11, "TIệm bánh", false);
//            ListDatabase listTiectannoi = new ListDatabase(R.drawable.fd12, "Tiệc tận nơi", false);
//            ListDatabase listShopOnline = new ListDatabase(R.drawable.fd13, "Shop Online", false);
//            ListDatabase listGiaoComVanPhong = new ListDatabase(R.drawable.fd14, "Giao cơm văn phòng", false);
//            ListDatabase listKhuAmThuc = new ListDatabase(R.drawable.fd15, "Khu ẩm thức", false);
//            listViewListArrayListDatabase.add(listDanhMuc);
//            listViewListArrayListDatabase.add(listSangTrong);
//            listViewListArrayListDatabase.add(listBuffet);
//            listViewListArrayListDatabase.add(listNhaHang);
//            listViewListArrayListDatabase.add(listAnVat);
//            listViewListArrayListDatabase.add(listAnChay);
//            listViewListArrayListDatabase.add(listCafe);
//            listViewListArrayListDatabase.add(listQuanAn);
//            listViewListArrayListDatabase.add(listBar);
//            listViewListArrayListDatabase.add(listQuanNhau);
//            listViewListArrayListDatabase.add(listBeerclub);
//            listViewListArrayListDatabase.add(listTiemBanh);
//            listViewListArrayListDatabase.add(listTiectannoi);
//            listViewListArrayListDatabase.add(listShopOnline);
//            listViewListArrayListDatabase.add(listGiaoComVanPhong);
//            listViewListArrayListDatabase.add(listKhuAmThuc);
//        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eat_what__danh_muc, container, false);
//        lstDanhMucEatWhat = (ListView) view.findViewById(R.id.lstDanhMucEatWhat);
//        danhMucAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewListArrayListDatabase);
//        lstDanhMucEatWhat.setAdapter(danhMucAdapter);
        return view;
    }

}
