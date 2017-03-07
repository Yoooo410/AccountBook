//package com.example.accountbook;
//
//import android.content.ContentValues;
//import android.content.UriMatcher;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.net.Uri;
//import android.os.Build;
//import android.provider.BaseColumns;
//import android.support.annotation.Nullable;
//import android.support.annotation.RequiresApi;
//
//
//public class ContentProvider extends android.content.ContentProvider {
//
//    public static final Uri CONTENT_URI =
//            Uri.parse("content://com.example.accountbook/MyTable");
//
//    public static final class Columns {
//        public final static String COLUMN_ID = BaseColumns._ID;
//        public final static String COLUMN_YEAR = "year";
//        public final static String COLUMN_MONTH = "month";
//        public final static String COLUMN_DAY =  "day";
//        public final static String COLUMN_CATEGORY = "category";
//        public final static String COLUMN_DETAIL = "detail";
//        public final static String COLUMN_PRICE = "price";
//        public final static String COLUMN_PAYMENT = "payment";
//        public final static String COLUMN_TOTAL = "total(price)";
//
//    }
//
//    private static final int MYTABLE = 1;
//    private static final int MYTABLE_ID = 2;
//
//    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
//    static {
//        matcher.addURI(CONTENT_URI.getAuthority(), "AccountBook", MYTABLE);
//        matcher.addURI(CONTENT_URI.getAuthority(), "AccountBook/#", MYTABLE_ID);
//    }
//
//    SQLiteDatabase db;
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
//    public boolean onCreate() {
//        DatabaseHelper helper = new DatabaseHelper(getContext());
//        db = helper.getWritableDatabase();
//        return false;
//    }
//
//    @Nullable
//    @Override
//    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
//        int result = matcher.match(uri);
//
//        switch (result){
//            case MYTABLE:
//                return db.query(DatabaseHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
//
//            case MYTABLE_ID:
//                return db.query(DatabaseHelper.TABLE_NAME, projection, "_ID = ?", new String[]{uri.getLastPathSegment()}, null, null, sortOrder);
//
//            default:
//                return null;
//        }
//    }
//
//    @Nullable
//    @Override
//    public String getType(Uri uri) {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public Uri insert(Uri uri, ContentValues values) {
//        long id = db.insert(DatabaseHelper.TABLE_NAME, null, values);
//
//        if (id >= 0){
//            return Uri.withAppendedPath(uri, String.valueOf(id));
//        }
//        else
//        return null;
//    }
//
//    @Override
//    public int delete(Uri uri, String selection, String[] selectionArgs) {
//        int result = matcher.match(uri);
//        switch (result){
//
//            case MYTABLE:
//                return db.delete(DatabaseHelper.TABLE_NAME, selection, selectionArgs);
//
//            case MYTABLE_ID:
//                return db.delete(DatabaseHelper.TABLE_NAME, "_ID = ?", new String[]{uri.getLastPathSegment()});
//
//            default:
//                return 0;
//        }
//    }
//
//    @Override
//    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
//        int result = matcher.match(uri);
//        switch (result){
//
//            case MYTABLE:
//                return db.update(DatabaseHelper.TABLE_NAME, values, selection, selectionArgs);
//
//            case MYTABLE_ID:
//                return db.update(DatabaseHelper.TABLE_NAME, values, "_ID = ?", new String[]{uri.getLastPathSegment()});
//
//            default:
//                return 0;
//        }
//    }
//}
