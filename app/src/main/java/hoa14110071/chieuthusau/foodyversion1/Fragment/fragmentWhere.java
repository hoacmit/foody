package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hoa14110071.chieuthusau.foodyversion1.Activity.ChooseCityActivity;
import hoa14110071.chieuthusau.foodyversion1.JavaClass.CustomAdapterExpandableListview;
import hoa14110071.chieuthusau.foodyversion1.JavaClass.DanhMucAdapter;
import hoa14110071.chieuthusau.foodyversion1.JavaClass.MoiNhatAdapter;
import hoa14110071.chieuthusau.foodyversion1.Object.Category;
import hoa14110071.chieuthusau.foodyversion1.Object.ListDatabase;
import hoa14110071.chieuthusau.foodyversion1.Object.Street;
import hoa14110071.chieuthusau.foodyversion1.R;

import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.categories;
import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.listDatabases;
import static hoa14110071.chieuthusau.foodyversion1.JavaClass.DanhMucAdapter.newIndexChangedDanhMuc;
import static hoa14110071.chieuthusau.foodyversion1.JavaClass.MoiNhatAdapter.newIndexChangedMoiNhat;

public class fragmentWhere extends Fragment implements TabHost.OnTabChangeListener{
    //    private ViewPager viewPager;
    public static TabHost tabHost;

    private ListView lstMoiNhatWhere;
//    private ArrayList<ListDatabase> listViewItemArrayListMoiNhat = new ArrayList<>();
    private MoiNhatAdapter moiNhatAdapter;

    private ArrayList<Category> listViewItemArrayListMoiNhat = new ArrayList<>();


    private ListView lstDanhMucWhere;
    private DanhMucAdapter danhMucAdapter;
    private ArrayList<ListDatabase> listViewListArrayListDatabaseDanhMuc = new ArrayList<>();


    private ExpandableListView exLstWhere;
    private CustomAdapterExpandableListview customAdapterExpandableListview;
    public static ArrayList<String> listDistrict;
    public static HashMap<String,List<Street>> mData;

    private Button btnChooseCity;


//    public static int[] defaultImage = {R.drawable.home_ic_filter_latest, R.drawable.home_ic_filter_most_near, R.drawable.home_ic_filter_top_of_week,
//            R.drawable.home_ic_filter_tourist, R.drawable.home_ic_filter_ecard, R.drawable.home_ic_filter_most_reservation,
//            R.drawable.home_ic_filter_bankcard, R.drawable.home_ic_filter_delivery
//    };
//
//    public static int[] changedImage = {R.drawable.home_ic_filter_latest_act, R.drawable.home_ic_filter_most_near_act, R.drawable.home_ic_filter_top_of_week_act,
//            R.drawable.home_ic_filter_tourist_act, R.drawable.home_ic_filter_ecard_act, R.drawable.home_ic_filter_most_reservation_act,
//            R.drawable.home_ic_filter_bankcard_act, R.drawable.home_ic_filter_delivery_act};
//
//
//    public static String[] arraymoiNhatString = {"Mới nhất", "Gần tôi", "Phổ biến", "Du khách", "Ưu đãi E-card", "Đặt chỗ", "Ưu đãi thẻ", "Đặt giao hàng"};


    public static TabWidget tabWidget;

    public static int indexSelected=0;


    public fragmentWhere() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (listViewItemArrayListMoiNhat.size() == 0) {
            for (int i = 0; i < categories.size(); i++) {
                listViewItemArrayListMoiNhat.add(categories.get(i));
            }
        }

        if (listViewListArrayListDatabaseDanhMuc.size() == 0)
        {
            for (int i = 0; i < listDatabases.size(); i++) {
                listViewListArrayListDatabaseDanhMuc.add(listDatabases.get(i));
            }
        }




//        if (listViewListArrayListDatabaseDanhMuc.size() == 0) {
//            ListDatabase listDanhMuc = new ListDatabase(R.drawable.fd15, "Danh mục", true);
//            ListDatabase listSangTrong = new ListDatabase(R.drawable.fd1, "Sang trọng", false);
//            ListDatabase listBuffet = new ListDatabase(R.drawable.fd2, "Buffet", false);
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
//            listViewListArrayListDatabaseDanhMuc.add(listDanhMuc);
//            listViewListArrayListDatabaseDanhMuc.add(listSangTrong);
//            listViewListArrayListDatabaseDanhMuc.add(listBuffet);
//            listViewListArrayListDatabaseDanhMuc.add(listNhaHang);
//            listViewListArrayListDatabaseDanhMuc.add(listAnVat);
//            listViewListArrayListDatabaseDanhMuc.add(listAnChay);
//            listViewListArrayListDatabaseDanhMuc.add(listCafe);
//            listViewListArrayListDatabaseDanhMuc.add(listQuanAn);
//            listViewListArrayListDatabaseDanhMuc.add(listBar);
//            listViewListArrayListDatabaseDanhMuc.add(listQuanNhau);
//            listViewListArrayListDatabaseDanhMuc.add(listBeerclub);
//            listViewListArrayListDatabaseDanhMuc.add(listTiemBanh);
//            listViewListArrayListDatabaseDanhMuc.add(listTiectannoi);
//            listViewListArrayListDatabaseDanhMuc.add(listShopOnline);
//            listViewListArrayListDatabaseDanhMuc.add(listGiaoComVanPhong);
//            listViewListArrayListDatabaseDanhMuc.add(listKhuAmThuc);
//        }


        listDistrict = new ArrayList<>();
        listDistrict.add("Quận 1");
        listDistrict.add("Quận 2");

        ArrayList<Street> streetsQ1 = new ArrayList<>();
        streetsQ1.add(new Street("Bà Lê Chân"));
        streetsQ1.add(new Street("Bến Chương Dương"));
        streetsQ1.add(new Street("Bến Nghé"));
        streetsQ1.add(new Street("Bùi Thị Xuân"));


        ArrayList<Street> streetsQ2 = new ArrayList<>();
        streetsQ2.add(new Street("Bà Lê"));
        streetsQ2.add(new Street("Bến "));
        streetsQ2.add(new Street("Bến Nghé"));
        streetsQ2.add(new Street("Bùi Thị Xuân"));

        mData = new HashMap<>();
        mData.put(listDistrict.get(0), streetsQ1);
        mData.put(listDistrict.get(1), streetsQ2);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_where, container, false);

        tabHost = (TabHost) view.findViewById(R.id.tabhost);
        tabHostSetup();


        lstMoiNhatWhere = (ListView) view.findViewById(R.id.lstMoiNhatWhere);
        moiNhatAdapter = new MoiNhatAdapter(getActivity(), R.layout.list_row_item, listViewItemArrayListMoiNhat);
        lstMoiNhatWhere.setAdapter(moiNhatAdapter);


        lstMoiNhatWhere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                newIndexChangedMoiNhat = position;

                moiNhatAdapter.notifyDataSetChanged();

                final TextView tvMoiNhat = (TextView) tabWidget.getChildTabViewAt(0).findViewById(android.R.id.title);
                tvMoiNhat.setText(listViewItemArrayListMoiNhat.get(position).getName());
                tvMoiNhat.setTextColor(getContext().getResources().getColor(R.color.colorRed));

                tabHost.setCurrentTab(3);
            }
        });


        lstDanhMucWhere = (ListView) view.findViewById(R.id.lstDanhMucWhere);
        danhMucAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewListArrayListDatabaseDanhMuc);
        lstDanhMucWhere.setAdapter(danhMucAdapter);

        lstDanhMucWhere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                newIndexChangedDanhMuc = position;

                danhMucAdapter.notifyDataSetChanged();

                final TextView tvDanhMuc = (TextView) tabWidget.getChildTabViewAt(1).findViewById(android.R.id.title);
                tvDanhMuc.setText(listViewListArrayListDatabaseDanhMuc.get(position).getName());
                tvDanhMuc.setTextColor(getContext().getResources().getColor(R.color.colorRed));

                tabHost.setCurrentTab(3);
            }
        });


        exLstWhere = (ExpandableListView) view.findViewById(R.id.exLstWhere);
        customAdapterExpandableListview = new CustomAdapterExpandableListview(getContext(), listDistrict, mData);
        exLstWhere.setAdapter(customAdapterExpandableListview);

        btnChooseCity = (Button) view.findViewById(R.id.btnChooseCity);
        btnChooseCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChooseCityActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    private void tabHostSetup() {
        tabHost.setup();

        TabHost.TabSpec tabMoiNhat = tabHost.newTabSpec("Moi nhat");
        tabMoiNhat.setContent(R.id.tabMoiNhat);
        tabMoiNhat.setIndicator("Mới nhất");
        tabHost.addTab(tabMoiNhat);

        TabHost.TabSpec tabDanhMuc = tabHost.newTabSpec("Danh muc");
        tabDanhMuc.setIndicator("Danh mục");
        tabDanhMuc.setContent(R.id.tabDanhMuc);
        tabHost.addTab(tabDanhMuc);

        TabHost.TabSpec tabTPHCM = tabHost.newTabSpec("TPHCM");
        tabTPHCM.setIndicator("TPHCM");
        tabTPHCM.setContent(R.id.tabTPHCM);
        tabHost.addTab(tabTPHCM);

        TabHost.TabSpec tabMain = tabHost.newTabSpec("Main");
        tabMain.setIndicator("MAIN");
        tabMain.setContent(R.id.tabMain);
        tabHost.addTab(tabMain);

//        TabWidget tabWidget = tabHost.getTabWidget();
        tabWidget = tabHost.getTabWidget();

        final TextView tvMoiNhat = (TextView) tabWidget.getChildTabViewAt(0).findViewById(android.R.id.title);
        final TextView tvDanhMuc = (TextView) tabWidget.getChildTabViewAt(1).findViewById(android.R.id.title);
        final TextView tvTPHCM = (TextView) tabWidget.getChildTabViewAt(2).findViewById(android.R.id.title);

        tvMoiNhat.setAllCaps(false);
        tvDanhMuc.setAllCaps(false);
        tvTPHCM.setAllCaps(false);

        tabWidget.getChildAt(3).setVisibility(View.GONE);

        tabWidget.getChildAt(0).setBackgroundResource(R.drawable.background_tabhost_unselected);
        tabWidget.getChildAt(1).setBackgroundResource(R.drawable.background_tabhost_unselected);
        tabWidget.getChildAt(2).setBackgroundResource(R.drawable.background_tabhost_unselected);

        tabHost.setCurrentTab(3);

        tabHost.setOnTabChangedListener(this);

    }

    //TabHostlistener
    @Override
    public void onTabChanged(String tabId) {
        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            tabWidget.getChildAt(i).setBackgroundResource(R.drawable.background_tabhost_unselected);
        }
        tabWidget.getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.background_tabhost_selected);
    }


    public static void setOnGroup(Context context, int groupPosition)
    {
        final TextView tvTPHCM = (TextView) tabHost.getTabWidget().getChildTabViewAt(2).findViewById(android.R.id.title);
        tvTPHCM.setText(listDistrict.get(groupPosition));
        tvTPHCM.setTextColor(context.getResources().getColor(R.color.colorRed));
        tabHost.setCurrentTab(3);
    }

    public static void setOnChild(Context context,int groupPosition,int childPosition)
    {
        final TextView tvTPHCM = (TextView) tabWidget.getChildTabViewAt(2).findViewById(android.R.id.title);
        tvTPHCM.setText(String.valueOf(mData.get(listDistrict.get(groupPosition)).get(childPosition).getStreetName()));
        tvTPHCM.setTextColor(context.getResources().getColor(R.color.colorRed));
        tabHost.setCurrentTab(3);
    }
}

