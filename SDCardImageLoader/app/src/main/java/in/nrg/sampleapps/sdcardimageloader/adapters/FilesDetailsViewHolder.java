package in.nrg.sampleapps.sdcardimageloader.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import in.nrg.sampleapps.sdcardimageloader.R;
import in.nrg.sampleapps.sdcardimageloader.model.FileDetails;

/**
 * ViewHolder to hold reference of individual item in RecyclerView
 *
 * @author Nayanesh Gupte
 */

public class FilesDetailsViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgvGalleryImage;
    private Context context;

    public FilesDetailsViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        imgvGalleryImage = (ImageView) itemView.findViewById(R.id.imgvGalleryImage);
    }

    /**
     * Picasso is open source Image Loading Library. It loads images asynchronously
     * <p>
     * see {@link <a href="http://square.github.io/picasso/">Picasso</a>}.
     */
    void bindData(FileDetails fileDetails) {

        Resources resources = context.getResources();
        int targetWidth = resources.getDimensionPixelSize(R.dimen.column_width);
        int targetHeight = resources.getDimensionPixelSize(R.dimen.column_width);

        Picasso.with(context)
                .load(fileDetails.getFileUri())//pass Uri of image to be loaded
                .centerCrop()//Image can be any size , so crop it
                .resize(targetWidth, targetHeight) // resize is mandatory for centerCrop
                .placeholder(R.mipmap.ic_launcher_round)// placeholder before loading images
                .error(R.mipmap.ic_launcher_round) // Image to be displayed in case of error
                .into(imgvGalleryImage);// ImageView in which image is expected to be loaded.
    }
}
