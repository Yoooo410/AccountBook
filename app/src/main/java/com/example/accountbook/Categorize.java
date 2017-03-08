package com.example.accountbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class Categorize extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorize_page);

        RadioButton rbFood = (RadioButton) findViewById(R.id.rbFood);
        RadioButton rbAmusement = (RadioButton) findViewById(R.id.rbAmusement);
        RadioButton rbCloth = (RadioButton) findViewById(R.id.rbCloth);
        RadioButton rbUtilities = (RadioButton) findViewById(R.id.rbUtilities);
        RadioButton rbHouseRent = (RadioButton) findViewById(R.id.rbHouseRent);
        RadioButton rbCellPhone = (RadioButton) findViewById(R.id.rbCellPhone);
        RadioButton rbTransportationFee = (RadioButton) findViewById(R.id.rbTransportationFee);
        RadioButton rbOther = (RadioButton) findViewById(R.id.rbOther);



    }
}
