package in.nrg.sampleapps.scrollingviews.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.model.Model;

/**
 * ViewHolder representing card with only text
 *
 * @author Nayanesh Gupte
 */
public class TextTypeViewHolder extends RecyclerView.ViewHolder {

    private TextView txtType;
    private CardView cardView;

    public TextTypeViewHolder(View itemView) {
        super(itemView);

        this.txtType = (TextView) itemView.findViewById(R.id.txtvType);
        this.cardView = (CardView) itemView.findViewById(R.id.card_view);
    }

    void bindData(Model model) {
        txtType.setText(model.getText());
    }
}