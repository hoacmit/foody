package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.app.Activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.Object.City;
import hoa14110071.chieuthusau.foodyversion1.R;

/**
 * Created by minhh on 4/3/2017.
 */

public class CityAdapter extends ArrayAdapter<City> {
    Activity context;
    int layoutId;
    ArrayList<City> arrayCities;

    public CityAdapter(Activity context, int layoutId, ArrayList<City> arrayCities) {
        super(context, layoutId, arrayCities);
        this.context = context;
        this.layoutId = layoutId;
        this.arrayCities = arrayCities;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(layoutId, null);
            viewHolder = new ViewHolder();

            viewHolder.imgCheckCity = (ImageView) view.findViewById(R.id.imgCheckCity);
            viewHolder.tvNameCity = (TextView) view.findViewById(R.id.tvNameCity);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.tvNameCity.setText(arrayCities.get(position).getName());
        return view;
    }

    static class ViewHolder {
        ImageView imgCheckCity;
        TextView tvNameCity;
    }
}
