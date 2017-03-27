package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.content.Context;
import android.net.Uri;
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

public class fragmentEatWhat_MoiNhat extends Fragment {
    private ListView lstMoiNhatEatWhat;
    private DanhMucAdapter moiNhatAdapter;
    private ArrayList<Item> listViewItemArrayList = new ArrayList<>();

    public fragmentEatWhat_MoiNhat() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(listViewItemArrayList.size()==0)
        {
            Item itemMoiNhat = new Item(R.drawable.home_ic_filter_latest_act, "Mới nhất", true);
            Item itemGanToi = new Item(R.drawable.home_ic_filter_most_near, "Gần tôi", false);
            Item itemPhoBien = new Item(R.drawable.home_ic_filter_top_of_week, "Phổ biến", false);
            Item itemDuKhach = new Item(R.drawable.home_ic_filter_tourist, "Du khách", false);
            Item itemEcard = new Item(R.drawable.home_ic_filter_ecard, "Ưu đãi E-card", false);
            Item itemDatCho = new Item(R.drawable.home_ic_filter_most_reservation, "Đặt chỗ", false);
            Item itemUuDaiThe = new Item(R.drawable.home_ic_filter_bankcard, "Ưu đãi thẻ", false);
            Item itemDatGiaoHang = new Item(R.drawable.home_ic_filter_bankcard, "Đặt giao hàng", false);
            listViewItemArrayList.add(itemMoiNhat);
            listViewItemArrayList.add(itemGanToi);
            listViewItemArrayList.add(itemPhoBien);
            listViewItemArrayList.add(itemDuKhach);
            listViewItemArrayList.add(itemEcard);
            listViewItemArrayList.add(itemDatCho);
            listViewItemArrayList.add(itemUuDaiThe);
            listViewItemArrayList.add(itemDatGiaoHang);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eat_what__moi_nhat, container, false);

        lstMoiNhatEatWhat = (ListView) view.findViewById(R.id.lstMoiNhatEatWhat);
        moiNhatAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewItemArrayList);
        lstMoiNhatEatWhat.setAdapter(moiNhatAdapter);
        return view;
    }
}
