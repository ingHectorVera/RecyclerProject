package com.example.hectorvera.recyclerproject;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PersonHolder>{

    ArrayList<Person> people;

    public RecyclerAdapter(){}

    public RecyclerAdapter(ArrayList<Person> people){
        this.people = people;
    }

    @Override
    public RecyclerAdapter.PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_layout, parent, false);
        return new PersonHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        Person p = people.get(position);

        //holder.imageView.setImageBitmap(p.getImage());
        holder.itemName.setText(p.getName());
        holder.itemDate.setText(p.getDate());
        holder.itemDescription.setText(p.getDescription());
    }


    @Override
    public int getItemCount() {
        return people.size();
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public class PersonHolder extends RecyclerView.ViewHolder{
        //
        public TextView itemName, itemDate, itemDescription;
        public CardView card_view;
        public ImageView imageView;
        public PersonHolder(View itemView) {
            super(itemView);
            itemName = ((TextView) itemView.findViewById(R.id.itemName));
            itemDate = ((TextView) itemView.findViewById(R.id.itemDate));
            itemDescription = ((TextView) itemView.findViewById(R.id.itemDescription));
            imageView = ((ImageView) itemView.findViewById(R.id.imageView));
            card_view = ((CardView) itemView.findViewById(R.id.card_view));
            card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"For delete needs a Long click",Toast.LENGTH_SHORT).show();
                }
            });
            card_view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = getAdapterPosition();
                    ArrayList<Person> p = getPeople();
                    p.remove(pos);
                    notifyItemRemoved(pos);
                    Toast.makeText(v.getContext(),"onLongClick",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            card_view.setBackgroundColor(Color.BLUE);
            itemName.setTextColor(Color.WHITE);
            itemDate.setTextColor(Color.WHITE);
            itemDescription.setTextColor(Color.WHITE);
        }
    }
}
