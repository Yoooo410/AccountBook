package com.example.accountbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Categorize extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private final String categoryText[] = {
            "Food",
            "Amusement",
            "Cloth",
            "Utilities",
            "House Rent",
            "Cell Phone",
            "Transportation Fee",
            "Other"
    };

    private final int categoryImage[] = {
            R.drawable.imagefood,
            R.drawable.imageamusement,
            R.drawable.imagecloth,
            R.drawable.imageutilities,
            R.drawable.imagehouserent,
            R.drawable.imagecellphone,
            R.drawable.imagetransportation,
            R.drawable.imageother
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_recylerview);

        mRecyclerView = (RecyclerView) findViewById(R.id.categoryRecylerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<Category> category = prepareData();
        MyCategoryAdapter adapter = new MyCategoryAdapter(getApplicationContext(), category);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intentCategory = new Intent(Categorize.this, AddExpense.class);
                        intentCategory.putExtra("ClickedCategory", categoryText[position]);
                        System.out.println(categoryText[position]);
                        setResult(RESULT_OK, intentCategory);
                        finish();
                    }
                })
        );
    }

    private ArrayList<Category> prepareData() {
        ArrayList<Category> category1 = new ArrayList<>();
        for (int i = 0; i < categoryImage.length; i++) {
            Category category2 = new Category();
            category2.setCategoryName(categoryText[i]);
            category2.setCategoryIcon(categoryImage[i]);
            category1.add(category2);
        }
        return category1;
    }
}



//        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        final int checkedId = radioGroup.getCheckedRadioButtonId();
//
//        if (checkedId != -1) {
//            RadioButton radioButton = (RadioButton) findViewById(checkedId);
//            String checkedText = radioButton.getText().toString();
//            System.out.println(checkedText);
//        }
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                final String checkedText;
//                if (checkedId !=-1){
//                    final RadioButton radioButton = (RadioButton) findViewById(checkedId);
//                    checkedText = radioButton.getText().toString();
//                    System.out.println(checkedId + checkedText);
//                }
//            }
//        });
//        RadioButton rbFood = (RadioButton) findViewById(R.id.rbFood);
//        RadioButton rbAmusement = (RadioButton) findViewById(R.id.rbAmusement);
//        RadioButton rbCloth = (RadioButton) findViewById(R.id.rbCloth);
//        RadioButton rbUtilities = (RadioButton) findViewById(R.id.rbUtilities);
//        RadioButton rbHouseRent = (RadioButton) findViewById(R.id.rbHouseRent);
//        RadioButton rbCellPhone = (RadioButton) findViewById(R.id.rbCellPhone);
//        RadioButton rbTransportationFee = (RadioButton) findViewById(R.id.rbTransportationFee);
//        RadioButton rbOther = (RadioButton) findViewById(R.id.rbOther);

//        Button okButton = (Button) findViewById(R.id.okButton);
//        okButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int checkedId = radioGroup.getCheckedRadioButtonId();
//                RadioButton radioButton = (RadioButton)findViewById(checkedId);
//                Intent intentCategory = new Intent(Categorize.this,AddExpense.class);
//                intentCategory.putExtra("checkedCategory", radioButton.getText().toString());
//                setResult(RESULT_OK,intentCategory);
//                finish();
//            }
//        });
