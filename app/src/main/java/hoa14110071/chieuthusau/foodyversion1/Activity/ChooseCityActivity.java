package hoa14110071.chieuthusau.foodyversion1.Activity;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.JavaClass.CityAdapter;
import hoa14110071.chieuthusau.foodyversion1.Object.City;
import hoa14110071.chieuthusau.foodyversion1.R;

import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.cities;

public class ChooseCityActivity extends AppCompatActivity {
    private Toolbar toolbarCity;

    private ListView lstCity;
    private CityAdapter cityAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);

        toolbarCity = (Toolbar) findViewById(R.id.toolbarCity);
        if (toolbarCity != null) {
            //ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.colorWhite));
            setSupportActionBar(toolbarCity);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lstCity = (ListView) findViewById(R.id.lstCity);
        cityAdapter = new CityAdapter(this,R.layout.list_row_city,cities);
        lstCity.setAdapter(cityAdapter);


    }
}
