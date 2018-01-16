package com.salmanwahed.mvpfirst.auth;

/**
 * Created by salman on 12/27/17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mLoginView;

    public LoginPresenter(LoginContract.View view){
        mLoginView = view;
        mLoginView.setPresenter(this);
    }

    @Override
    public void attemptLogin(String email, String password) {
        // Reset errors.
        mLoginView.resetErrorMsg();

        // Check for a valid email address.
        if (mLoginView.showEmailValidation(email)){
            // Check for a valid password, if the user entered one.
            if (mLoginView.showPasswordValidation(password)){
                mLoginView.setProgressIndicator(true);
                new MyUserLoginTask(email, password, mLoginView).execute();
            }
        }

    }

    @Override
    public void start() {
        //TODO: Impliment method
    }
}
