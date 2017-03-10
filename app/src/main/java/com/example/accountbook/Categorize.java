package com.example.accountbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Categorize extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorize_page);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        final int checkedId = radioGroup.getCheckedRadioButtonId();
//
//        if (checkedId != -1) {
//            RadioButton radioButton = (RadioButton) findViewById(checkedId);
//            String checkedText = radioButton.getText().toString();
//            System.out.println(checkedText);
//        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                final String checkedText;
                if (checkedId !=-1){
                    final RadioButton radioButton = (RadioButton) findViewById(checkedId);
                    checkedText = radioButton.getText().toString();
                    System.out.println(checkedId + checkedText);
                }
            }
        });
//        RadioButton rbFood = (RadioButton) findViewById(R.id.rbFood);
//        RadioButton rbAmusement = (RadioButton) findViewById(R.id.rbAmusement);
//        RadioButton rbCloth = (RadioButton) findViewById(R.id.rbCloth);
//        RadioButton rbUtilities = (RadioButton) findViewById(R.id.rbUtilities);
//        RadioButton rbHouseRent = (RadioButton) findViewById(R.id.rbHouseRent);
//        RadioButton rbCellPhone = (RadioButton) findViewById(R.id.rbCellPhone);
//        RadioButton rbTransportationFee = (RadioButton) findViewById(R.id.rbTransportationFee);
//        RadioButton rbOther = (RadioButton) findViewById(R.id.rbOther);

        Button okButton = (Button) findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)v.findViewById(checkedId);
                Intent intentCategory = new Intent(Categorize.this,AddExpense.class);
                intentCategory.putExtra("checkedCategory", radioButton.getText().toString());
                startActivity(intentCategory);
            }
        });

    }
}
