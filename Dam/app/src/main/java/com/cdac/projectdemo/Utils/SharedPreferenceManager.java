package com.cdac.projectdemo.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.cdac.projectdemo.model.User;
import com.google.gson.Gson;

/**
 * Manages the shared preferences all over the application
 */
public class SharedPreferenceManager {
    private static Context applicationContext;
    private static SharedPreferences bookSellingPreferences;
    public static void setApplicationContext(Context context) {
        applicationContext = context;
        setPreferences();
    }

    private static void setPreferences() {
        if (bookSellingPreferences == null) {
            bookSellingPreferences = applicationContext.getSharedPreferences("booksellingapp",
                    Context.MODE_PRIVATE);
        }
    }

    public static void clearPreferences() {
        bookSellingPreferences.edit().clear().commit();
    }


    public static void saveUserId(String userId) {
        SharedPreferences.Editor prefsEditor = bookSellingPreferences.edit();
        prefsEditor.putString("USERID", userId);
        Log.e("SavedUserId:", userId);
        prefsEditor.commit();
    }

    public static String getUserId() {
        String userId = bookSellingPreferences.getString("USERID", null);
        //Log.e("RetrivedUserId:", userId);
        return userId;
    }


    public static void storeUserObjectInSharedPreference(User user) {
        SharedPreferences.Editor prefsEditor = bookSellingPreferences.edit();
      //  prefsEditor.clear();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString("UserObject", json);
        prefsEditor.commit();
    }

    public static User getUserObjectFromSharedPreference() {
        Gson gson1 = new Gson();
        String json1 = bookSellingPreferences.getString("UserObject", "");
        User obj = gson1.fromJson(json1, User.class);
//		Log.e("RetrivedName:", obj.getFirstName());
        return obj;
    }


}
