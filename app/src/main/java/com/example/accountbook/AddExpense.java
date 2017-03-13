package com.example.accountbook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class AddExpense extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_expense_page);

        final EditText editTextYear = (EditText) findViewById(R.id.editTextYear);
        final EditText editTextMonth = (EditText) findViewById(R.id.editTextMonth);
        final EditText editTextDay = (EditText) findViewById(R.id.editTextDay);
        final TextView textViewCategory = (TextView) findViewById(R.id.textViewCategory);
        final EditText editTextDetail = (EditText) findViewById(R.id.editTextDetail);
        final EditText editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        ImageButton ibCategorize = (ImageButton) findViewById(R.id.categorizeButton);

        ibCategorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCategorize = new Intent(AddExpense.this,Categorize.class);
                startActivityForResult(intentCategorize,1);
            }
        });
        Intent getCategorize = getIntent();
        String category = getCategorize.getStringExtra("CheckedCategory");
        System.out.println(category);
        textViewCategory.setText(category);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                final String year = editTextYear.getText().toString();
                final String month = editTextMonth.getText().toString();
                final String day = editTextDay.getText().toString();
                final String category = textViewCategory.getText().toString();
                final String detail = editTextDetail.getText().toString();
                final String price = editTextPrice.getText().toString();

                RadioGroup rgPayment = (RadioGroup) findViewById(R.id.rgPayment);
                int checkedId = rgPayment.getCheckedRadioButtonId();
                RadioButton rbPayment = (RadioButton) findViewById(checkedId);
                final String payment = rbPayment.getText().toString();


                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_YEAR,year);
                values.put(DatabaseHelper.COLUMN_MONTH,month);
                values.put(DatabaseHelper.COLUMN_DAY,day);
                values.put(DatabaseHelper.COLUMN_CATEGORY ,category);
                values.put(DatabaseHelper.COLUMN_DETAIL,detail);
                values.put(DatabaseHelper.COLUMN_PRICE,price);
                values.put(DatabaseHelper.COLUMN_PAYMENT,payment);

                String debu = "y" + year + ", m" +month+", d" +day;
                Log.e("test","### " + debu);
//                Toast.makeText(getApplicationContext(), debu, Toast.LENGTH_SHORT).show();

                DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                long ret;
                try {
                    ret = db.insert(DatabaseHelper.TABLE_NAME, "", values);
                    Intent intent1 = new Intent(AddExpense.this,MyExpense.class);
                    intent1.putExtra("year",year);
                    intent1.putExtra("moth",month);
                    intent1.putExtra("day",day);
                    intent1.putExtra("price",price);
                    Log.e("test", "### " +year+","+month+","+day+ ","+category+","+detail+","+price+","+payment);

                } finally {
                    db.close();
                }
                if (ret == -1){
                    Toast.makeText(getApplicationContext(), "Error to insert!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Succeed in inserting your expense to the account book!" ,Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){

            case 1:
                if(resultCode == RESULT_OK){
                    String checkedCategory = data.getStringExtra("checkedCategory");
                    final TextView textViewCategory = (TextView) findViewById(R.id.textViewCategory);
                    textViewCategory.setText(checkedCategory);
                }
        }
    }
}
