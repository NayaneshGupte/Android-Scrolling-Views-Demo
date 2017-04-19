package in.nrg.sampleapps.scrollingviews.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.nrg.sampleapps.scrollingviews.R;
import in.nrg.sampleapps.scrollingviews.model.Model;


/**
 * Adapter with multiple viewTypes. This adapter creates different view holders depending on different viewType
 *
 * @author Nayanesh Gupte
 */
public class MultiViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Model> modelArrayList;
    private Context mContext;
    private MediaPlayer mPlayer;
    private boolean fabStateVolume = false;

    public MultiViewTypeAdapter(Context context) {
        this.modelArrayList = new ArrayList<>();
        this.mContext = context;
    }

    public void setData(ArrayList<Model> modelArrayList) {
        this.modelArrayList.addAll(modelArrayList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Model.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type_text, parent, false);
                return new TextTypeViewHolder(view);
            case Model.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type_image, parent, false);
                return new ImageTypeViewHolder(view);
            case Model.AUDIO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type_audio, parent, false);
                return new AudioTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (modelArrayList.get(position).getType()) {
            case 0:
                return Model.TEXT_TYPE;
            case 1:
                return Model.IMAGE_TYPE;
            case 2:
                return Model.AUDIO_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        Model model = modelArrayList.get(listPosition);
        if (model != null) {
            switch (model.getType()) {
                case Model.TEXT_TYPE: {
                    TextTypeViewHolder textTypeViewHolder = (TextTypeViewHolder) holder;
                    textTypeViewHolder.bindData(model);
                }
                break;
                case Model.IMAGE_TYPE: {
                    ImageTypeViewHolder imageTypeViewHolder = (ImageTypeViewHolder) holder;
                    imageTypeViewHolder.bindData(model);
                }
                break;
                case Model.AUDIO_TYPE: {

                    AudioTypeViewHolder audioTypeViewHolder = (AudioTypeViewHolder) holder;
                    audioTypeViewHolder.bindData(model);

                    ((AudioTypeViewHolder) holder).fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (fabStateVolume) {
                                if (mPlayer.isPlaying()) {
                                    mPlayer.stop();
                                }
                                ((AudioTypeViewHolder) holder).fab.setImageResource(R.drawable.volume);
                                fabStateVolume = false;

                            } else {
                                mPlayer = MediaPlayer.create(mContext, R.raw.sound);
                                mPlayer.setLooping(true);
                                mPlayer.start();
                                ((AudioTypeViewHolder) holder).fab.setImageResource(R.drawable.mute);
                                fabStateVolume = true;
                            }
                        }
                    });
                }
                break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
