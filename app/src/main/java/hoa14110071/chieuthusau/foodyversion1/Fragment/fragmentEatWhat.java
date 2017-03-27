package hoa14110071.chieuthusau.foodyversion1.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import hoa14110071.chieuthusau.foodyversion1.R;

public class fragmentEatWhat extends Fragment {

    private FragmentTabHost tabHost;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tabHost = new FragmentTabHost(getActivity());
        tabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        tabHost.addTab(tabHost.newTabSpec("Mới nhất").setIndicator("Mới nhất"),
                fragmentEatWhat_MoiNhat.class, null);
        tabHost.addTab(tabHost.newTabSpec("Danh mục").setIndicator("Danh mục"),
                fragmentEatWhat_DanhMuc.class, null);
        tabHost.addTab(tabHost.newTabSpec("TPHCM").setIndicator("TPHCM"),
                fragmentEatWhat_TPHCM.class, null);

        LinearLayout tabOne = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(0);
        final TextView tabOneTitle = (TextView) tabOne.findViewById(android.R.id.title);
        LinearLayout tabTwo = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(1);
        final TextView tabTwoTitle = (TextView) tabTwo.findViewById(android.R.id.title);
        LinearLayout tabThree = (LinearLayout) tabHost.getTabWidget().getChildTabViewAt(2);
        final TextView tabThreeTitle = (TextView) tabThree.findViewById(android.R.id.title);
//        setupViewPager(viewPager);
        //setupTabHost(tabHost);


        return tabHost;
    }


}
