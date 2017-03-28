package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import hoa14110071.chieuthusau.foodyversion1.Object.Street;
import hoa14110071.chieuthusau.foodyversion1.R;


public class CustomAdapterExpandableListview extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> mHeaderGroup;
    private HashMap<String, List<Street>> mDataChild;

    public CustomAdapterExpandableListview(Context mContext, List<String> mHeaderGroup, HashMap<String, List<Street>> mDataChild) {
        this.mContext = mContext;
        this.mHeaderGroup = mHeaderGroup;
        this.mDataChild = mDataChild;
    }

    @Override
    public int getGroupCount() {
        return mHeaderGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mDataChild.get(mHeaderGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mHeaderGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mDataChild.get(mHeaderGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.list_row_header_expandable,parent,false);
        }
        TextView tvDistrictName = (TextView) convertView.findViewById(R.id.tvDistrictName);
        Button btnChoosen = (Button) convertView.findViewById(R.id.btnChoosen);
        tvDistrictName.setText(mHeaderGroup.get(groupPosition));
        btnChoosen.setText("");
        btnChoosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.list_row_child_expandable,parent,false);
        }
        TextView tvStreet = (TextView) convertView.findViewById(R.id.tvStreet);
        tvStreet.setText(String.valueOf(((Street)getChild(groupPosition,childPosition)).getStreetName()));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
