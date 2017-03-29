package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.JavaClass.MoiNhatAdapter;
import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.R;

public class fragmentWhere_MoiNhat extends Fragment {
    private ListView lstMoiNhatWhere;
    private MoiNhatAdapter moiNhatAdapter;
    private ArrayList<Item> listViewItemArrayList = new ArrayList<>();

    public static int[] defaultImage = {R.drawable.home_ic_filter_latest,R.drawable.home_ic_filter_most_near,R.drawable.home_ic_filter_top_of_week,
            R.drawable.home_ic_filter_tourist,R.drawable.home_ic_filter_ecard,R.drawable.home_ic_filter_most_reservation,
            R.drawable.home_ic_filter_bankcard, R.drawable.home_ic_filter_bankcard
    };

    public static int[] changedImage = {R.drawable.home_ic_filter_latest_act,R.drawable.home_ic_filter_most_near_act,R.drawable.home_ic_filter_top_of_week_act,
            R.drawable.home_ic_filter_tourist_act,R.drawable.home_ic_filter_ecard_act,R.drawable.home_ic_filter_most_reservation_act,
            R.drawable.home_ic_filter_bankcard_act, R.drawable.home_ic_filter_bankcard_act
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
        View view = inflater.inflate(R.layout.fragment_where_moi_nhat, container, false);

        lstMoiNhatWhere = (ListView) view.findViewById(R.id.lstMoiNhatWhere);
        moiNhatAdapter = new MoiNhatAdapter(getActivity(), R.layout.list_row_item, listViewItemArrayList);
        lstMoiNhatWhere.setAdapter(moiNhatAdapter);


        return view;
    }





//    public View getView(int position, View convertView, ViewGroup parent) {
//        final ViewHolder viewHolder;
//
//        View view = convertView;
//        if(view==null){
//            view = getInfalter().inflate(R.layout.list_item, null);
//            viewHolder = new ViewHolder();
//
//
//            viewHolder.text = (TextView) view.findViewById(R.id.list_item_tv_title_post);
//            viewHolder.timestamp = (TextView) view.findViewById(R.id.list_item_tv_timestamp);
//            viewHolder.avatar = (ImageView)view.findViewById(R.id.list_item_iv_avatar);
//            viewHolder.progress = (ProgressBar)view.findViewById(R.id.list_item_pgr_loading);
//            view.setTag(viewHolder);
//        }
//        else{
//            viewHolder = (ViewHolder) view.getTag();
//        }
//
//        // set data
//        viewHolder.text = //.. some data;
//
//        return view;
//    }
//
//    class ViewHolder{
//        ListView lst;
//    }


}
