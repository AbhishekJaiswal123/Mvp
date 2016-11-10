package abhishek.com.mvp.data;

import android.support.annotation.NonNull;

import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 10/11/16.
 */

public class DataRepository implements DataSource {

    private DataSource mLocalDatasource;
    private DataRepository mInstance = null;

    public DataRepository(DataSource localDataSource){
        mLocalDatasource = localDataSource;
    }

    public DataRepository getInstance(DataSource localDataSource){
        if(mInstance == null){
            mInstance = new DataRepository(localDataSource);
        }
        return mInstance;
    }


    @Override
    public void getUser(@NonNull LoadTasksCallback callback) {

    }

    @Override
    public void saveUser(UserModel model) {

    }
}
