package com.ahmedhegab.gadsleaderboard.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIInterface {
    @GET("api/hours")
    Call<List<LearningLeader>> learningLeaderCall();

    @GET("api/skilliq")
    Call<List<SkillIQLeader>> skillIQLeaderCall();


    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Void> postValues(@Field("entry.1824927963") String emailAddress,
                           @Field("entry.1877115667") String firstName,
                           @Field("entry.2006916086") String lastName,
                           @Field("entry.284483984") String projectLink
    );
}
