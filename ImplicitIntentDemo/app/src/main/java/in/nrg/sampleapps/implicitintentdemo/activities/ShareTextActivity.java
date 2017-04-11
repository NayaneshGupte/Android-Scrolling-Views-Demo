package in.nrg.sampleapps.implicitintentdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import in.nrg.sampleapps.implicitintentdemo.R;
import in.nrg.sampleapps.implicitintentdemo.utils.ShareUtils;

public class ShareTextActivity extends AppCompatActivity {

    private EditText edtTxtShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_text);

        edtTxtShare = (EditText) findViewById(R.id.edtTxtShare);
    }


    /**
     * Read text from editText and share on click of the button
     *
     * @param view mapped in xml
     */
    public void shareText(View view) {
        String shareText = edtTxtShare.getText().toString().trim();

        //validate text. Share if it's not empty before sharing
        if (TextUtils.isEmpty(shareText)) {
            edtTxtShare.setError(getString(R.string.empty_text_error_message));
            edtTxtShare.requestFocus();
            return;
        }

        ShareUtils.shareText(this, shareText);
    }
}
