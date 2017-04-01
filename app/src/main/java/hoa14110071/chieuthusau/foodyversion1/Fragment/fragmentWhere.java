package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.JavaClass.DanhMucAdapter;
import hoa14110071.chieuthusau.foodyversion1.JavaClass.MoiNhatAdapter;
import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.R;

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


    public static int[] defaultImage = {R.drawable.home_ic_filter_latest, R.drawable.home_ic_filter_most_near, R.drawable.home_ic_filter_top_of_week,
            R.drawable.home_ic_filter_tourist, R.drawable.home_ic_filter_ecard, R.drawable.home_ic_filter_most_reservation,
            R.drawable.home_ic_filter_bankcard, R.drawable.home_ic_filter_bankcard
    };

    public static int[] changedImage = {R.drawable.home_ic_filter_latest_act, R.drawable.home_ic_filter_most_near_act, R.drawable.home_ic_filter_top_of_week_act,
            R.drawable.home_ic_filter_tourist_act, R.drawable.home_ic_filter_ecard_act, R.drawable.home_ic_filter_most_reservation_act,
            R.drawable.home_ic_filter_bankcard_act, R.drawable.home_ic_filter_bankcard_act};


    public static String[] arraymoiNhatString = {"Mới nhất", "Gần tôi", "Phổ biến", "Du khách", "Ưu đãi E-card", "Đặt chỗ", "Ưu đãi thẻ", "Đặt giao hàng"};

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


        lstDanhMucWhere = (ListView) view.findViewById(R.id.lstDanhMucWhere);
        danhMucAdapter = new DanhMucAdapter(getActivity(), R.layout.list_row_item, listViewItemArrayListDanhMuc);
        lstDanhMucWhere.setAdapter(danhMucAdapter);


        lstMoiNhatWhereSetup();
        return view;
    }


    private void lstMoiNhatWhereSetup() {

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

        tabHost.setCurrentTab(0);

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
//        TextView tv = (TextView) tabHost.getCurrentView();
//        tv.setText("aaaaaaaa");
//        viewPager.setCurrentItem(selectedItem);
    }


    public void SelectTabMain() {
        tabHost.setCurrentTab(3);
    }


}

