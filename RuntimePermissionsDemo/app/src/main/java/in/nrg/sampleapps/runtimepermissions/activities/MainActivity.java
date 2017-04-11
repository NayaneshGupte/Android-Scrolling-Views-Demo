package in.nrg.sampleapps.runtimepermissions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.nrg.sampleapps.runtimepermissions.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void storagePermissionDemo(View view) {
        Intent intent = new Intent(this, StoragePermissionsActivity.class);
        startActivity(intent);
    }
}
