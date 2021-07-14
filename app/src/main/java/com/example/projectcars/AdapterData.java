package com.example.projectcars;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolderData>{

    ArrayList<String> assignmentList;

    public AdapterData() {}

    public AdapterData(ArrayList<String> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public void setAssignmentList(ArrayList<String> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderData holder, int position) {
        holder.assignData(assignmentList.get(position));
    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        TextView assignment;

        public ViewHolderData(View itemView) {
            super(itemView);
            assignment = itemView.findViewById(R.id.itemList);
        }

        public void assignData(String data) {
            assignment.setText(data);
        }
    }
}
