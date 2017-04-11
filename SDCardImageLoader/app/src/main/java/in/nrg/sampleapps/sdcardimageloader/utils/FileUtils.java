package in.nrg.sampleapps.sdcardimageloader.utils;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import in.nrg.sampleapps.sdcardimageloader.model.FileDetails;

/**
 * File operations utility
 *
 * @author Nayanesh Gupte
 */

public class FileUtils {

    private static final String LOG_TAG = "FileUtils";

    /**
     * @param dir dir or dor path inside externalStorage
     * @return list of all images inside directory
     */
    public static ArrayList<FileDetails> getAllImagesFromDir(String dir) {

        ArrayList<FileDetails> fileDetailsArrayList = new ArrayList<>();

        String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/" + dir + "/";

        File directory = new File(path);
        if (!directory.exists()) {
            Log.d(LOG_TAG, "Directory doesn't exist");
            return fileDetailsArrayList;
        }
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
            FileDetails fileDetails = new FileDetails();
            fileDetails.setFileName(files[i].getName());
            fileDetails.setFilePath(files[i].getAbsolutePath());
            fileDetails.setFileUri(Uri.fromFile(files[i]));
            fileDetailsArrayList.add(fileDetails);

            Log.d(LOG_TAG, "FileName: " + fileDetails);
        }

        return fileDetailsArrayList;
    }
}
