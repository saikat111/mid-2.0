package com.codingburg.covid19.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingburg.covid19.R;
import com.codingburg.covid19.ActivityAll.MovieDetails;
import com.codingburg.covid19.ModelData.Video;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ProductViewHolder> {
    private final Context mCtx;
    private final List<Video> productList;

    public VideoAdapter(Context mCtx, List<Video> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public VideoAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.video, null);
        return new VideoAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoAdapter.ProductViewHolder holder, int position) {
        Video movieData = productList.get(position);

        //loading the image
        holder.name.setText(movieData.getType() + ":");

       holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = movieData.getKey();
                youTubePlayer.loadVideo(videoId, 0);

            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        YouTubePlayerView youTubePlayerView;
        TextView name;

        public ProductViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            youTubePlayerView =itemView.findViewById(R.id.youtube_player_view);
          /* getLifecycle().addObserver(youTubePlayerView);*/
            ((MovieDetails) mCtx).addLifeCycleCallBack(youTubePlayerView);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
