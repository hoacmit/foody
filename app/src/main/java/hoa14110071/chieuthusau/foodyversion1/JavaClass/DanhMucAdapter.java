package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.R;

/**
 * Created by minhh on 3/21/2017.
 */

public class DanhMucAdapter extends ArrayAdapter<Item> {
    Activity context;
    int layoutId;
    ArrayList<Item> listViewItemArrayList;

    public static int lastIndexChangedDanhMuc = 0;

    public DanhMucAdapter(Activity context, int layoutId, ArrayList<Item> listViewItemArrayList) {
        super(context, layoutId, listViewItemArrayList);
        this.context = context;
        this.layoutId = layoutId;
        this.listViewItemArrayList = listViewItemArrayList;
    }

    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(layoutId, null);
            viewHolder = new ViewHolder();

            viewHolder.imagePic = (ImageView) view.findViewById(R.id.imgPic);
            viewHolder.textView = (TextView) view.findViewById(R.id.txtName);
            viewHolder.imageCheck = (ImageView) view.findViewById(R.id.imgCheck);
            view.setTag(viewHolder);
        } else {
            viewHolder = (DanhMucAdapter.ViewHolder) view.getTag();
        }

        viewHolder.imagePic.setImageResource(listViewItemArrayList.get(position).getImgAnh());
        viewHolder.textView.setText(listViewItemArrayList.get(position).getTxtName());

        if (listViewItemArrayList.get(position).isCheck()) {
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorRed));
            viewHolder.imageCheck.setVisibility(View.VISIBLE);
        } else {
            viewHolder.imageCheck.setVisibility(View.GONE);
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorStroke));
        }
        return view;
    }

    static class ViewHolder {
        ImageView imagePic;
        TextView textView;
        ImageView imageCheck;
    }
}


