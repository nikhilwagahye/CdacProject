package com.cdac.projectdemo.background;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.cdac.projectdemo.Utils.httpparsers.JSONParserGETRequest;
import com.cdac.projectdemo.interfacebinding.IDataResponse;

import org.json.JSONArray;

/**
 * Created by nikhilkumar.waghaye on 24-01-2018.
 */

public class BGTaskForCart extends AsyncTask<String, String, JSONArray> {
    Activity context;
    private ProgressDialog dialog;
    private String api;
    private JSONArray jsonArray;
    IDataResponse interfaceData;


    /**
     * Constructor
     */
    public BGTaskForCart(Activity context, IDataResponse interfaceData, String api) {
        this.context = context;
        this.interfaceData = interfaceData;
        this.api = api;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setMessage("Please wait");
        dialog.show();
    }


    /**
     * Calling API and Getting Response
     */
    @Override
    protected JSONArray doInBackground(String... args) {

        try {
            // for making request, we have to pass URL and json object in string format
            JSONParserGETRequest parser = new JSONParserGETRequest();
            jsonArray = parser.makeRequestForJSONArray(api);
        } catch (Exception ex) {
            Log.e("Exception Login Parse:", ex.toString());
        }
        return jsonArray;
    }

    /**
     * Handling response
     */
    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        try {
            if (dialog != null) {
                dialog.dismiss();
            }

            interfaceData.responseHandle(jsonArray);



        } catch (Exception e) {
            if (dialog != null) {
                dialog.dismiss();
            }
            e.printStackTrace();
        }
    }

}
