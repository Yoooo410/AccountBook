package com.example.accountbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.Calendar;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.BaseColumns;
import android.support.annotation.RequiresApi;

import static android.R.attr.y;
import static android.R.attr.yearListItemTextAppearance;

@RequiresApi(api = Build.VERSION_CODES.N)
public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "MyTable";
    private final static int DB_VER = 1;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context = context;
    }

    public final static String TABLE_NAME = "AccountBook";
    public final static String COLUMN_ID = BaseColumns._ID;
    public final static String COLUMN_YEAR = "year";
    public final static String COLUMN_MONTH = "month";
    public final static String COLUMN_DAY =  "day";
    public final static String COLUMN_CATEGORY = "category";
    public final static String COLUMN_DETAIL = "detail";
    public final static String COLUMN_PRICE = "price";
    public final static String COLUMN_PAYMENT = "payment";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE " + TABLE_NAME + "(";
        sql += COLUMN_ID + " INTEGER PRIMARY KEY,";
        sql += COLUMN_YEAR + " TEXT,";
        sql += COLUMN_MONTH + " TEXT,";
        sql += COLUMN_DAY + " TEXT,";
        sql += COLUMN_CATEGORY + " TEXT,";
        sql += COLUMN_DETAIL + " TEXT,";
        sql += COLUMN_PRICE + " TEXT,";
        sql += COLUMN_PAYMENT + " TEXT";
        sql += ")";

        System.out.println("sql = " + sql);
        
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
