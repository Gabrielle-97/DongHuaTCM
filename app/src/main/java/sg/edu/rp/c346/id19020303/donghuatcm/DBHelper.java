package sg.edu.rp.c346.id19020303.donghuatcm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.concurrent.atomic.DoubleAccumulator;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "registration.db";
    private static final int DATABASE_VERSION = 1;
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        String createUserTableSql = "CREATE TABLE " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USER_NAME + " TEXT, "
                + COLUMN_USER_PASSWORD + " TEXT)";
        myDB.execSQL(createUserTableSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(myDB);

    }

    public boolean insertData (String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_NAME, username);
        cv.put(COLUMN_USER_PASSWORD, password);

        long insert = db.insert(USER_TABLE, null, cv);
        db.close();
        if (insert == -1){
            return false;
        }
        else {
            return true;

        }


    }

    public Boolean checkUsername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from USER_TABLE where USER_NAME = ?", new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return  false;
        }
    }

    //Check the username and password
    public Boolean checkUsernamePassword (String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from USER_TABLE where USER_NAME = ? and USER_PASSWORD = ?", new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }




}
