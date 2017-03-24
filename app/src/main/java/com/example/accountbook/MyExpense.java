package com.example.accountbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MyExpense extends AppCompatActivity {

    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myexpense_page);

        calendar.getTimeInMillis();
        System.currentTimeMillis();
        calendar.setTimeInMillis(System.currentTimeMillis());

        final Intent intent1 = getIntent();
        year = intent1.getIntExtra("year",year);
        month = intent1.getIntExtra("month",month);
        day = intent1.getIntExtra("day",day);

        final String[] cols = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_YEAR,
                DatabaseHelper.COLUMN_MONTH,
                DatabaseHelper.COLUMN_DAY,
                DatabaseHelper.COLUMN_CATEGORY,
                DatabaseHelper.COLUMN_DETAIL,
                DatabaseHelper.COLUMN_PRICE,
                DatabaseHelper.COLUMN_PAYMENT,
                };

        final String[] cols2 = {
                DatabaseHelper.COLUMN_CATEGORY,
                DatabaseHelper.COLUMN_DETAIL,
                DatabaseHelper.COLUMN_PRICE,
                DatabaseHelper.COLUMN_PAYMENT
                };

        String[] selectionArgs = {
                String.valueOf(year),
                String.valueOf(month + 1),
                String.valueOf(day)
                };

        Log.e("test", "y" + year + ", m" + month +", d" + day);

        String selection = "year=? AND month=? AND day=?";

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        final SimpleCursorAdapter adapter;
        final ListView myExpenseListView = (ListView) findViewById(R.id.myExpenseListView);

        final Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, cols, selection, selectionArgs, null, null, null);
        cursor.moveToFirst();
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_item,
                cursor,
                cols2,
                new int[] {R.id.category, R.id.detail, R.id.price, R.id.payment},
                0);
        myExpenseListView.setAdapter(adapter);


        Log.e("test", "y" + year + ", m" +month+", d" +day);

        String tableName=String.valueOf(year) + " / " + String.valueOf(month+1) + " / " + String.valueOf(day);
        TextView dateOfExpense = (TextView) findViewById(R.id.dateOfExpense);
        dateOfExpense.setText(tableName);


        /** set the dialog of delete button **/
        myExpenseListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());
                dialog.setTitle("Do you want to delete the expense?");
                dialog.setMessage("");

                Toast.makeText(getBaseContext(),id + "",Toast.LENGTH_SHORT).show();

                final String deleteId = String.valueOf(id);

                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COLUMN_ID + " = ?",new String[]{deleteId});
                        adapter.swapCursor(cursor);
                        finish();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.create();
                dialog.show();
                return true;
            }
        });

        /** make total view of expense of month **/
        final Cursor cursor1 = db.rawQuery(
                "SELECT TOTAL(" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE "
                        + DatabaseHelper.COLUMN_YEAR  + " = " + year
                        + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + (month + 1)
                        + " AND " + DatabaseHelper.COLUMN_DAY + " = " + day, null);
        double total = 0;
        if (cursor1.moveToNext()){
            total = cursor1.getInt(0);
        }
        TextView totalExpenseOfDay = (TextView) findViewById(R.id.totalExpenseOfDay);
        totalExpenseOfDay.setText(String.valueOf(total));

//        MyListAdapter adapter1 = new MyListAdapter(this,R.layout.view_pager,cols2);
//        myExpenseListView.setAdapter(adapter1);
    }
}
