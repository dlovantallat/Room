package com.dlovan.room.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlovan.room.R;
import com.dlovan.room.db.User;

import java.util.List;

/**
 * UserAdapter
 * Created by dlovan on 3/20/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> mList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.firstName.setText(mList.get(position).getFirstName());
        holder.lastName.setText(mList.get(position).getLastName());
        holder.email.setText(mList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        if (mList == null) return 0;
        return mList.size();
    }

    void setList(List<User> list) {
        mList = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView firstName;
        TextView lastName;
        TextView email;

        ViewHolder(View view) {
            super(view);
            firstName = view.findViewById(R.id.first_name);
            lastName = view.findViewById(R.id.last_name);
            email = view.findViewById(R.id.email);
        }
    }
}
