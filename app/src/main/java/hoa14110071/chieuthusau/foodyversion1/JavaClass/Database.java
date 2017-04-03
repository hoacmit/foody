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
import hoa14110071.chieuthusau.foodyversion1.Object.City;
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

    public ArrayList<City> get_City() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from city", null);
        ArrayList<City> listCities = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                City city = new City(cursor.getInt(0), cursor.getString(1));
                listCities.add(city);
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
            return listCities;
        }
        return null;
    }


    public SQLiteDatabase openDataBase() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            CopyDataBaseFromAsset();
            System.out.println("Copying sucess from Assets folder");
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    private void CopyDataBaseFromAsset() {
        try {
            InputStream myInput = ctx.getAssets().open(DATABASE_NAME);
            String outFile = getPath();

            File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);

            if (!f.exists()) {
                f.mkdir();
            }
            OutputStream myOutput = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();

        } catch (Exception ex) {
            Log.d("Error", ex.toString());
        }
    }

    private String getPath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
