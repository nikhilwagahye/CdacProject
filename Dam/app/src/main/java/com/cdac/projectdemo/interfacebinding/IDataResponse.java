package com.cdac.projectdemo.interfacebinding;

import com.cdac.projectdemo.model.BookTest;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by nikhilkumar.waghaye on 21-01-2018.
 */

public interface IDataResponse {

    public void responseHandle(JSONArray array);
}
