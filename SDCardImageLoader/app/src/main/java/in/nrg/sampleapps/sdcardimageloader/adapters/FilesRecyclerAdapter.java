package in.nrg.sampleapps.sdcardimageloader.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.nrg.sampleapps.sdcardimageloader.R;
import in.nrg.sampleapps.sdcardimageloader.model.FileDetails;
import in.nrg.sampleapps.sdcardimageloader.utils.OnRecycleViewItemClickListener;

import static in.nrg.sampleapps.sdcardimageloader.utils.AppConstants.KEY_FILE;
import static in.nrg.sampleapps.sdcardimageloader.utils.AppConstants.KEY_POSITION;


/**
 * RecyclerView Adapter
 *
 * @author Nayanesh Gupte
 */
public class FilesRecyclerAdapter extends RecyclerView.Adapter<FilesDetailsViewHolder> {

    private LayoutInflater inflater;

    private ArrayList<FileDetails> fileDetailsArrayList;

    private OnRecycleViewItemClickListener onRecycleViewItemClickListener;

    public FilesRecyclerAdapter(Context context) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fileDetailsArrayList = new ArrayList<>();
    }

    public void setOnRecycleViewItemClickListener(OnRecycleViewItemClickListener onRecycleViewItemClickListener) {
        this.onRecycleViewItemClickListener = onRecycleViewItemClickListener;
    }

    public void setData(ArrayList<FileDetails> listStudent) {
        this.fileDetailsArrayList.addAll(listStudent);
        notifyDataSetChanged();
    }

    public void addData(FileDetails Student) {
        this.fileDetailsArrayList.add(Student);
        notifyItemInserted(this.fileDetailsArrayList.size());
    }

    @Override
    public FilesDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_gallery, parent, false);
        return new FilesDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilesDetailsViewHolder holder, final int position) {
        final FileDetails fileDetails = fileDetailsArrayList.get(position);

        //bind data to view holder
        holder.bindData(fileDetails);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onRecycleViewItemClickListener) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(KEY_POSITION, position);
                    bundle.putParcelable(KEY_FILE, fileDetails);

                    onRecycleViewItemClickListener.onItemClicked(bundle);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fileDetailsArrayList.size();
    }
}
