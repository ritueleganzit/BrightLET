package com.eleganzit.brightlet.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


/**
 * Created by mahadev on 6/23/16.
 */
public class AppDialogs {

    Context mContext;
    ProgressDialog pDialog;

    public AppDialogs(Context mContext) {
        this.mContext = mContext;
    }

    public void showProgressDialog() {
        if (mContext != null) {
            if (pDialog == null) {
                pDialog = new ProgressDialog(mContext);
            }
            pDialog.setMessage("Please Wait");
            pDialog.setCancelable(false);
            pDialog.show();
        }

    }

    public void hideProgressDialog() {
        if (mContext != null) {
            if ((pDialog != null) && (pDialog.isShowing()) ) {
                pDialog.dismiss();
                pDialog = null;
            }
        }
    }

    public void setSuccessToast(String messgae) {

        Toast.makeText(mContext, messgae, Toast.LENGTH_LONG);
    }

    public void setErrorToast(String messgae) {

        Toast.makeText(mContext, messgae, Toast.LENGTH_LONG);
    }

    public boolean isNetworkAvailable(Context context) {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void showNetworkDialog(final Activity activity) {
        if(!(activity).isFinishing()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    mContext);
            alertDialogBuilder
                    .setMessage("Please network connection")
                    .setCancelable(false)
                    .setPositiveButton("OK"
                            , new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


    public void showExitDialog(final Activity activity) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);

        // set title
        // alertDialogBuilder.setTitle("Your Title");

        // set dialog message
        alertDialogBuilder
                .setMessage("Are you sure want  to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                     // Intent i=new Intent(activity, DashboardActivity.class);
                       // activity.startActivity(i);
                       // activity.finish();
                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory( Intent.CATEGORY_HOME );
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(homeIntent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


}
