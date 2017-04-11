package in.nrg.sampleapps.sdcardimageloader.utils;

import java.util.ArrayList;

import in.nrg.sampleapps.sdcardimageloader.model.FileDetails;

/**
 * Provides callback once reading data from storage is over
 *
 * @author Nayanesh Gupte
 */

public interface FilesDataListener {

    void onFilesLoaded(ArrayList<FileDetails> fileDetailsArrayList);

    void onFilesLoadingFailed();

    void onFilesLoadingCancelled();
}
