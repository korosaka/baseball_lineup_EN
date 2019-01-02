package com.websarva.wings.android.baseballstartinglineup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LineupDhFragment extends Fragment {

    // レイアウト紐付け
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);

        return inflater.inflate(R.layout.fragment_lineup_dh,container,false);
    }

}
