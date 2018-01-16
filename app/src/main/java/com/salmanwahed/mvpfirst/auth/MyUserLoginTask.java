package com.salmanwahed.mvpfirst.auth;

import android.os.AsyncTask;

/**
 * Created by salman on 1/7/18.
 */

public class MyUserLoginTask extends AsyncTask<Void, Void, Boolean> {

    private String mEmail;
    private String mPassword;
    private LoginContract.View mView;

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };


    MyUserLoginTask(String email, String password, LoginContract.View view) {
        mEmail = email;
        mPassword = password;
        mView = view;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return false;
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(mEmail)) {
                // Account exists, return true if the password matches.
                return pieces[1].equals(mPassword);
            }
        }

        // TODO: register the new account here.
        return true;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        mView.setProgressIndicator(false);
        if (success) {
            mView.showLoginSuccessMsg();
        } else {
            mView.showLoginErrorMsg();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        mView.setProgressIndicator(false);
    }
}
