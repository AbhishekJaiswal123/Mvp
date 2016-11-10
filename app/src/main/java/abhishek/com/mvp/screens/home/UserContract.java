package abhishek.com.mvp.screens.home;

import java.util.List;

import abhishek.com.mvp.base.BasePresenter;
import abhishek.com.mvp.base.BaseView;
import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 10/11/16.
 */

public interface UserContract  {

    interface View extends BaseView<Presenter> {

        void showUsers(List<UserModel> users);

    }

    interface Presenter extends BasePresenter {

       void loadData();

    }
}
