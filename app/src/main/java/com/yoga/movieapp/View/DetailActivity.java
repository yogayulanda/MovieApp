package com.yoga.movieapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bagas.moviedb.R;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView mJudul,mDeskripsi,mRating,mWaktu,mVote;
    private ImageView mPoster;
    private Button mKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mPoster = findViewById(R.id.imgdetail);
        mJudul = findViewById(R.id.tv_judul);
        mDeskripsi = findViewById(R.id.tv_deskripsi);
        mRating = findViewById(R.id.tv_rating);
        mWaktu = findViewById(R.id.tv_waktu);
        mVote = findViewById(R.id.tv_vote);
        mKembali = findViewById(R.id.btn_kembali);

        Intent intent = getIntent();
        mJudul.setText(intent.getStringExtra("judul"));
        mWaktu.setText(intent.getStringExtra("waktu"));
        mRating.setText(intent.getStringExtra("rating"));
        mVote.setText(intent.getStringExtra("vote"));
        mDeskripsi.setText(intent.getStringExtra("deskripsi"));

        Glide.with(this)
                .load(intent.getStringExtra("poster"))
                .into(mPoster);

        mKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
