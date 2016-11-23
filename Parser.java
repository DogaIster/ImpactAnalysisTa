package com.soti.jira.Parser;

/**
 * Created by dister on 11/9/2016.
 */

import com.google.gson.Gson;

public class Parser {

    public Changeset parseChangeset(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Changeset.class);
    }

    public Changesets parseChangesets(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Changesets.class);
    }
}


