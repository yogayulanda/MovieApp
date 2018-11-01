package com.yoga.movieapp.Presenter;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bagas.moviedb.API.API;
import com.bagas.moviedb.Model.DataMovie;
import com.bagas.moviedb.View.Adapter.AdapterMovie;
import com.bagas.moviedb.View.Dialog.ViewDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class Presenter implements IPresenter {
    @Override
    public void getMovie(final Context context, final RecyclerView recyclerView) {
        final List<DataMovie> mList;
        mList = new ArrayList<DataMovie>();
        final DataMovie dataMovie = new DataMovie();
        final ProgressDialog dialog = ViewDialog.ProgressDialog(context, "Mohon tunggu sebentar.....");


        AndroidNetworking.get(API.URL_POPULAR)
                .addQueryParameter("api_key", API.API_KEY)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        try {
                            JSONArray array = response.getJSONArray("results");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                mList.add(new DataMovie(
                                        object.optString("title"),
                                        object.optString("overview"),
                                        object.optString("vote_average"),
                                        object.optString("vote_count"),
                                        object.optString("release_date"),
                                        API.URL_GAMBAR + object.optString("poster_path")
                                ));
                                Log.d(TAG, "Gambar : " +dataMovie.getPoster() );
                            }
                            AdapterMovie adapter = new AdapterMovie(context,mList);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            dialog.dismiss();
                            Toast.makeText(context, "galat " + e, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        Toast.makeText(context, "galat " + anError, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
