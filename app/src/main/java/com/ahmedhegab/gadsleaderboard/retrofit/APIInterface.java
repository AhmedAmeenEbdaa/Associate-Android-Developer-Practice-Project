package com.ahmedhegab.gadsleaderboard.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("api/hours")
    Call<List<LearningLeader>> learningLeaderCall();

    @GET("api/skilliq")
    Call<List<SkillIQLeader>> skillIQLeaderCall();


//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
