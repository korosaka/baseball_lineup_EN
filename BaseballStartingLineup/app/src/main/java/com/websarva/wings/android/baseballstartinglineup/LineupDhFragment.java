package com.websarva.wings.android.baseballstartinglineup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LineupDhFragment extends Fragment {
    private static final String NAMES = "namesOfDh";
    private static final String POSITONS = "positionsOfDh";

    public static Bundle args;

    private String[] namesDH_fromTop = new String[11];
    private String[] positionsDH_fromTop = new String[10];

    private TextView[] namesDH_local = new TextView[11];
    private TextView[] positionsDH_local = new TextView[10];


    public static LineupDhFragment newInstance(String[] names,String[] positions){
        LineupDhFragment fragment = new LineupDhFragment();

        args = new Bundle();
        args.putStringArray(NAMES,names);
        args.putStringArray(POSITONS,positions);
        fragment.setArguments(args);

        return fragment;
    }

    public LineupDhFragment(){}


    // レイアウト紐付け
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);



        View v = inflater.inflate(R.layout.fragment_lineup_dh,container,false);

        namesDH_local[1] = v.findViewById(R.id.name1DH);
        namesDH_local[2] = v.findViewById(R.id.name2DH);
        namesDH_local[3] = v.findViewById(R.id.name3DH);
        namesDH_local[4] = v.findViewById(R.id.name4DH);
        namesDH_local[5] = v.findViewById(R.id.name5DH);
        namesDH_local[6] = v.findViewById(R.id.name6DH);
        namesDH_local[7] = v.findViewById(R.id.name7DH);
        namesDH_local[8] = v.findViewById(R.id.name8DH);
        namesDH_local[9] = v.findViewById(R.id.name9DH);
        namesDH_local[10] = v.findViewById(R.id.nameP);
        positionsDH_local[1] = v.findViewById(R.id.position1DH);
        positionsDH_local[2] = v.findViewById(R.id.position2DH);
        positionsDH_local[3] = v.findViewById(R.id.position3DH);
        positionsDH_local[4] = v.findViewById(R.id.position4DH);
        positionsDH_local[5] = v.findViewById(R.id.position5DH);
        positionsDH_local[6] = v.findViewById(R.id.position6DH);
        positionsDH_local[7] = v.findViewById(R.id.position7DH);
        positionsDH_local[8] = v.findViewById(R.id.position8DH);
        positionsDH_local[9] = v.findViewById(R.id.position9DH);

        namesDH_fromTop = getArguments().getStringArray(NAMES);
        positionsDH_fromTop = getArguments().getStringArray(POSITONS);

        setInfo(namesDH_fromTop, positionsDH_fromTop);

        return v;
    }


    public void setInfo(String[] names,String[] positions ){

        // レイアウト表示
        for(int i = 1;i < 10;i++){
            namesDH_local[i].setText(names[i]);
            positionsDH_local[i].setText(positions[i]);
            changeTextSize(namesDH_local[i]);
        }
        namesDH_local[10].setText(names[10]);
        changeTextSize(namesDH_local[10]);

    }

    public void changeTextSize(TextView textView){
        // 字数取得
        int lengthOfText = textView.length();

        // 字数によって文字サイズ変更
        if(lengthOfText < 12){
            textView.setTextSize(24);
        } else if(lengthOfText < 15){
            textView.setTextSize(20);
        } else if(lengthOfText < 17){
            textView.setTextSize(18);
        } else {
            textView.setTextSize(16);
        }

    }

    // 特定の打順の内容変更
    public void textChange(int num,String position,String name){

        namesDH_local[num].setText(name);
        changeTextSize(namesDH_local[num]);

        if(num < 10){
            positionsDH_local[num].setText(position);
        }
    }

}
