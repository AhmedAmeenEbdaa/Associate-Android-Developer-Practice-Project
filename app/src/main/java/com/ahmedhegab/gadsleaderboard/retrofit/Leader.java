package com.ahmedhegab.gadsleaderboard.retrofit;

import com.google.gson.annotations.SerializedName;

public class Leader {
    @SerializedName("name")
    public String name;

    @SerializedName("country")
    public String country;

    @SerializedName("badgeUrl")
    public String badgeUrl;
}
