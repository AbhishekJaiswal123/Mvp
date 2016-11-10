package abhishek.com.mvp.data.source.localdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abhishek on 10/11/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Mvp.db";


    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static final String CREATE_USER_TABLE =
            "CREATE TABLE " + DatabaseColumns.UserColumn.TABLE_NAME + " (" +
                    DatabaseColumns.UserColumn._ID + TEXT_TYPE + " PRIMARY KEY," +
                    DatabaseColumns.UserColumn.COLUMN_USER_ID + TEXT_TYPE + COMMA_SEP +
                    DatabaseColumns.UserColumn.COLUMN_USER_NAME + TEXT_TYPE + COMMA_SEP +
                    DatabaseColumns.UserColumn.COLUMN_USER_AGE + INTEGER_TYPE + COMMA_SEP +
                    DatabaseColumns.UserColumn.COLUMN_USER_SEX + TEXT_TYPE + COMMA_SEP +
                    DatabaseColumns.UserColumn.COLUMN_USER_MAIL + TEXT_TYPE +
                    " )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}
