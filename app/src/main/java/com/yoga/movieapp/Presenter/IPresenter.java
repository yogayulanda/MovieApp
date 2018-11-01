package com.yoga.movieapp.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

public interface IPresenter {
    void getMovie(Context context, RecyclerView recyclerView);
}
