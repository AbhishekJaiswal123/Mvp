package abhishek.com.mvp.data.source.localdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import abhishek.com.mvp.data.DataSource;
import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 10/11/16.
 */

public class LocalDataSource implements DataSource {

    private static LocalDataSource INSTANCE;

    private DatabaseHelper mDbHelper;

    // Prevent direct instantiation.
    private LocalDataSource(@NonNull Context context) {
        mDbHelper = new DatabaseHelper(context);
    }

    public static LocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(context);
        }
        return INSTANCE;
    }


    @Override
    public void getUser(@NonNull LoadTasksCallback callback) {

        List<UserModel> users = new ArrayList<UserModel>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                DatabaseColumns.UserColumn.COLUMN_USER_ID,
                DatabaseColumns.UserColumn.COLUMN_USER_NAME,
                DatabaseColumns.UserColumn.COLUMN_USER_MAIL,
                DatabaseColumns.UserColumn.COLUMN_USER_SEX,
                DatabaseColumns.UserColumn.COLUMN_USER_AGE
        };

        Cursor c = db.query(DatabaseColumns.UserColumn.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                String userId = c.getString(c.getColumnIndexOrThrow(DatabaseColumns.UserColumn.COLUMN_USER_ID));
                String userName = c.getString(c.getColumnIndexOrThrow(DatabaseColumns.UserColumn.COLUMN_USER_NAME));
                int userAge = c.getInt(c.getColumnIndexOrThrow(DatabaseColumns.UserColumn.COLUMN_USER_AGE));
                String userSex = c.getString(c.getColumnIndexOrThrow(DatabaseColumns.UserColumn.COLUMN_USER_SEX));
                String userMail = c.getString(c.getColumnIndexOrThrow(DatabaseColumns.UserColumn.COLUMN_USER_MAIL));

                UserModel user = new UserModel();
                user.setUser_Id(userId);
                user.setUser_sex(userSex);
                user.setUser_name(userName);
                user.setUser_mail(userMail);
                user.setUser_age(userAge);

                users.add(user);
            }
        }
        if (c != null) {
            c.close();
        }

        db.close();

        if (users.isEmpty()) {
            // This will be called if the table is new or just empty.
            callback.onDataNotAvailable();
        } else {
            callback.onTasksLoaded(users);
        }
    }

    @Override
    public void saveUser(UserModel model) {

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseColumns.UserColumn.COLUMN_USER_ID, model.getUser_Id());
        values.put(DatabaseColumns.UserColumn.COLUMN_USER_NAME, model.getUser_name());
        values.put(DatabaseColumns.UserColumn.COLUMN_USER_AGE, model.getUser_age());
        values.put(DatabaseColumns.UserColumn.COLUMN_USER_MAIL, model.getUser_mail());
        values.put(DatabaseColumns.UserColumn.COLUMN_USER_SEX, model.getUser_sex());

        db.insert(DatabaseColumns.UserColumn.TABLE_NAME, null, values);
        db.close();
    }
}
