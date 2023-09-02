package com.example.practicesql;

//import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "UserProfile";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "userProfile";

    // below variable is for our id column.
    private static final String username = "username";

    // below variable is for our course name column
    private static final String password = "password";

    // below variable id for our course duration column.
    private static final String cc = "codechef";

    // below variable for our course description column.
    private static final String cf = "codeforces";

    // below variable is for our course tracks column.
    private static final String lc = "leetcode";
    private static final String gfg = "geeksforgeeks";

    private static final String cn = "codingninja";
    private static final String git = "github";
    private static final String hack = "hackkerrank";
    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + username + " TEXT PRIMARY KEY , "
                + password + " TEXT,"
                + cc + " TEXT,"
                + cf + " TEXT,"
                + lc + " TEXT,"
                + gfg + " TEXT,"
                + cn + " TEXT,"
                + git + " TEXT,"
                + hack + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String usn,String pass, String codechef, String codeforces,
                             String leetcode,String geeks,String ninja,String github,String hackerrank) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(username,usn);
        values.put(password, pass);
        values.put(cc, codechef);
        values.put(cf, codeforces);
        values.put(lc, leetcode);
        values.put(gfg, geeks);
        values.put(cn, ninja);
        values.put(git, github);
        values.put(hack, hackerrank);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Profiles readCourses(String usr,String pass,Context context) {
        // on below line we are creating a
        // database for reading our database.
//        Toast.makeText(context,"Working",Toast.LENGTH_SHORT).show();
        try{
            SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
            String query = ("SELECT * FROM " + TABLE_NAME);
            @SuppressLint("Recycle") Cursor cursorCourses = db.rawQuery(query, null);
//            Toast.makeText(context,"Working Again",Toast.LENGTH_SHORT).show();
        // on below line we are creating a new array list.

            if(cursorCourses.moveToFirst())
            {
                do {
//                Toast.makeText(context,"Working Again",Toast.LENGTH_SHORT).show();
                    String usn = cursorCourses.getString(0);
                    String pw = cursorCourses.getString(1);
                    if (usn.equals(usr) && pw.equals(pass)) {
                        Profiles p = new Profiles(cursorCourses.getString(2),
                                cursorCourses.getString(3),
                                cursorCourses.getString(4),
                                cursorCourses.getString(5),
                                cursorCourses.getString(6),
                                cursorCourses.getString(7),
                                cursorCourses.getString(8));
//                        Toast.makeText(context, "Working Again", Toast.LENGTH_SHORT).show();
                        return p;
                    }
                }while(cursorCourses.moveToNext());
                return null;
            }
        }
        catch (Exception e)
        {
            Toast.makeText(context,e.getMessage().toString(),Toast.LENGTH_SHORT);
        }
        // at last closing our cursor
        // and returning our array list.
//        cursorCourses.close();
        return null;
    }
    public boolean check(String usr,String pass)
    {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM" + TABLE_NAME + " WHERE " + username + " = " + usr+" and "+password+" = "+pass;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.getCount()<=0)return false;
        cursor.close();
        return true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
