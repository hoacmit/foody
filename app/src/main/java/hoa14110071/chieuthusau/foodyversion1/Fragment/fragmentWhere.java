package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.app.Activity;
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
import android.widget.ExpandableListAdapter;
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
import hoa14110071.chieuthusau.foodyversion1.Object.City;
import hoa14110071.chieuthusau.foodyversion1.Object.District;
import hoa14110071.chieuthusau.foodyversion1.Object.ListDatabase;
import hoa14110071.chieuthusau.foodyversion1.Object.Street;
import hoa14110071.chieuthusau.foodyversion1.R;

import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.categories;
import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.database;
import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.districts;
import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.listDatabases;
import static hoa14110071.chieuthusau.foodyversion1.JavaClass.DanhMucAdapter.newIndexChangedDanhMuc;
import static hoa14110071.chieuthusau.foodyversion1.JavaClass.MoiNhatAdapter.newIndexChangedMoiNhat;

public class fragmentWhere extends Fragment implements TabHost.OnTabChangeListener {
    //    private ViewPager viewPager;
    public static TabHost tabHost;

    private ListView lstMoiNhatWhere;
    //    private ArrayList<ListDatabase> listViewItemArrayListMoiNhat = new ArrayList<>();
    private MoiNhatAdapter moiNhatAdapter;

    private ArrayList<Category> listViewItemArrayListMoiNhat = new ArrayList<>();


    private ListView lstDanhMucWhere;
    private DanhMucAdapter danhMucAdapter;
    private ArrayList<ListDatabase> listViewListArrayListDatabaseDanhMuc = new ArrayList<>();


    private static ExpandableListView exLstWhere;
    private static CustomAdapterExpandableListview customAdapterExpandableListview;

    public static ArrayList<District> listDistrict;
    public static HashMap<District, List<Street>> mData;

    private Button btnChooseCity;

    public static TabWidget tabWidget;


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

        if (listViewListArrayListDatabaseDanhMuc.size() == 0) {
            for (int i = 0; i < listDatabases.size(); i++) {
                listViewListArrayListDatabaseDanhMuc.add(listDatabases.get(i));
            }
        }


        listDistrict = new ArrayList<>();
        mData = new HashMap<>();
        ArrayList<Street> streetsQ1 = new ArrayList<>();
        streetsQ1.add(new Street(0, "Bà Lê Chân"));
        streetsQ1.add(new Street(1,"Bến Chương Dương"));
        streetsQ1.add(new Street(2,"Bến Nghé"));
        streetsQ1.add(new Street(3,"Bùi Thị Xuân"));

        listDistrict= districts;

        for (int i = 0; i < districts.size(); i++) {

            mData.put(listDistrict.get(i),streetsQ1);
        }

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
                getActivity().startActivityForResult(intent,1);
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

        tvMoiNhat.setTextColor(getContext().getResources().getColor(R.color.colorPressed));
        tvDanhMuc.setTextColor(getContext().getResources().getColor(R.color.colorPressed));
        tvTPHCM.setTextColor(getContext().getResources().getColor(R.color.colorPressed));

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


    public static void setOnGroup(Context context, int groupPosition) {
        final TextView tvTPHCM = (TextView) tabHost.getTabWidget().getChildTabViewAt(2).findViewById(android.R.id.title);
        tvTPHCM.setText(listDistrict.get(groupPosition).getName());
        tvTPHCM.setTextColor(context.getResources().getColor(R.color.colorRed));
        tabHost.setCurrentTab(3);
    }

    public static void setOnChild(Context context, int groupPosition, int childPosition) {
        final TextView tvTPHCM = (TextView) tabWidget.getChildTabViewAt(2).findViewById(android.R.id.title);
        tvTPHCM.setText(String.valueOf(mData.get(listDistrict.get(groupPosition)).get(childPosition).getStreetName()));
        tvTPHCM.setTextColor(context.getResources().getColor(R.color.colorRed));
        tabHost.setCurrentTab(3);
    }

    public static void changeCity(Context context,String CityName)
    {
        listDistrict = districts;
        ArrayList<Street> streetsQ1 = new ArrayList<>();
        streetsQ1.add(new Street(0, "Bà Lê Chân"));
        streetsQ1.add(new Street(1,"Bến Chương Dương"));
        streetsQ1.add(new Street(2,"Bến Nghé"));
        streetsQ1.add(new Street(3,"Bùi Thị Xuân"));
        mData.clear();
        for (int i = 0; i < districts.size(); i++) {
            mData.put(listDistrict.get(i),streetsQ1);
        }
        customAdapterExpandableListview = new CustomAdapterExpandableListview(context,listDistrict,mData);
        exLstWhere.setAdapter(customAdapterExpandableListview);
        final TextView tvTPHCM = (TextView) tabWidget.getChildTabViewAt(2).findViewById(android.R.id.title);
        tvTPHCM.setText(CityName);
        tvTPHCM.setTextColor(context.getResources().getColor(R.color.colorPressed));
    }
}

