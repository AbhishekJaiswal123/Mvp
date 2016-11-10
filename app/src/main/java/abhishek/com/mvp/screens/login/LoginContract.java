package abhishek.com.mvp.screens.login;

import android.content.Intent;

import abhishek.com.mvp.base.BasePresenter;
import abhishek.com.mvp.base.BaseView;

/**
 * Created by abhishek on 9/11/16.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void showMessage(String msg);
        void initGoogleClient();
        void loginUser();
        void onLoginSuccess(String name);

    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode, Intent data);
        void initLogin();
        void login();

    }
}
