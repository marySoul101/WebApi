package com.example.parsejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<Etudiant> lst;
    Context context;

    public MyAdapter(Context context,List<Etudiant>l) {
        this.context = context;
        this.lst = l;

    }

    @NonNull


    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.display, parent, false);

        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.getTv1().setText(""+lst.get(position).getId());
        holder.getTv2().setText(lst.get(position).getPrenom());
        holder.getTv3().setText(lst.get(position).getNom());
        holder.getTv4().setText(lst.get(position).getCIN());
        holder.getTv5().setText(""+lst.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final TextView tv4;
        private final TextView tv5;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tv1 = (TextView) view.findViewById(R.id.id);
            tv2 = (TextView) view.findViewById(R.id.nom);
            tv3 = (TextView) view.findViewById(R.id.prenom);
            tv4 = (TextView) view.findViewById(R.id.cin);
            tv5 = (TextView) view.findViewById(R.id.age);
        }

        public TextView getTv1() {
            return tv1;
        }

        public TextView getTv2() {
            return tv2;
        }

        public TextView getTv3() {
            return tv3;
        }

        public TextView getTv4() {
            return tv4;
        }

        public TextView getTv5() {
            return tv5;
        }
    }
}


