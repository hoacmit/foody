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

public class fragmentEatWhat_MoiNhat extends Fragment {
    private ListView lstMoiNhatEatWhat;
    private DanhMucAdapter moiNhatAdapter;
    private ArrayList<ListDatabase> listViewListArrayListDatabase = new ArrayList<>();

    public fragmentEatWhat_MoiNhat() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(listViewListArrayListDatabase.size()==0)
//        {
//            ListDatabase listMoiNhat = new ListDatabase(R.drawable.home_ic_filter_latest_act, "Mới nhất", true);
//            ListDatabase listGanToi = new ListDatabase(R.drawable.home_ic_filter_most_near, "Gần tôi", false);
//            ListDatabase listPhoBien = new ListDatabase(R.drawable.home_ic_filter_top_of_week, "Phổ biến", false);
//            ListDatabase listDuKhach = new ListDatabase(R.drawable.home_ic_filter_tourist, "Du khách", false);
//            ListDatabase listEcard = new ListDatabase(R.drawable.home_ic_filter_ecard, "Ưu đãi E-card", false);
//            ListDatabase listDatCho = new ListDatabase(R.drawable.home_ic_filter_most_reservation, "Đặt chỗ", false);
//            ListDatabase listUuDaiThe = new ListDatabase(R.drawable.home_ic_filter_bankcard, "Ưu đãi thẻ", false);
//            ListDatabase listDatGiaoHang = new ListDatabase(R.drawable.home_ic_filter_bankcard, "Đặt giao hàng", false);
//            listViewListArrayListDatabase.add(listMoiNhat);
//            listViewListArrayListDatabase.add(listGanToi);
//            listViewListArrayListDatabase.add(listPhoBien);
//            listViewListArrayListDatabase.add(listDuKhach);
//            listViewListArrayListDatabase.add(listEcard);
//            listViewListArrayListDatabase.add(listDatCho);
//            listViewListArrayListDatabase.add(listUuDaiThe);
//            listViewListArrayListDatabase.add(listDatGiaoHang);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eat_what__moi_nhat, container, false);

//        lstMoiNhatEatWhat = (ListView) view.findViewById(R.id.lstMoiNhatEatWhat);
//        moiNhatAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewListArrayListDatabase);
//        lstMoiNhatEatWhat.setAdapter(moiNhatAdapter);
//        lstMoiNhatEatWhat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView tv = (TextView)view.findViewById(R.id.txtName);
//                Toast.makeText(getActivity(), tv.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
