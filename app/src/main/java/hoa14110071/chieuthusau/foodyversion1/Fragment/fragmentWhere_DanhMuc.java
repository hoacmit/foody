package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.JavaClass.DanhMucAdapter;
import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.R;

public class fragmentWhere_DanhMuc extends Fragment {

    private ListView lstDanhMucWhere;
    private DanhMucAdapter danhMucAdapter;
    private ArrayList<Item> listViewItemArrayList =new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(listViewItemArrayList.size()==0)
        {
            Item itemDanhMuc = new Item(R.drawable.fd15, "Danh mục", true);
            Item itemSangTrong = new Item(R.drawable.fd1, "Sang trọng" ,true);
            Item itemBuffet = new Item(R.drawable.fd2, "Buffet" ,true);
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
        View view = inflater.inflate(R.layout.fragment_where_danh_muc, container, false);
        lstDanhMucWhere = (ListView) view.findViewById(R.id.lstDanhMucWhere);
        danhMucAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewItemArrayList);
        lstDanhMucWhere.setAdapter(danhMucAdapter);
        lstDanhMucWhere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tv =(TextView)view.findViewById(R.id.txtName);
                Toast.makeText(getActivity(), tv.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
