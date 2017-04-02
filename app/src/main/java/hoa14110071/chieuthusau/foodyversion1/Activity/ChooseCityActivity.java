package hoa14110071.chieuthusau.foodyversion1.Activity;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import hoa14110071.chieuthusau.foodyversion1.R;

public class ChooseCityActivity extends AppCompatActivity {
    private Toolbar toolbarCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);

        toolbarCity = (Toolbar) findViewById(R.id.toolbarCity);
        if (toolbarCity != null) {
            ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.colorWhite));
            setSupportActionBar(toolbarCity);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
}
