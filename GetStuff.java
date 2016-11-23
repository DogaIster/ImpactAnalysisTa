package com.soti.jira.GetStuff;
/**
 * Created by dister on 11/1/2016.
*/

import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.HttpResponse;

public class GetStuff {

    public String loginDev(String impactAnalysis) {
        BasicHttpClient httpClient = new BasicHttpClient("http://cad106:8080/tfs/DefaultCollection");
        httpClient.setConnectionTimeout(6000);
        HttpResponse httpResponse = httpClient.get("/_apis/tfvc/changesets?api-version=1.0", null);
        System.out.println(httpResponse.getBodyAsString());
        return httpResponse.getBodyAsString();
    }

    // To log in to App Engine production app with an auth token - Remove if it is not used.
    /*public void loginProd(String authToken) {
        BasicHttpClient httpClient = new BasicHttpClient("http://cad106:8080/tfs/DefaultCollection");
        ParameterMap params = httpClient.newParams()
                .add("auth", authToken);
    }*/
}



