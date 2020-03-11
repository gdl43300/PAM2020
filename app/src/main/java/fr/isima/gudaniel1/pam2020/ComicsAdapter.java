package fr.isima.gudaniel1.pam2020;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ComicsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter {
    List<Comic> list;
    ShowDetailCallback showDetailCallback;


    public ComicsAdapter(ShowDetailCallback sdc) {
        list = new ArrayList<Comic>();
        showDetailCallback = sdc;
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder {

        public Button button;
        public ComicViewHolder(Button v) {
            super(v);
            button = v;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Button t = (Button) LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false);
        ComicViewHolder c = new ComicViewHolder(t);
        return c;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ComicViewHolder comicHolder = (ComicViewHolder) holder;
        Comic c = list.get(position);
        StringBuilder sb = new StringBuilder();
        sb.append(c.num);
        sb.append(" : ");
        sb.append(c.title);
        comicHolder.button.setText(sb.toString());
        comicHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetailCallback.showDetail(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setList(List<Comic> list) {
        this.list = list;
        notifyDataSetChanged();
    }


}
