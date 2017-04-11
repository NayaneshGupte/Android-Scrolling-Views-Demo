package in.nrg.sampleapps.sdcardimageloader.manager;

import android.os.AsyncTask;

import java.util.ArrayList;

import in.nrg.sampleapps.sdcardimageloader.model.FileDetails;
import in.nrg.sampleapps.sdcardimageloader.utils.FileUtils;
import in.nrg.sampleapps.sdcardimageloader.utils.FilesDataListener;

import static in.nrg.sampleapps.sdcardimageloader.utils.AppConstants.IMAGE_DIR;

/**
 * Load files from specific folder asynchronously
 *
 * @author Nayanesh Gupte
 */

public class DataManager extends AsyncTask<Void, Void, ArrayList<FileDetails>> {


    private FilesDataListener filesDataListener;

    public DataManager(FilesDataListener filesDataListener) {
        this.filesDataListener = filesDataListener;
    }

    public void fetchFilesData() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<FileDetails> doInBackground(Void... params) {
        //TODO: Change directory according to device . Hardcoded for demo purpose
        return FileUtils.getAllImagesFromDir(IMAGE_DIR);
    }

    @Override
    protected void onPostExecute(ArrayList<FileDetails> fileDetailsArrayList) {
        super.onPostExecute(fileDetailsArrayList);

        filesDataListener.onFilesLoaded(fileDetailsArrayList);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        filesDataListener.onFilesLoadingCancelled();
    }

    @Override
    protected void onCancelled(ArrayList<FileDetails> fileDetailsArrayList) {
        super.onCancelled(fileDetailsArrayList);
        filesDataListener.onFilesLoadingCancelled();
    }
}
