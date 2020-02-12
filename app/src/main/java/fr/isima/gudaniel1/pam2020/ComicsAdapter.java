package fr.isima.gudaniel1.pam2020;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ComicsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter {
    List<Comic> list;


    public ComicsAdapter() {
        list = new ArrayList<Comic>();
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public ComicViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setList(List<Comic> list) {
        this.list = list;
    }
}
