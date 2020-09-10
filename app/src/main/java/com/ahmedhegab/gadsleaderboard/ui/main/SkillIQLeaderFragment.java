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
import com.ahmedhegab.gadsleaderboard.retrofit.SkillIQLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 */
public class SkillIQLeaderFragment extends Fragment {
    APIInterface apiInterface =    APIClient.getClient().create(APIInterface.class);

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SkillIQLeaderFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SkillIQLeaderFragment newInstance() {
        SkillIQLeaderFragment fragment = new SkillIQLeaderFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_skill_i_q_leader_list, container, false);

        Call<List<SkillIQLeader>> skillIQLeaderCall = apiInterface.skillIQLeaderCall();

        skillIQLeaderCall.enqueue(new Callback<List<SkillIQLeader>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeader>> call, Response<List<SkillIQLeader>> response) {

                List<SkillIQLeader> skillIQLeaderList = response.body();
                skillIQLeaderList.size();
                Context context = view.getContext();
                RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new SkillIQLeaderRecyclerViewAdapter(skillIQLeaderList));
            }

            @Override
            public void onFailure(Call<List<SkillIQLeader>> call, Throwable t) {
                call.cancel();
            }
        });
        return view;
    }
}