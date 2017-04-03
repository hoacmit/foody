package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.Object.ListDatabase;
import hoa14110071.chieuthusau.foodyversion1.R;

/**
 * Created by minhh on 3/21/2017.
 */

public class DanhMucAdapter extends ArrayAdapter<ListDatabase> {
    Activity context;
    int layoutId;
    ArrayList<ListDatabase> listViewListArrayListDatabase;

    public static int newIndexChangedDanhMuc = 0;

    public DanhMucAdapter(Activity context, int layoutId, ArrayList<ListDatabase> listViewListArrayListDatabase) {
        super(context, layoutId, listViewListArrayListDatabase);
        this.context = context;
        this.layoutId = layoutId;
        this.listViewListArrayListDatabase = listViewListArrayListDatabase;
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

        if (newIndexChangedDanhMuc == position) {
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorRed));
            viewHolder.imageCheck.setVisibility(View.VISIBLE);
        } else {
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorStroke));
            viewHolder.imageCheck.setVisibility(View.GONE);
        }
        if (listViewListArrayListDatabase.get(position).getImage() != null) {
            viewHolder.imagePic.setImageBitmap(listViewListArrayListDatabase.get(position).getImage());
        }

        viewHolder.textView.setText(listViewListArrayListDatabase.get(position).getName());
        return view;
    }

    static class ViewHolder {
        ImageView imagePic;
        TextView textView;
        ImageView imageCheck;
    }
}


