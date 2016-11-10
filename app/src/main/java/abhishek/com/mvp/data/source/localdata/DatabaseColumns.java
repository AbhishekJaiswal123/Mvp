package abhishek.com.mvp.data.source.localdata;

import android.provider.BaseColumns;

/**
 * Created by abhishek on 10/11/16.
 */

public final class DatabaseColumns {

    private DatabaseColumns(){}

    public static abstract class UserColumn implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_USER_SEX = "user_sex";
        public static final String COLUMN_USER_AGE = "user_age";
        public static final String COLUMN_USER_MAIL = "user_mail";

    }
}
