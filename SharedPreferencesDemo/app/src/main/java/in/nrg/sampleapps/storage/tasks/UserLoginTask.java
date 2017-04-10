package in.nrg.sampleapps.storage.tasks;

import android.os.AsyncTask;

import in.nrg.sampleapps.storage.utils.LoginListener;

import static in.nrg.sampleapps.storage.utils.AppConstants.DUMMY_CREDENTIALS;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

    private final String mEmail;
    private final String mPassword;

    private LoginListener loginListener;

    public UserLoginTask(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

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
    protected void onPostExecute(final Boolean success) {
        if (success) {
            loginListener.onLoginSuccess();
        } else {
            loginListener.onLoginFailure();
        }
    }

    @Override
    protected void onCancelled() {
        loginListener.onCancelled();
    }
}