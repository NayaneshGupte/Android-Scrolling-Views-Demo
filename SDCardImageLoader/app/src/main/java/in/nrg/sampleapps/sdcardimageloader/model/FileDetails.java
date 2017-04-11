package in.nrg.sampleapps.sdcardimageloader.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Nayanesh Gupte
 */

public class FileDetails implements Parcelable {

    private String fileName;

    private String filePath;

    private Uri fileUri;

    public FileDetails() {
    }

    protected FileDetails(Parcel in) {
        fileName = in.readString();
        filePath = in.readString();
        fileUri = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fileName);
        dest.writeString(filePath);
        dest.writeParcelable(fileUri, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FileDetails> CREATOR = new Creator<FileDetails>() {
        @Override
        public FileDetails createFromParcel(Parcel in) {
            return new FileDetails(in);
        }

        @Override
        public FileDetails[] newArray(int size) {
            return new FileDetails[size];
        }
    };

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Uri getFileUri() {
        return fileUri;
    }

    public void setFileUri(Uri fileUri) {
        this.fileUri = fileUri;
    }

    @Override
    public String toString() {
        return "FileDetails{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileUri=" + fileUri +
                '}';
    }
}
