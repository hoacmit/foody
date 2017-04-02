package hoa14110071.chieuthusau.foodyversion1.Fragment;

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
import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.Object.Street;
import hoa14110071.chieuthusau.foodyversion1.R;

import static hoa14110071.chieuthusau.foodyversion1.JavaClass.MoiNhatAdapter.lastIndexChanged;

public class fragmentWhere extends Fragment implements TabHost.OnTabChangeListener {
    //    private ViewPager viewPager;
    private TabHost tabHost;
    public static String titleChange = "";

    private ListView lstMoiNhatWhere;
    private ArrayList<Item> listViewItemArrayListMoiNhat = new ArrayList<>();
    private MoiNhatAdapter moiNhatAdapter;



    private ListView lstDanhMucWhere;
    private DanhMucAdapter danhMucAdapter;
    private ArrayList<Item> listViewItemArrayListDanhMuc =new ArrayList<>();


    private ExpandableListView exLstWhere;
    private CustomAdapterExpandableListview customAdapterExpandableListview;
    private List<String> listDistrict;
    private HashMap<String,List<Street>> mData;

    private Button btnChooseCity;


    public static int[] defaultImage = {R.drawable.home_ic_filter_latest, R.drawable.home_ic_filter_most_near, R.drawable.home_ic_filter_top_of_week,
            R.drawable.home_ic_filter_tourist, R.drawable.home_ic_filter_ecard, R.drawable.home_ic_filter_most_reservation,
            R.drawable.home_ic_filter_bankcard, R.drawable.home_ic_filter_bankcard
    };

    public static int[] changedImage = {R.drawable.home_ic_filter_latest_act, R.drawable.home_ic_filter_most_near_act, R.drawable.home_ic_filter_top_of_week_act,
            R.drawable.home_ic_filter_tourist_act, R.drawable.home_ic_filter_ecard_act, R.drawable.home_ic_filter_most_reservation_act,
            R.drawable.home_ic_filter_bankcard_act, R.drawable.home_ic_filter_bankcard_act};


    public static String[] arraymoiNhatString = {"Mới nhất", "Gần tôi", "Phổ biến", "Du khách", "Ưu đãi E-card", "Đặt chỗ", "Ưu đãi thẻ", "Đặt giao hàng"};



    private TabWidget tabWidget;


    public fragmentWhere() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (listViewItemArrayListMoiNhat.size() == 0) {
            Item itemMoiNhat = new Item(changedImage[0], arraymoiNhatString[0], true);
            listViewItemArrayListMoiNhat.add(itemMoiNhat);

            for (int i = 1; i < arraymoiNhatString.length; i++) {
                Item item = new Item(defaultImage[i], arraymoiNhatString[i], false);
                listViewItemArrayListMoiNhat.add(item);
            }
        }



        if (listViewItemArrayListDanhMuc.size() == 0) {
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
            listViewItemArrayListDanhMuc.add(itemDanhMuc);
            listViewItemArrayListDanhMuc.add(itemSangTrong);
            listViewItemArrayListDanhMuc.add(itemBuffet);
            listViewItemArrayListDanhMuc.add(itemNhaHang);
            listViewItemArrayListDanhMuc.add(itemAnVat);
            listViewItemArrayListDanhMuc.add(itemAnChay);
            listViewItemArrayListDanhMuc.add(itemCafe);
            listViewItemArrayListDanhMuc.add(itemQuanAn);
            listViewItemArrayListDanhMuc.add(itemBar);
            listViewItemArrayListDanhMuc.add(itemQuanNhau);
            listViewItemArrayListDanhMuc.add(itemBeerclub);
            listViewItemArrayListDanhMuc.add(itemTiemBanh);
            listViewItemArrayListDanhMuc.add(itemTiectannoi);
            listViewItemArrayListDanhMuc.add(itemShopOnline);
            listViewItemArrayListDanhMuc.add(itemGiaoComVanPhong);
            listViewItemArrayListDanhMuc.add(itemKhuAmThuc);
        }


        listDistrict = new ArrayList<>();
        listDistrict.add("Quận 1");
        listDistrict.add("Quận 2");

        List<Street> streetsQ1 = new ArrayList<>();
        streetsQ1.add(new Street("Bà Lê Chân"));
        streetsQ1.add(new Street("Bến Chương Dương"));
        streetsQ1.add(new Street("Bến Nghé"));
        streetsQ1.add(new Street("Bùi Thị Xuân"));



        List<Street> streetsQ2 = new ArrayList<>();
        streetsQ2.add(new Street("Bà Lê"));
        streetsQ2.add(new Street("Bến "));
        streetsQ2.add(new Street("Bến Nghé"));
        streetsQ2.add(new Street("Bùi Thị Xuân"));

        mData = new HashMap<>();
        mData.put(listDistrict.get(0),streetsQ1);
        mData.put(listDistrict.get(1),streetsQ2);

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
                listViewItemArrayListMoiNhat.get(lastIndexChanged).setCheck(false);
                listViewItemArrayListMoiNhat.get(lastIndexChanged).setImgAnh(defaultImage[lastIndexChanged]);

                listViewItemArrayListMoiNhat.get(position).setCheck(true);
                listViewItemArrayListMoiNhat.get(position).setImgAnh(changedImage[position]);

                lastIndexChanged=position;
                moiNhatAdapter.notifyDataSetChanged();

                tabHost.setCurrentTab(3);
            }
        });


        lstDanhMucWhere = (ListView) view.findViewById(R.id.lstDanhMucWhere);
        danhMucAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewItemArrayListDanhMuc);
        lstDanhMucWhere.setAdapter(danhMucAdapter);


        exLstWhere = (ExpandableListView) view.findViewById(R.id.exLstWhere);
        customAdapterExpandableListview = new CustomAdapterExpandableListview(getContext(),listDistrict,mData);
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




    // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_where, container, false);
//        tabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
//        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        tabHost = new FragmentTabHost(getActivity());
//        tabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
//        tabHost.addTab(tabHost.newTabSpec("Mới nhất").setIndicator("Mới nhất"), fragmentWhere_MoiNhat.class, null);
//        tabHost.addTab(tabHost.newTabSpec("Danh mục").setIndicator("Danh mục"), fragmentWhere_DanhMuc.class, null);
//        tabHost.addTab(tabHost.newTabSpec("TPHCM").setIndicator("TPHCM"), fragmentWhere_TPHCM.class, null);
//        tabHost.addTab(tabHost.newTabSpec("MAIN").setIndicator("MAIN"), fragmentWhere_main.class, null);
//        SelectTabMain();
//        tabHost.setOnTabChangedListener(this);
//
//
//        LinearLayout tabOne = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(0);
//        final TextView tabOneTitle = (TextView) tabOne.findViewById(android.R.id.title);
//        LinearLayout tabTwo = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(1);
//        final TextView tabTwoTitle = (TextView) tabTwo.findViewById(android.R.id.title);
//        LinearLayout tabThree = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(2);
//        final TextView tabThreeTitle = (TextView) tabThree.findViewById(android.R.id.title);


//        setupViewPager(viewPager);
    //setupTabHost(tabHost);
//        tabOne.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                tabOneTitle.setText(titleChange);
//                return true;
//            }
//        });
//
//        tabTwo.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                tabTwoTitle.setText("New Tab 2");
//                return true;
//            }
//        });
//
//        tabThree.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                tabThreeTitle.setText("New Tab 3");
//                return true;
//                    }
//                });
//        tabOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tabOneTitle.setText(titleChange);
//            }
//        });
//        return tabHost;
//        return view;
//    }

    // fake content for tabhost
//    class FakeContent implements TabHost.TabContentFactory {
//        private final Context mcontext;
//
//        public FakeContent(Context context) {
//            mcontext = context;
//        }
//
//        @Override
//        public View createTabContent(String tag) {
//            View v = new View(mcontext);
//            v.setMinimumHeight(0);
//            v.setMinimumWidth(0);
//            return v;
//        }
//    }

//    private void setupTabHost(TabHost tabHost) {
//        tabHost.setup();
//        String tabNames[] = {"Mới nhất", "Danh mục", "TPHCM"};
//
//        for (int i = 0; i < tabNames.length; i++) {
//            TabHost.TabSpec tabSpec;
//            tabSpec = tabHost.newTabSpec(tabNames[i]);
//            tabSpec.setIndicator(tabNames[i]);
//            tabSpec.setContent(new FakeContent(getContext()));
//            tabHost.addTab(tabSpec);
//        }
//        tabHost.setOnTabChangedListener(this);

//    }

//    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
//        adapter.addFragment(new fragmentWhere_MoiNhat());
//        adapter.addFragment(new fragmentWhere_DanhMuc());
//        adapter.addFragment(new fragmentWhere_TPHCM());
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(this);
//    }

//    //Viewpagerlistener
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        tabHost.setCurrentTab(position);
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }

    //TabHostlistener
    @Override
    public void onTabChanged(String tabId) {
        for (int i=0 ; i< tabWidget.getChildCount();i++)
        {
            tabWidget.getChildAt(i).setBackgroundResource(R.drawable.background_tabhost_unselected);
        }
        tabWidget.getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.background_tabhost_selected);
    }


}

