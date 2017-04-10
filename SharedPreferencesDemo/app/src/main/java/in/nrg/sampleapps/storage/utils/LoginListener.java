package in.nrg.sampleapps.storage.utils;

import in.nrg.sampleapps.storage.activities.LoginActivity;
import in.nrg.sampleapps.storage.tasks.UserLoginTask;

/**
 * Callback from task performing login auth.
 * Implement this callback in {@link LoginActivity} and pass it to {@link UserLoginTask}.
 *
 * @author Nayanesh Gupte
 */

public interface LoginListener {

    void onLoginSuccess();

    void onLoginFailure();

    void onCancelled();
}
