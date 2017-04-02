package hoa14110071.chieuthusau.foodyversion1.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import hoa14110071.chieuthusau.foodyversion1.Fragment.fragmentWhere;
import hoa14110071.chieuthusau.foodyversion1.Fragment.fragmentEatWhat;
import hoa14110071.chieuthusau.foodyversion1.JavaClass.Database;
import hoa14110071.chieuthusau.foodyversion1.Object.Category;
import hoa14110071.chieuthusau.foodyversion1.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;


    public static Database database;
    public static ArrayList<Category> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        setupViewPager(viewPager);
        setupTablayout(tabLayout);

        database = new Database(this);

        database.openDataBase();

        categories = database.get_Category();


    }

    private void initControls() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragmentWhere(), "Ở đâu");
        adapter.addFragment(new fragmentEatWhat(), "Ăn gì");
        viewPager.setAdapter(adapter);
    }

    private void setupTablayout(TabLayout tabLayout) {
        tabLayout.setupWithViewPager(viewPager);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }


}
