package in.nrg.sampleapps.scrollingviews.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.model.Model;

/**
 * ViewHolder representing card with Audio
 *
 * @author Nayanesh Gupte
 */
public class AudioTypeViewHolder extends RecyclerView.ViewHolder {

    private TextView txtType;
    FloatingActionButton fab;

    public AudioTypeViewHolder(View itemView) {
        super(itemView);

        this.txtType = (TextView) itemView.findViewById(R.id.txtvType);
        this.fab = (FloatingActionButton) itemView.findViewById(R.id.fab);
    }

    void bindData(Model model) {
        txtType.setText(model.getText());
    }
}