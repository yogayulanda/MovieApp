package com.yoga.movieapp.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bagas.moviedb.Model.DataMovie;
import com.bagas.moviedb.R;
import com.bagas.moviedb.View.DetailActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.MovieHolder> {

    Context context;
    List<DataMovie> mList;

    public AdapterMovie(Context context, List<DataMovie> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_film, parent, false);
        MovieHolder holder = new MovieHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        DataMovie movie = mList.get(position);
        holder.mJudul.setText(movie.getJudul());
        holder.mWaktu.setText(movie.getWaktu());
        holder.mDeskripsi.setText(movie.getDeskripsi());
        holder.mRating.setText(movie.getRating());
        holder.mVote.setText(movie.getVote());
        holder.mData = movie;
        Glide.with(context)
                .load(movie.getPoster())
                .into(holder.mPoster);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        TextView mJudul, mDeskripsi, mRating, mVote, mWaktu;
        ImageView mPoster;
        DataMovie mData;

        public MovieHolder(@NonNull View v) {
            super(v);
            mJudul = v.findViewById(R.id.tvjudul);
            mDeskripsi = v.findViewById(R.id.tvdeskripsi);
            mRating = v.findViewById(R.id.tvrating);
            mVote = v.findViewById(R.id.tvvote);
            mWaktu = v.findViewById(R.id.tvwaktu);
            mPoster = v.findViewById(R.id.imgposter);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("judul",mData.getJudul());
                    intent.putExtra("deskripsi",mData.getDeskripsi());
                    intent.putExtra("rating", mData.getRating());
                    intent.putExtra("vote",mData.getVote());
                    intent.putExtra("waktu", mData.getWaktu());
                    intent.putExtra("poster",mData.getPoster());
                    context.startActivity(intent);
                }
            });
        }
    }
}
