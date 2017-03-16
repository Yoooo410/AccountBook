package com.example.accountbook;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private Button[] button_table;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int dayOfWeek =calendar.get(Calendar.DAY_OF_WEEK);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /** set intent from MainActivity to AddExpense **/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAdd = new Intent(MainActivity.this,AddExpense.class);
                startActivity(intentAdd);
            }
        });


        /** make each buttons of calender **/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button_table =  new Button[50];
        button_table[1] = (Button)this.findViewById(R.id.button1);
        button_table[2] = (Button)this.findViewById(R.id.button2);
        button_table[3] = (Button)this.findViewById(R.id.button3);
        button_table[4] = (Button)this.findViewById(R.id.button4);
        button_table[5] = (Button)this.findViewById(R.id.button5);
        button_table[6] = (Button)this.findViewById(R.id.button6);
        button_table[7] = (Button)this.findViewById(R.id.button7);
        button_table[8] = (Button)this.findViewById(R.id.button8);
        button_table[9] = (Button)this.findViewById(R.id.button9);
        button_table[10] = (Button)this.findViewById(R.id.button10);
        button_table[11] = (Button)this.findViewById(R.id.button11);
        button_table[12] = (Button)this.findViewById(R.id.button12);
        button_table[13] = (Button)this.findViewById(R.id.button13);
        button_table[14] = (Button)this.findViewById(R.id.button14);
        button_table[15] = (Button)this.findViewById(R.id.button15);
        button_table[16] = (Button)this.findViewById(R.id.button16);
        button_table[17] = (Button)this.findViewById(R.id.button17);
        button_table[18] = (Button)this.findViewById(R.id.button18);
        button_table[19] = (Button)this.findViewById(R.id.button19);
        button_table[20] = (Button)this.findViewById(R.id.button20);
        button_table[21] = (Button)this.findViewById(R.id.button21);
        button_table[22] = (Button)this.findViewById(R.id.button22);
        button_table[23] = (Button)this.findViewById(R.id.button23);
        button_table[24] = (Button)this.findViewById(R.id.button24);
        button_table[25] = (Button)this.findViewById(R.id.button25);
        button_table[26] = (Button)this.findViewById(R.id.button26);
        button_table[27] = (Button)this.findViewById(R.id.button27);
        button_table[28] = (Button)this.findViewById(R.id.button28);
        button_table[29] = (Button)this.findViewById(R.id.button29);
        button_table[30] = (Button)this.findViewById(R.id.button30);
        button_table[31] = (Button)this.findViewById(R.id.button31);
        button_table[32] = (Button)this.findViewById(R.id.button32);
        button_table[33] = (Button)this.findViewById(R.id.button33);
        button_table[34] = (Button)this.findViewById(R.id.button34);
        button_table[35] = (Button)this.findViewById(R.id.button35);
        button_table[36] = (Button)this.findViewById(R.id.button36);
        button_table[37] = (Button)this.findViewById(R.id.button37);
        button_table[38] = (Button)this.findViewById(R.id.button38);
        button_table[39] = (Button)this.findViewById(R.id.button39);
        button_table[40] = (Button)this.findViewById(R.id.button40);
        button_table[41] = (Button)this.findViewById(R.id.button41);
        button_table[42] = (Button)this.findViewById(R.id.button42);


        /** set the day to each buttons of calender**/
        calendar.set(year,month,1);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        int lastDate = calendar.get(Calendar.DATE);

        for(int i=dayOfWeek;i<=dayOfWeek+lastDate-1;i++){

            button_table[i].setText(String.valueOf(day));
            button_table[i].setTextSize(15);
            day=day+1;
        }


        /* set onClickListener to each buttons */
        for (int i = 1; i <= 42; i++) {

            final int finalI = i;
            button_table[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println(finalI);

                    if (v == button_table[finalI]){
                        Button button = (Button) v;
                        if(button.getText().toString() != ""){
                            System.out.println(button.getText().toString());
                            int day =Integer.parseInt(button.getText().toString());

                            Intent intentDate = new Intent(MainActivity.this, MyExpense.class);
                            intentDate.putExtra("year", year);
                            intentDate.putExtra("month", month);

                            /*year・monthは書き換えさせれても全てが同じなので問題ないが、dayは書き換えられてしまうと月の末日のみがintentされる*/
                            intentDate.putExtra("day", day);
                            Toast.makeText(getApplicationContext(), "y" + year + ", m" +month+", d" +day,Toast.LENGTH_LONG).show();
                            startActivity(intentDate);
                        }else {
                            Toast.makeText(getApplicationContext(),"Please push the number of calender!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }

        /** make the view of the year and month
                     and the buttons of Adding a month and decreasing a month **/
        Button plusMonth = (Button) this.findViewById(R.id.plusMonth);
        Button minusMonth = (Button) this.findViewById(R.id.minusMonth);

        /* the view for top of the display */
        final TextView setMonthAndYear = (TextView) findViewById(R.id.setMothAndYear);
        setMonthAndYear.setText(String.valueOf(year+"/"+(month+1)));

        /* the view for top of the display */
        final TextView setYearAndMonth = (TextView) findViewById(R.id.setYearAndMonth);
        setYearAndMonth.setText(String.valueOf(year+"/"+(month+1)));


        /* make the plus button which change to the calender of next month */
        plusMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(month == 11){
                    year = year + 1;
                    month = 0;
                }
                else{
                    month = month + 1;
                }
                setMonthAndYear.setText(String.valueOf(year+"/"+(month+1)));
                setYearAndMonth.setText(String.valueOf(year+"/"+(month+1)));

                calendar.set(year,month,1);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                calendar.add(Calendar.MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                int lastDate = calendar.get(Calendar.DATE);
                calendar.set(year,month,1);

                for(int i = 1;i < dayOfWeek; i++)
                {
                    button_table[i].setText("");
                }
                for(int i = dayOfWeek; i <= dayOfWeek + lastDate - 1; i++){
                    button_table[i].setText(String.valueOf(day));
                    button_table[i].setTextSize(15);
                    day = day + 1;
                }
                for(int i = dayOfWeek + lastDate; i <= 42; i++){
                    button_table[i].setText("");
                }

                /** make total view of expense of month **/
                DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                final SQLiteDatabase db = dbHelper.getReadableDatabase();
                final Cursor cursor1 = db.rawQuery(
                        "SELECT TOTAL("
                                + DatabaseHelper.COLUMN_PRICE + ") " +
                        "FROM AccountBook WHERE "
                                + DatabaseHelper.COLUMN_YEAR  + " = " + year +
                        " AND "
                                + DatabaseHelper.COLUMN_MONTH  + " = " + (month + 1), null);

                double total = 0;
                if (cursor1.moveToNext()){
                    total = cursor1.getInt(0);
                }
                TextView totalExpenseOfMonth = (TextView) findViewById(R.id.totalExpenseOfMonth);
                totalExpenseOfMonth.setText(String.valueOf(total));

                Button buttonMonth = (Button) findViewById(R.id.Month);
                buttonMonth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentMonth = new Intent(MainActivity.this,ExpenseOfMonth.class);
                        intentMonth.putExtra("year", String.valueOf(year));
                        intentMonth.putExtra("month", String.valueOf(month + 1));
//                        intentMonth.putExtra("total", String.valueOf(cursor1.getInt(0)));

                        startActivity(intentMonth);
                    }
                });
            }
        });

        /* make the minus button which change to the calender of past month */
        minusMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(month == 0){
                    year = year - 1;
                    month = 11;
                }
                else{
                    month = month - 1;
                }
                setMonthAndYear.setText(String.valueOf(year+"/"+(month+1)));
                setYearAndMonth.setText(String.valueOf(year+"/"+(month+1)));

                calendar.set(year,month,1);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                calendar.add(Calendar.MONTH, 1);
                calendar.add(Calendar.DATE, -1);
                int lastDate = calendar.get(Calendar.DATE);
                calendar.set(year,month,1);

                for(int i = 1;i < dayOfWeek; i++)
                {
                    button_table[i].setText("");
                }
                for(int i = dayOfWeek; i <= dayOfWeek + lastDate - 1; i++){
                    button_table[i].setText(String.valueOf(day));
                    button_table[i].setTextSize(15);
                    day=day+1;
                }
                for(int i = dayOfWeek + lastDate; i <= 42; i++){
                    button_table[i].setText("");
                }

                /** make total view of expense of month **/
                DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                final SQLiteDatabase db = dbHelper.getReadableDatabase();
                final Cursor cursor1 = db.rawQuery(
                        "SELECT TOTAL("
                                + DatabaseHelper.COLUMN_PRICE + ") " +
                        "FROM AccountBook WHERE "
                                + DatabaseHelper.COLUMN_YEAR  + " = " + year +
                        " AND "
                                + DatabaseHelper.COLUMN_MONTH  + " = " + (month + 1), null);

                double total = 0;
                if (cursor1.moveToNext()){
                    total = cursor1.getInt(0);
                }
                TextView totalExpenseOfMonth = (TextView) findViewById(R.id.totalExpenseOfMonth);
                totalExpenseOfMonth.setText(String.valueOf(total));

                Button buttonMonth = (Button) findViewById(R.id.Month);
                buttonMonth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentMonth = new Intent(MainActivity.this,ExpenseOfMonth.class);
                        intentMonth.putExtra("year", String.valueOf(year));
                        intentMonth.putExtra("month", String.valueOf(month + 1));
//                        intentMonth.putExtra("total", String.valueOf(cursor1.getInt(0)));

                        startActivity(intentMonth);
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        /** make total view of expense of month **/
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        final Cursor cursor1 = db.rawQuery(
                "SELECT TOTAL(" + DatabaseHelper.COLUMN_PRICE + ") FROM AccountBook WHERE " + DatabaseHelper.COLUMN_YEAR  + " = " + year + " AND " + DatabaseHelper.COLUMN_MONTH  + " = " + (month + 1), null);
        double total = 0;
        if (cursor1.moveToNext()){
            total = cursor1.getInt(0);
        }
        TextView totalExpenseOfMonth = (TextView) findViewById(R.id.totalExpenseOfMonth);
        totalExpenseOfMonth.setText(String.valueOf(total));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
