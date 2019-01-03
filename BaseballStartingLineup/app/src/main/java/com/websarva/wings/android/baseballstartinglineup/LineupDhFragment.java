package com.websarva.wings.android.baseballstartinglineup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LineupDhFragment extends Fragment {
    private static final String NAMES = "names";
    private static final String POSITONS = "positions";

    public static Bundle args;

    //各打順の名前
    TextView name1;
    TextView name2;
    TextView name3;
    TextView name4;
    TextView name5;
    TextView name6;
    TextView name7;
    TextView name8;
    TextView name9;
    TextView nameP;

    //各打順のポジション
    TextView position1;
    TextView position2;
    TextView position3;
    TextView position4;
    TextView position5;
    TextView position6;
    TextView position7;
    TextView position8;
    TextView position9;
    TextView positionP;

    private String[] namesDH = new String[10];
    private String[] positionsDH = new String[9];


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

        name1 = v.findViewById(R.id.name1DH);
        name2 = v.findViewById(R.id.name2DH);
        name3 = v.findViewById(R.id.name3DH);
        name4 = v.findViewById(R.id.name4DH);
        name5 = v.findViewById(R.id.name5DH);
        name6 = v.findViewById(R.id.name6DH);
        name7 = v.findViewById(R.id.name7DH);
        name8 = v.findViewById(R.id.name8DH);
        name9 = v.findViewById(R.id.name9DH);
        nameP = v.findViewById(R.id.nameP);
        position1 = v.findViewById(R.id.position1DH);
        position2 = v.findViewById(R.id.position2DH);
        position3 = v.findViewById(R.id.position3DH);
        position4 = v.findViewById(R.id.position4DH);
        position5 = v.findViewById(R.id.position5DH);
        position6 = v.findViewById(R.id.position6DH);
        position7 = v.findViewById(R.id.position7DH);
        position8 = v.findViewById(R.id.position8DH);
        position9 = v.findViewById(R.id.position9DH);
        positionP = v.findViewById(R.id.positionP);

        namesDH = getArguments().getStringArray(NAMES);
        positionsDH = getArguments().getStringArray(POSITONS);

        setInfo(namesDH,positionsDH);


        return v;
    }



    public void setInfo(String[] names,String[] positions ){




        // レイアウトに表示
        name1.setText(names[1]);
        name2.setText(names[2]);
        name3.setText(names[3]);
        name4.setText(names[4]);
        name5.setText(names[5]);
        name6.setText(names[6]);
        name7.setText(names[7]);
        name8.setText(names[8]);
        name9.setText(names[9]);
        nameP.setText(names[10]);

        position1.setText(positions[1]);
        position1.setText(positions[2]);
        position1.setText(positions[3]);
        position1.setText(positions[4]);
        position1.setText(positions[5]);
        position1.setText(positions[6]);
        position1.setText(positions[7]);
        position1.setText(positions[8]);
        position1.setText(positions[9]);

    }

}
