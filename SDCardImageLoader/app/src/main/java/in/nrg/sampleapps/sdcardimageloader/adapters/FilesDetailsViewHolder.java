package in.nrg.sampleapps.sdcardimageloader.adapters;

import android.content.Context;
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

    void bindData(FileDetails fileDetails) {

        Picasso.with(context)
                .load(fileDetails.getFileUri())
                .centerCrop()
                .into(imgvGalleryImage);
    }
}
