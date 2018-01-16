package com.salmanwahed.mvpfirst.auth;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by salman on 1/8/18.
 */

public class LoginPresenterTest {

    @Mock
    private LoginContract.View mLoginView;

    private LoginPresenter mPresenter;

    @Before
    public void setLoginPresenter(){
        MockitoAnnotations.initMocks(this);
        mPresenter = new LoginPresenter(mLoginView);
    }

    @Test
    public void click_LoginButton(){
        mPresenter.attemptLogin("foo@example.com", "hello");

        verify(mLoginView).resetErrorMsg();
        verify(mLoginView).showEmailValidation(any(String.class));
    }

}
