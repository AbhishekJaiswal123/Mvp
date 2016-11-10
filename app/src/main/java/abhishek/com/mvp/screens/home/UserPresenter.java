package abhishek.com.mvp.screens.home;

import java.util.List;

import abhishek.com.mvp.data.DataSource;
import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 10/11/16.
 */

public class UserPresenter implements UserContract.Presenter{


    private final UserContract.View mView;
    private DataSource mDataRepository;


    UserPresenter(UserContract.View pView, DataSource pDataRepository){
        mView = pView;
        mDataRepository = pDataRepository;
        mView.setPresenter(this);

    }


    @Override
    public void loadData() {
        mDataRepository.getUser(new DataSource.LoadTasksCallback() {
            @Override
            public void onTasksLoaded(List<UserModel> users) {
                mView.showUsers(users);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

    }

    @Override
    public void start() {
        loadData();
    }
}
