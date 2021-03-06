package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.Object.Category;
import hoa14110071.chieuthusau.foodyversion1.R;


/**
 * Created by minhh on 3/28/2017.
 */

public class MoiNhatAdapter extends ArrayAdapter<Category> {
    Activity context = null;
    int layoutId;
    ArrayList<Category> listViewItemArrayList = null;
    public static int newIndexChangedMoiNhat= 0;

    public void setContext(Activity context) {
        this.context = context;
    }

    public MoiNhatAdapter(Activity context, int layoutId, ArrayList<Category> listViewItemArrayList) {
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
            viewHolder = (ViewHolder) view.getTag();
        }

        if(newIndexChangedMoiNhat == position)
        {
            viewHolder.imagePic.setImageBitmap(listViewItemArrayList.get(position).getImagePress());
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorRed));
            viewHolder.imageCheck.setVisibility(View.VISIBLE);
        }else
        {
            viewHolder.imagePic.setImageBitmap(listViewItemArrayList.get(position).getImage());
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorStroke));
            viewHolder.imageCheck.setVisibility(View.GONE);
        }
        viewHolder.textView.setText(listViewItemArrayList.get(position).getName());

        return view;
    }

    static class ViewHolder {
        ImageView imagePic;
        TextView textView;
        ImageView imageCheck;
    }
}
