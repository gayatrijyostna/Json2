package com.example.sys.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.ViewHolderClass> {

    Context context;
    RecyclerView recyclerView;
    ArrayList<HashMap<String,String>> data;
    public CustomAdaptor(MainActivity mainActivity,ArrayList<HashMap<String,String>> data) {
        context = mainActivity;
        this.data = data;

        }


    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdaptor.ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.name.setText(data.get(i).get("name"));
        viewHolderClass.designation.setText(data.get(i).get("designation"));
        viewHolderClass.location.setText(data.get(i).get("location"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView name,designation,location;
        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
         name= itemView.findViewById(R.id.name);
            designation = itemView.findViewById(R.id.designation);
            location= itemView.findViewById(R.id.location);

        }
    }
}
