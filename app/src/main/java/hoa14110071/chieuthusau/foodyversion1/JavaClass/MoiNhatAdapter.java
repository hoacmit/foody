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
 * Created by minhh on 3/28/2017.
 */

public class MoiNhatAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    int layoutId;
    ArrayList<Item> listViewItemArrayList = null;
    public static int lastIndexChanged =0;

    public MoiNhatAdapter(Activity context, int layoutId, ArrayList<Item> listViewItemArrayList) {
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
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.imagePic.setImageResource(listViewItemArrayList.get(position).getImgAnh());
        viewHolder.textView.setText(listViewItemArrayList.get(position).getTxtName());

        if(listViewItemArrayList.get(position).isCheck())
        {
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorRed));
            viewHolder.imageCheck.setVisibility(View.VISIBLE);
        }else
        {
            viewHolder.imageCheck.setVisibility(View.GONE);
            viewHolder.textView.setTextColor(context.getResources().getColor(R.color.colorStroke));
        }
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (position) {
//                    case 0:
//                        listViewItemArrayList.get(lastIndexChanged).setCheck(false);
////                        listViewItemArrayList.get(lastIndexChanged).setImgAnh(defaultImage[lastIndexChanged]);
//
////                        ViewHolder.imagePic.setImageResource(R.drawable.home_ic_filter_latest);
////                        ViewHolder.textView.setTextColor(Color.parseColor("#000000"));
////                        ViewHolder.checkBox.setChecked(false);
//                        ViewHolder.imagePic.setImageResource(R.drawable.home_ic_filter_latest_act);
//                        ViewHolder.textView.setTextColor(Color.parseColor("#CC0000"));
//                        listViewItemArrayList.get(0).setCheck(true);
//                        lastIndexChanged=0;
//                        break;
//                    case 1:
//                        listViewItemArrayList.get(lastIndexChanged).setCheck(false);
////                        listViewItemArrayList.get(lastIndexChanged).setImgAnh(defaultImage[lastIndexChanged]);
//
//                        ViewHolder.imagePic.setImageResource(R.drawable.home_ic_filter_most_near_act);
//                        ViewHolder.textView.setTextColor(Color.parseColor("#CC0000"));
//                        listViewItemArrayList.get(1).setCheck(true);
//                        lastIndexChanged=1;
//                        break;
//                }
////                listViewItemArrayList.get(position).setCheck(true);
////                ViewHolder.checkBox.setChecked(listViewItemArrayList.get(position).isCheck());
////                titleChange = listViewItemArrayList.get(position).getTxtName();
//            }
//        });

        return view;
    }

    static class ViewHolder {
        ImageView imagePic;
        TextView textView;
        ImageView imageCheck;
    }
}
