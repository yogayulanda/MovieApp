package com.yoga.movieapp.View.Dialog;

import android.app.ProgressDialog;
import android.content.Context;

public class ViewDialog {
    public static ProgressDialog ProgressDialog(Context context,String pesan){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setMessage(pesan);
        dialog.show();
        return dialog;
    }
}
