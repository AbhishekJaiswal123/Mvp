package abhishek.com.mvp.data;

import android.support.annotation.NonNull;

import java.util.List;

import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 10/11/16.
 */

public interface DataSource {

    interface LoadTasksCallback {

        void onTasksLoaded(List<UserModel> users);

        void onDataNotAvailable();
    }

    void getUser(@NonNull LoadTasksCallback callback);
    void saveUser(UserModel model);

}
