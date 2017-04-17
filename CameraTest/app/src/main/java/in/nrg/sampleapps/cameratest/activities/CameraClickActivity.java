package in.nrg.sampleapps.cameratest.activities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import in.nrg.sampleapps.cameratest.R;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static in.nrg.sampleapps.cameratest.utils.PermissionUtils.hasPermission;

/**
 * Capture Image using default camera apps and store it in desired dir.
 * <p>
 * Display captured image in ImageView and allow it to open through external gallery apps.
 *
 * @author Nayanesh Gupte
 */
public class CameraClickActivity extends AppCompatActivity implements View.OnClickListener {

    //----------------------------------------------------------------------------------------------
    //Constants
    //----------------------------------------------------------------------------------------------
    private static final int REQUEST_READ_STORAGE = 1;
    private static final int REQUEST_WRITE_STORAGE = 2;
    private final static int ALL_PERMISSION_RESULT = 107;

    private static final int REQUEST_CAMERA = 123;

    private static final String IMAGE_NAME = "CAMERA_CLICK_";

    //----------------------------------------------------------------------------------------------
    //Views
    //----------------------------------------------------------------------------------------------
    /**
     * Imageview to show captured image
     */
    private ImageView imgvCameraOutput;
    private FloatingActionButton fab;

    //----------------------------------------------------------------------------------------------
    //Other Fields
    //----------------------------------------------------------------------------------------------
    /**
     * Expected output image path
     */
    private File output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_click);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgvCameraOutput = (ImageView) findViewById(R.id.imgvCameraOutput);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        /**
         * To display captured image storage permissions is required.
         */
        mayRequestPermission();
    }

    //----------------------------------------------------------------------------------------------
    //Permissions handling
    //----------------------------------------------------------------------------------------------

    /**
     * Runtime  Permissions are only applicable for Android M and above
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    private boolean mayRequestPermission() {

        //if permission is already granted then skip
        if (hasPermission(this, WRITE_EXTERNAL_STORAGE) && hasPermission(this, READ_EXTERNAL_STORAGE)) {
            return true;
        }
        /**
         * Gets whether you should show UI with rationale for requesting a permission.
         * You should do this only if you do not have the permission and the context in
         * which the permission is requested does not clearly communicate to the user
         * what would be the benefit from granting this permission.
         * <p>
         * For example, if you write a camera app, requesting the camera permission
         * would be expected by the user and no rationale for why it is requested is
         * needed. If however, the app needs location for tagging photos then a non-tech
         * savvy user may wonder how location is related to taking photos. In this case
         * you may choose to show UI with rationale of requesting this permission.
         * </p>
         * */
        if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
            Snackbar.make(fab, R.string.permission_storage_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_STORAGE);
                        }
                    });
        } else if (shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE)) {
            Snackbar.make(fab, R.string.permission_storage_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{READ_EXTERNAL_STORAGE}, REQUEST_READ_STORAGE);
                        }
                    });
        } else {
            requestPermissions(new String[]{
                    WRITE_EXTERNAL_STORAGE,
                    READ_EXTERNAL_STORAGE}, ALL_PERMISSION_RESULT);
        }
        return false;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_WRITE_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, R.string.write_permission_granted, Toast.LENGTH_SHORT).show();
            }
            //permission denied : Try asking again with appropriate message
            else if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
                Snackbar.make(fab, R.string.permission_storage_rationale, Snackbar.LENGTH_INDEFINITE)
                        .setAction(android.R.string.ok, new View.OnClickListener() {
                            @Override
                            @TargetApi(Build.VERSION_CODES.M)
                            public void onClick(View v) {
                                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_STORAGE);
                            }
                        });

            }
        } else if (requestCode == REQUEST_READ_STORAGE) {
            if (grantResults.length > 0 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, R.string.read_permission_granted, Toast.LENGTH_SHORT).show();

            }
            //permission denied : Try asking again with appropriate message
            else if (shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE)) {

                Snackbar.make(fab, R.string.permission_storage_rationale, Snackbar.LENGTH_INDEFINITE)
                        .setAction(android.R.string.ok, new View.OnClickListener() {
                            @Override
                            @TargetApi(Build.VERSION_CODES.M)
                            public void onClick(View v) {
                                requestPermissions(new String[]{READ_EXTERNAL_STORAGE}, REQUEST_READ_STORAGE);
                            }
                        });
            }
        } else if (requestCode == ALL_PERMISSION_RESULT) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, R.string.both_permission_granted, Toast.LENGTH_SHORT).show();
            } else {

                Snackbar.make(fab, R.string.permission_storage_rationale, Snackbar.LENGTH_INDEFINITE)
                        .setAction(android.R.string.ok, new View.OnClickListener() {
                            @Override
                            @TargetApi(Build.VERSION_CODES.M)
                            public void onClick(View v) {
                                requestPermissions(new String[]{
                                        WRITE_EXTERNAL_STORAGE,
                                        READ_EXTERNAL_STORAGE}, ALL_PERMISSION_RESULT);
                            }
                        });
            }
        }
    }

    //----------------------------------------------------------------------------------------------
    //onCLick handling
    //----------------------------------------------------------------------------------------------
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
            startCamera();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {

            imgvCameraOutput.setImageURI(Uri.fromFile(output));

            openImageInGallery();
        }
    }

    /**
     * Start camera app
     */
    @SuppressLint("DefaultLocale")
    private void startCamera() {
        //implicit intent to capture image
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //External public dir for storing images
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        //append timestamp to image name to avoid overwriting of previous images.
        output = new File(dir, String.format("%s%d.JPEG", IMAGE_NAME, System.currentTimeMillis()));

        //specify output location in form of Uri
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));

        //using Intent.createChooser is mandatory if Target API version is 24 or above.
        startActivityForResult(Intent.createChooser(cameraIntent, getString(R.string.capture_image)), REQUEST_CAMERA);
    }


    /**
     * Image can be viewed in external gallery apps
     */
    private void openImageInGallery() {
        //Implicit intent to view image.
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //specify image (data) and mimeType of image.
        intent.setDataAndType(Uri.fromFile(output), "image/jpeg");
        startActivity(Intent.createChooser(intent, getString(R.string.view_image)));
    }
}
