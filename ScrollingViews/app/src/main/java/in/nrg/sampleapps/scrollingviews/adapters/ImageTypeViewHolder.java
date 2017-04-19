package in.nrg.sampleapps.scrollingviews.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.model.Model;

/**
 * ViewHolder representing Image and Text in card
 *
 * @author Nayanesh Gupte
 */
public class ImageTypeViewHolder extends RecyclerView.ViewHolder {

    private TextView txtType;
    private ImageView imgvBackground;

    public ImageTypeViewHolder(View itemView) {
        super(itemView);

        this.txtType = (TextView) itemView.findViewById(R.id.txtvType);
        this.imgvBackground = (ImageView) itemView.findViewById(R.id.imgvBackground);
    }

    void bindData(Model model) {
        txtType.setText(model.getText());
        imgvBackground.setImageResource(model.getData());
    }
}