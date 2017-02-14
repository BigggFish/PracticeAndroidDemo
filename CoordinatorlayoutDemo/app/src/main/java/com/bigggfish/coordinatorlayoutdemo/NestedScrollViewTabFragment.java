package com.bigggfish.coordinatorlayoutdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NestedScrollViewTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NestedScrollViewTabFragment extends Fragment {


    public NestedScrollViewTabFragment() {
        // Required empty public constructor
    }

    public static NestedScrollViewTabFragment newInstance() {
        NestedScrollViewTabFragment fragment = new NestedScrollViewTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scroll_view_tab, container, false);
    }

}
