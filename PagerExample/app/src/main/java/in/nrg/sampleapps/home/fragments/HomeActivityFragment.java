package in.nrg.sampleapps.home.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.nrg.sampleapps.R;
import in.nrg.sampleapps.home.activities.HomeActivity;

import static in.nrg.sampleapps.utils.AppConstants.KEY_HOME;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {


    private HomeActivity homeActivity;

    private TextView textvMessage;

    private String message;

    public HomeActivityFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        readDataFromBundle();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textvMessage = (TextView) view.findViewById(R.id.textvMessage);

        textvMessage.setText(message);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() instanceof HomeActivity) {
            homeActivity = (HomeActivity) getActivity();
            homeActivity.isTest = false;
        }
    }

    private void readDataFromBundle() {
        Bundle bundle = getArguments();
        message = bundle.getString(KEY_HOME);
    }
}
