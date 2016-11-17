package com.example.nikhil.SabziBazaar.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by nikhilbansal on 09/08/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private final String TABLE = "tableimage";

    private static DatabaseHelper INSTANCE;

    private interface Columns {
        String NAME = "productCAT";
        String PRICE = "pricename";

        String SUM_PRICE = "SUM(pricename)";
    }

    private SQLiteDatabase db=null;

    public static DatabaseHelper getInstance(Context context) {
        if(INSTANCE == null) INSTANCE = new DatabaseHelper(context);
        return INSTANCE;
    }

    private DatabaseHelper(Context context) {
        super(context, "ImageDb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tableimage(productCAT TEXT,pricename TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tableimage");
        onCreate(db);
    }

    public ProductSet getTotalProduct() {
        SQLiteDatabase sql=this.getReadableDatabase();

        String rawQuery = "SELECT *, SUM(" + Columns.PRICE + ") FROM " + TABLE;

        Cursor cursor=sql.rawQuery(rawQuery, null);

        if(cursor == null || cursor.isClosed()) return null;

        cursor.moveToFirst();

        return getProductSet(cursor);
    }

    public ProductSet getProductSet(Cursor cursor) {

        String name = cursor.getString(cursor.getColumnIndex(Columns.NAME));
        String price = cursor.getString(cursor.getColumnIndex(Columns.PRICE));

        if(!cursor.isNull(cursor.getColumnIndex(Columns.SUM_PRICE))) {
            String sumPrice = cursor.getString(cursor.getColumnIndex(Columns.SUM_PRICE));

            if(!TextUtils.isEmpty(sumPrice)) price = sumPrice;
        }

        return new ProductSet(name, price);
    }

    public ArrayList<ProductSet> queryAllProducts() {
        SQLiteDatabase sql=this.getReadableDatabase();

        Cursor cursor=sql.query(TABLE, null, null, null, null, null, null);

        ArrayList<ProductSet> list = new ArrayList<>();

        if(cursor == null || cursor.isClosed()) return null;

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            list.add(getProductSet(cursor));
            cursor.moveToNext();
        }

        return list;
    }

    public long insert(ProductSet productSet) {
        SQLiteDatabase sql=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(Columns.NAME, productSet.name);
        cv.put(Columns.PRICE, productSet.price);

        return sql.insert(TABLE, null, cv);
    }

    public void insertdata(String n,String p) {
        SQLiteDatabase sql=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(Columns.NAME,n);
        cv.put(Columns.PRICE,p);

        sql.insert(TABLE, null, cv);
    }

    public void delete(){
        SQLiteDatabase sql=this.getWritableDatabase();
        sql.delete(TABLE,null,null);
    }
}
