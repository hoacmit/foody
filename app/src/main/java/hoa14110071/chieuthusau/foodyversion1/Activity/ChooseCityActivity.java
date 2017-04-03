package hoa14110071.chieuthusau.foodyversion1.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import hoa14110071.chieuthusau.foodyversion1.JavaClass.CityAdapter;
import hoa14110071.chieuthusau.foodyversion1.R;

import static hoa14110071.chieuthusau.foodyversion1.Activity.MainActivity.cities;
import static hoa14110071.chieuthusau.foodyversion1.JavaClass.CityAdapter.nextIndexChangedCity;

public class ChooseCityActivity extends AppCompatActivity {
    private Toolbar toolbarCity;

    private ListView lstCity;
    private CityAdapter cityAdapter;

    private Button btnXongCity;



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

        lstCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nextIndexChangedCity = position;

                cityAdapter.notifyDataSetChanged();
            }
        });

        btnXongCity = (Button) findViewById(R.id.btnXongCity);
        btnXongCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("Id",String.valueOf(cities.get(nextIndexChangedCity).getId()));
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });


    }
}
