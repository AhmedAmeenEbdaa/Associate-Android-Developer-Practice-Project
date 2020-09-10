package com.ahmedhegab.gadsleaderboard.ui.main;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmedhegab.gadsleaderboard.R;
import com.ahmedhegab.gadsleaderboard.retrofit.LearningLeader;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class LearningLeaderRecyclerViewAdapter extends RecyclerView.Adapter<LearningLeaderRecyclerViewAdapter.ViewHolder> {

    private final List<LearningLeader> mValues;

    public LearningLeaderRecyclerViewAdapter(List<LearningLeader> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_learning_leader_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nameView.setText(mValues.get(position).name);
        holder.descView.setText(mValues.get(position).hours +" "+"learning hours"+" ,"+mValues.get(position).country );
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameView;
        public final TextView descView;

        public LearningLeader mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nameView = (TextView) view.findViewById(R.id.name);
            descView = (TextView) view.findViewById(R.id.desc);

        }

    }
}