package abhishek.com.mvp.screens.login;

import android.content.Intent;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import java.util.Random;

import abhishek.com.mvp.data.DataSource;
import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 9/11/16.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View mLoginView;
    private static final int RC_SIGN_IN = 1;
    private DataSource mDataRepository;


    LoginPresenter(LoginContract.View pView, DataSource pDataRepository){

       mLoginView = pView;
       mDataRepository = pDataRepository;
       mLoginView.setPresenter(this);

   }

    @Override
    public void result(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Signed in successfully, show authenticated UI.
                GoogleSignInAccount acct = result.getSignInAccount();


                UserModel model = new UserModel();
                model.setUser_age(23);
                model.setUser_mail(acct.getEmail());
                model.setUser_name(acct.getDisplayName());
                model.setUser_sex("male");
                model.setUser_Id(new Random(10).toString());
                mDataRepository.saveUser(model);

                mLoginView.onLoginSuccess(acct.getDisplayName());

            } else {
                // Signed out, show unauthenticated UI.
                mLoginView.showMessage("Login failed");

            }
        }
    }

    @Override
    public void initLogin() {
        mLoginView.initGoogleClient();
    }

    @Override
    public void login() {
       mLoginView.loginUser();
    }
    @Override
    public void start() {

    }
}
