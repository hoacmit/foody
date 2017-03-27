package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

import hoa14110071.chieuthusau.foodyversion1.Object.Item;
import hoa14110071.chieuthusau.foodyversion1.R;

import static hoa14110071.chieuthusau.foodyversion1.Fragment.fragmentWhere.titleChange;

/**
 * Created by minhh on 3/21/2017.
 */

public class DanhMucAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    int layoutId;
    ArrayList<Item> listViewItemArrayList = null;

    public DanhMucAdapter(Activity context, int layoutId, ArrayList<Item> listViewItemArrayList) {
        super(context, layoutId, listViewItemArrayList);
        this.context = context;
        this.layoutId = layoutId;
        this.listViewItemArrayList = listViewItemArrayList;
    }

    public View getView(final int position, final View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = new ViewHolder();
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
                listViewItemArrayList.get(position).setCheck(true);
                viewHolder.checkBox.setChecked(listViewItemArrayList.get(position).isCheck());
                titleChange=listViewItemArrayList.get(position).getTxtName();
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


