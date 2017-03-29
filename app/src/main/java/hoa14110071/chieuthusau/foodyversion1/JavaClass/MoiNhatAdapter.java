package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.R;

/**
 * Created by minhh on 3/28/2017.
 */

public class MoiNhatAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    int layoutId;
    ArrayList<Item> listViewItemArrayList = null;
    public static int indexChanged=0;

    public MoiNhatAdapter(Activity context, int layoutId, ArrayList<Item> listViewItemArrayList) {
        super(context, layoutId, listViewItemArrayList);
        this.context = context;
        this.layoutId = layoutId;
        this.listViewItemArrayList = listViewItemArrayList;
    }

    public View getView(final int position, final View convertView, ViewGroup parent) {
        final DanhMucAdapter.ViewHolder viewHolder = new DanhMucAdapter.ViewHolder();
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(layoutId, null);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imgPic);
            viewHolder.textView = (TextView) view.findViewById(R.id.txtName);
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.cbChoose);
        }
        viewHolder.imageView.setImageResource(listViewItemArrayList.get(position).getImgAnh());
        viewHolder.textView.setText(listViewItemArrayList.get(position).getTxtName());
        viewHolder.checkBox.setChecked(listViewItemArrayList.get(position).isCheck());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        viewHolder.imageView.setImageResource(R.drawable.home_ic_filter_latest);
                        viewHolder.textView.setTextColor(Color.parseColor("#000000"));
                        viewHolder.checkBox.setChecked(true);

                        viewHolder.imageView.setImageResource(R.drawable.home_ic_filter_latest_act);
                        viewHolder.textView.setTextColor(Color.parseColor("#CC0000"));
                        viewHolder.checkBox.setChecked(true);
                        break;
                    case 1:
                        viewHolder.imageView.setImageResource(R.drawable.home_ic_filter_most_near_act);
                        viewHolder.textView.setTextColor(Color.parseColor("#CC0000"));
                        viewHolder.checkBox.setChecked(true);
                        break;
                }
//                listViewItemArrayList.get(position).setCheck(true);
//                viewHolder.checkBox.setChecked(listViewItemArrayList.get(position).isCheck());
//                titleChange = listViewItemArrayList.get(position).getTxtName();
            }
        });
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
        CheckBox checkBox;
    }
}
