package hoa14110071.chieuthusau.foodyversion1.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hoa14110071.chieuthusau.foodyversion1.JavaClass.CustomAdapterExpandableListview;
import hoa14110071.chieuthusau.foodyversion1.Object.Street;
import hoa14110071.chieuthusau.foodyversion1.R;


public class fragmentWhere_TPHCM extends Fragment {

    private ExpandableListView exLstWhere;
    private CustomAdapterExpandableListview customAdapter;
    private List<String> listDistrict;
    private HashMap<String,List<Street>> mData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_where_tphcm, container, false);
        exLstWhere = (ExpandableListView) view.findViewById(R.id.exLstWhere);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        exLstWhere.setIndicatorBounds(width - dp2px(50), width - dp2px(10));
        //exLstWhere.expandGroup(1);
//        exLstWhere.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                Toast.makeText(getContext(),"aaaaaaaaa",Toast.LENGTH_SHORT);
//                return false;
//            }
//        });

        customAdapter = new CustomAdapterExpandableListview(getContext(),listDistrict,mData);
        exLstWhere.setAdapter(customAdapter);

        return view;
    }

    public int dp2px(float dp) {
        // Get the screen's density scale
        final float density = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * density + 0.5f);
    }


}
