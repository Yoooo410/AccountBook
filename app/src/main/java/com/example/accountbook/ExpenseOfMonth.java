package com.example.accountbook;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


@RequiresApi(api = Build.VERSION_CODES.N)
public class ExpenseOfMonth extends AppCompatActivity{

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense_of_month_page);

        Intent intentMonth = getIntent();
        String year = intentMonth.getStringExtra("year");
        String month = intentMonth.getStringExtra("month");

        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        /** make each category's total of monthly expense **/

        /* For Food */
        ImageView imageFood = (ImageView) findViewById(R.id.imageFood);
        imageFood.setImageResource(R.drawable.imagefood);

        final Cursor cursor1 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'Food'", null);
        double totalFood = 0;
        if (cursor1.moveToNext()){
            totalFood = cursor1.getInt(0);
        }
        TextView totalExpenseOfFood = (TextView) findViewById(R.id.totalExpenseOfFood);
        totalExpenseOfFood.setText(String.valueOf(totalFood));



        /* For Amusement */
        ImageView imageAmusement = (ImageView) findViewById(R.id.imageAmusement);
        imageAmusement.setImageResource(R.drawable.imageamusement);

        final Cursor cursor2 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'Amusement'", null);
        double totalAmusement = 0;
        if (cursor2.moveToNext()){
            totalAmusement = cursor2.getInt(0);
        }
        TextView totalExpenseOfAmusement = (TextView) findViewById(R.id.totalExpenseOfAmusement);
        totalExpenseOfAmusement.setText(String.valueOf(totalAmusement));



        /* For Cloth */
        ImageView imageCloth = (ImageView) findViewById(R.id.imageCloth);
        imageCloth.setImageResource(R.drawable.imagecloth);

        final Cursor cursor3 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'Cloth'", null);
        double totalCloth = 0;
        if (cursor3.moveToNext()){
            totalCloth = cursor3.getInt(0);
        }
        TextView totalExpenseOfCloth = (TextView) findViewById(R.id.totalExpenseOfCloth);
        totalExpenseOfCloth.setText(String.valueOf(totalCloth));



        /* For Utilities */
        ImageView imageUtilities = (ImageView) findViewById(R.id.imageUtilities);
        imageUtilities.setImageResource(R.drawable.imageutilities);

        final Cursor cursor4 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'Utilities'", null);
        double totalUtilities = 0;
        if (cursor4.moveToNext()){
            totalUtilities = cursor4.getInt(0);
        }
        TextView totalExpenseOfUtilities = (TextView) findViewById(R.id.totalExpenseOfUtilities);
        totalExpenseOfUtilities.setText(String.valueOf(totalUtilities));



        /* For House Rent */
        ImageView imageHouseRent = (ImageView) findViewById(R.id.imageHouseRent);
        imageHouseRent.setImageResource(R.drawable.imagehouserent);

        final Cursor cursor5 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'House Rent'", null);
        double totalHouseRent = 0;
        if (cursor5.moveToNext()){
            totalHouseRent = cursor5.getInt(0);
        }
        TextView totalExpenseOfHouseRent = (TextView) findViewById(R.id.totalExpenseOfHOuseRent);
        totalExpenseOfHouseRent.setText(String.valueOf(totalHouseRent));



        /* For Cell Phone */
        ImageView imageCellPhone = (ImageView) findViewById(R.id.imageCellPhone);
        imageCellPhone.setImageResource(R.drawable.imagecellphone);

        final Cursor cursor6 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'Cell Phone'", null);
        double totalCellPhone = 0;
        if (cursor6.moveToNext()){
            totalCellPhone = cursor6.getInt(0);
        }
        TextView totalExpenseOfCellPhone = (TextView) findViewById(R.id.totalExpenseOfCellPhone);
        totalExpenseOfCellPhone.setText(String.valueOf(totalCellPhone));



        /* For Transportation Fee */
        ImageView imageTransportationFee = (ImageView) findViewById(R.id.imageTransportationFee);
        imageTransportationFee.setImageResource(R.drawable.imagetransportation);

        final Cursor cursor7 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'Transportation Fee'", null);
        double totalTransportationFee = 0;
        if (cursor7.moveToNext()){
            totalTransportationFee = cursor7.getInt(0);
        }
        TextView totalExpenseOfTransportationFee = (TextView) findViewById(R.id.totalExpenseOfTransportationFee);
        totalExpenseOfTransportationFee.setText(String.valueOf(totalTransportationFee));



        /* For Other */
        ImageView imageOther = (ImageView) findViewById(R.id.imageOther);
        imageOther.setImageResource(R.drawable.imageother);

        final Cursor cursor8 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month
                        + " AND " + DatabaseHelper.COLUMN_CATEGORY + " = " + "'Other'", null);
        double totalOther = 0;
        if (cursor8.moveToNext()){
            totalOther = cursor8.getInt(0);
        }
        TextView totalExpenseOfOther = (TextView) findViewById(R.id.totalExpenseOfOther);
        totalExpenseOfOther.setText(String.valueOf(totalOther));



        /* For total */
        final Cursor cursor9 = db.rawQuery(
                "SELECT TOTAL (" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + month, null);
        double total = 0;
        if (cursor9.moveToNext()){
            total = cursor9.getInt(0);
        }
        TextView totalExpense = (TextView) findViewById(R.id.totalExpense);
        totalExpense.setText(String.valueOf(total));
    }
}
