package com.bigggfish.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewTabFragment extends Fragment {

    private RecyclerView recyclerView;

    public RecyclerViewTabFragment() {
        // Required empty public constructor
    }
    public static RecyclerViewTabFragment newInstance() {
        RecyclerViewTabFragment fragment = new RecyclerViewTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recycler_view_tab, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        List<String> datas = new ArrayList<>();
        for(int i=0; i<20; i++){
            datas.add("Position" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SimpleRecyclerViewAdapter(datas));
        return rootView;
    }

    class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{

        private List<String> mDatas;

        public SimpleRecyclerViewAdapter(List<String> datas){
            this.mDatas = datas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.item_text, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv_item.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_item;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_item = (TextView)itemView.findViewById(R.id.tv_item);
        }
    }


}
