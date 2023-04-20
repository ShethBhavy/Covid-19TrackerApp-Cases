package com.example.covid_19trackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class myCustomAdapter extends ArrayAdapter<model> {

    private Context context;
    private List<model> modelList;
    private List<model> modelListFiltered;

    public myCustomAdapter(Context context, List<model> modelList) {
        super(context, R.layout.list_custom_item, modelList);

        this.context = context;
        this.modelList = modelList;
        this.modelListFiltered = modelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvContryName = view.findViewById(R.id.countryName);
        ImageView ivContryFlag = view.findViewById(R.id.imageFlag);

        tvContryName.setText(modelListFiltered.get(position).getContryName());
        Glide.with(context).load(modelListFiltered.get(position).getFlag()).into(ivContryFlag);

        return view;
    }

    @Override
    public int getCount() {
        return modelListFiltered.size();
    }

    @Nullable
    @Override
    public model getItem(int position) {
        return modelListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint==null || constraint.length()==0) {
                    filterResults.count = modelList.size();
                    filterResults.values = modelList;
                }
                else {
                    List<model> resultModel = new ArrayList<>();
                    String seatchStr = constraint.toString().toLowerCase();

                    for(model m : modelList) {
                        if(m.getContryName().toLowerCase().contains(seatchStr)) {
                            resultModel.add(m);
                        }
                        filterResults.count = resultModel.size();
                        filterResults.values = resultModel;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                modelListFiltered = (List<model>) results.values;
                AffectedCountries.cModelList = (List<model>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
