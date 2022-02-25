package com.faizanfirstproject.newsnow.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faizanfirstproject.newsnow.APIUtilities.ApiUtilities;
import com.faizanfirstproject.newsnow.Adapters.MyRecycleViewAdapter;
import com.faizanfirstproject.newsnow.ApiParams.Params;
import com.faizanfirstproject.newsnow.Model.MainNews;
import com.faizanfirstproject.newsnow.Model.ModelClass;
import com.faizanfirstproject.newsnow.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechnologyFragment extends Fragment {
    private ArrayList<ModelClass> modelClassArrayList;
    private RecyclerView recyclerViewTech;
    private String country="in";
    private MyRecycleViewAdapter adapter;
    private String category="technology";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.technologyfragment,null);
        recyclerViewTech=v.findViewById(R.id.recyclerViewTechnology);
        modelClassArrayList=new ArrayList<>();
        recyclerViewTech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new MyRecycleViewAdapter(getContext(),modelClassArrayList);
        recyclerViewTech.setAdapter(adapter);
        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100, Params.API_KEY).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
