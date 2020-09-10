package com.ahmedhegab.gadsleaderboard.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmedhegab.gadsleaderboard.R;
import com.ahmedhegab.gadsleaderboard.retrofit.APIClient;
import com.ahmedhegab.gadsleaderboard.retrofit.APIInterface;
import com.ahmedhegab.gadsleaderboard.retrofit.LearningLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 */
public class LearningLeaderFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    APIInterface apiInterface =    APIClient.getClient().create(APIInterface.class);

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LearningLeaderFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LearningLeaderFragment newInstance() {
        LearningLeaderFragment fragment = new LearningLeaderFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         final View view = inflater.inflate(R.layout.fragment_learning_leader, container, false);
        final Context context = view.getContext();

        Call<List<LearningLeader>> learningLeaderListCall = apiInterface.learningLeaderCall();
//
        learningLeaderListCall.enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {

                List<LearningLeader> learningLeaderList = response.body();
                learningLeaderList.size();

                RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new LearningLeaderRecyclerViewAdapter(learningLeaderList));

            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {
                call.cancel();
            }
        });

        return view;
    }
}