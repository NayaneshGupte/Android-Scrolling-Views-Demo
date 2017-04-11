package in.nrg.sampleapps.implicitintentdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import in.nrg.sampleapps.implicitintentdemo.R;

/**
 * This activity appears as one of the options while share text
 * using {@link ShareTextActivity#shareText(View)}
 * <p>
 * Check  AndroidManifest.xml for IntentFilter options
 *
 * @author Nayanesh Gupte
 */
public class ShareIntentFilterActivity extends AppCompatActivity {

    private EditText edtTxtEmails;
    private EditText edtTxtSubject;
    private EditText edtTxtShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_intent_filter);

        edtTxtEmails = (EditText) findViewById(R.id.edtTxtEmails);
        edtTxtSubject = (EditText) findViewById(R.id.edtTxtSubject);
        edtTxtShareText = (EditText) findViewById(R.id.edtTxtShareText);

        readDataFromIntent();
    }

    private void readDataFromIntent() {
        Intent intent = getIntent();
        String shareText = intent.getStringExtra(Intent.EXTRA_TEXT);
        String subject = intent.getStringExtra(Intent.EXTRA_SUBJECT);
        String[] recipientArray = intent.getStringArrayExtra(Intent.EXTRA_EMAIL);

        setData(recipientArray, subject, shareText);
    }

    private void setData(String[] to, String subject, String emailBody) {
        String toEmails = "";

        for (String str : to) {
            toEmails += str + "; ";
        }

        //Set emails
        edtTxtEmails.setText(toEmails);

        //set email subject
        edtTxtSubject.setText(subject);

        //set email body
        edtTxtShareText.setText(emailBody);
        edtTxtShareText.requestFocus();
        edtTxtShareText.setSelection(emailBody.length());
    }
}
