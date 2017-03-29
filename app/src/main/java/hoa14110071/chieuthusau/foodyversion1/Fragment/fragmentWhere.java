package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import hoa14110071.chieuthusau.foodyversion1.R;

public class fragmentWhere extends Fragment implements TabHost.OnTabChangeListener{
    //    private ViewPager viewPager;
    private FragmentTabHost tabHost;
    public static String titleChange="";

    public fragmentWhere() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_where, container, false);
//        tabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
//        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabHost = new FragmentTabHost(getActivity());
        tabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
        tabHost.addTab(tabHost.newTabSpec("Mới nhất").setIndicator("Mới nhất"),
                fragmentWhere_MoiNhat.class, null);
        tabHost.addTab(tabHost.newTabSpec("Danh mục").setIndicator("Danh mục"),
                fragmentWhere_DanhMuc.class, null);
        tabHost.addTab(tabHost.newTabSpec("TPHCM").setIndicator("TPHCM"),
                fragmentWhere_TPHCM.class, null);
        tabHost.setOnTabChangedListener(this);


//        LinearLayout tabOne = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(0);
//        final TextView tabOneTitle = (TextView) tabOne.findViewById(android.R.id.title);
//        LinearLayout tabTwo = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(1);
//        final TextView tabTwoTitle = (TextView) tabTwo.findViewById(android.R.id.title);
//        LinearLayout tabThree = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(2);
//        final TextView tabThreeTitle = (TextView) tabThree.findViewById(android.R.id.title);
//        setupViewPager(viewPager);
        //setupTabHost(tabHost);
     /*   tabOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                tabOneTitle.setText(titleChange);
                return true;
            }
        });

        tabTwo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                tabTwoTitle.setText("New Tab 2");
                return true;
            }
        });

        tabThree.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                tabThreeTitle.setText("New Tab 3");
                return true;
                    }
                });*/
//        tabOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tabOneTitle.setText(titleChange);
//            }
//        });


        return tabHost;
//        return view;
    }

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


}

