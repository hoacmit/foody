package hoa14110071.chieuthusau.foodyversion1.JavaClass;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import hoa14110071.chieuthusau.foodyversion1.Object.Category;
import hoa14110071.chieuthusau.foodyversion1.Object.ListDatabase;

/**
 * Created by minhh on 4/2/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Foody.sqlite";
    public static final String DB_PATH_SUFFIX = "/databases/";
    static Context ctx;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx = context;
    }




    public ArrayList<Category> get_Category() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from category", null);
        ArrayList<Category> categories = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Category category = new Category(cursor.getInt(0), cursor.getString(1), cursor.getBlob(2), cursor.getBlob(3));
                categories.add(category);
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
            return categories;
        }
        return null;
    }

    public ArrayList<ListDatabase> get_ListDatabase() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from list", null);
        ArrayList<ListDatabase> listDatabases = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                ListDatabase listDatabase = new ListDatabase(cursor.getInt(0), cursor.getString(1), cursor.getBlob(2));
                listDatabases.add(listDatabase);
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
            return listDatabases;
        }
        return null;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
