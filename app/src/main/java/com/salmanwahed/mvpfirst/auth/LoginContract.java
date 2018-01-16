package com.salmanwahed.mvpfirst.auth;

import com.salmanwahed.mvpfirst.BasePresenter;
import com.salmanwahed.mvpfirst.BaseView;

/**
 * Created by salman on 12/27/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void setProgressIndicator(boolean active);
        void showLoginErrorMsg();
        void showLoginSuccessMsg();
        void resetErrorMsg();
        boolean showEmailValidation(String email);
        boolean showPasswordValidation(String password);
    }

    interface Presenter extends BasePresenter {
        void attemptLogin(String email, String password);
    }
}
