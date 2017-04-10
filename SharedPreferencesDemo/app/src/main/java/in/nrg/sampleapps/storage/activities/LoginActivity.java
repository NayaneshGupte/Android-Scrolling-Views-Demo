package in.nrg.sampleapps.storage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import in.nrg.sampleapps.storage.R;
import in.nrg.sampleapps.storage.preferences.SharedPreferenceManager;
import in.nrg.sampleapps.storage.tasks.UserLoginTask;
import in.nrg.sampleapps.storage.utils.LoginListener;

import static in.nrg.sampleapps.storage.preferences.SharedPreferenceConstants.KEY_SHARED_LOGIN;
import static in.nrg.sampleapps.storage.utils.ValidationUtils.isEmailValid;
import static in.nrg.sampleapps.storage.utils.ValidationUtils.isPasswordValid;

/**
 * A login screen that offers login via email/password.
 * <p>
 * Select Login Activity template while creating new activity from Android Studio
 *
 * @author Nayanesh Gupte
 */
public class LoginActivity extends AppCompatActivity implements
        OnClickListener,
        TextView.OnEditorActionListener,
        LoginListener {

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(this);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(this);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);


        // Check for a valid password, if the user entered one.
        if (!isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            mPasswordView.requestFocus();
            return;
        }

        if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            mEmailView.requestFocus();
            return;
        }

        // Show a progress spinner, and kick off a background task to
        // perform the user login attempt.
        showProgress(true);
        mAuthTask = new UserLoginTask(email, password);
        mAuthTask.setLoginListener(this);
        mAuthTask.execute((Void) null);
    }


    /**
     * Shows the progress UI and hides the login form.
     */

    private void showProgress(final boolean show) {
        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.email_sign_in_button) {
            attemptLogin();
        }
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == R.id.login || actionId == EditorInfo.IME_NULL) {
            attemptLogin();
            return true;
        }
        return false;
    }

    @Override
    public void onLoginSuccess() {
        showProgress(false);
        mAuthTask = null;

        //store login successful in shared preferences
        SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(this);
        sharedPreferenceManager.addValue(KEY_SHARED_LOGIN, true);

        //start next screen and kill home screen
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailure() {
        showProgress(false);
        mPasswordView.setError(getString(R.string.error_incorrect_password));
        mPasswordView.requestFocus();
        mAuthTask = null;
    }

    @Override
    public void onCancelled() {
        mAuthTask = null;
        showProgress(false);
    }
}

