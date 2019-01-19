package com.websarva.wings.android.baseballstartinglineup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LineupNormalFragment extends Fragment {

    private static final String NAMES_NORMAL = "namesNormal_fromTop";
    private static final String POSITONS_NORMAL = "positionsNormal_fromTop";

    public static Bundle args;

    private TextView[] namesNormal_local = new TextView[10];
    private TextView[] positionsNormal_local = new TextView[10];


    private String[] namesNormal_fromTop = new String[20];
    private String[] positionsNormal_fromTop = new String[20];


    public static LineupNormalFragment newInstance(String[] names, String[] positions) {

        LineupNormalFragment fragment = new LineupNormalFragment();

        args = new Bundle();
        args.putStringArray(NAMES_NORMAL, names);
        args.putStringArray(POSITONS_NORMAL, positions);
        fragment.setArguments(args);

        return fragment;
    }

    public LineupNormalFragment() {
    }


    // レイアウト紐付け
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_lineup_normal, container, false);

        namesNormal_local[1] = v.findViewById(R.id.name1_normal);
        namesNormal_local[2] = v.findViewById(R.id.name2_normal);
        namesNormal_local[3] = v.findViewById(R.id.name3_normal);
        namesNormal_local[4] = v.findViewById(R.id.name4_normal);
        namesNormal_local[5] = v.findViewById(R.id.name5_normal);
        namesNormal_local[6] = v.findViewById(R.id.name6_normal);
        namesNormal_local[7] = v.findViewById(R.id.name7_normal);
        namesNormal_local[8] = v.findViewById(R.id.name8_normal);
        namesNormal_local[9] = v.findViewById(R.id.name9_normal);
        positionsNormal_local[1] = v.findViewById(R.id.position1_normal);
        positionsNormal_local[2] = v.findViewById(R.id.position2_normal);
        positionsNormal_local[3] = v.findViewById(R.id.position3_normal);
        positionsNormal_local[4] = v.findViewById(R.id.position4_normal);
        positionsNormal_local[5] = v.findViewById(R.id.position5_normal);
        positionsNormal_local[6] = v.findViewById(R.id.position6_normal);
        positionsNormal_local[7] = v.findViewById(R.id.position7_normal);
        positionsNormal_local[8] = v.findViewById(R.id.position8_normal);
        positionsNormal_local[9] = v.findViewById(R.id.position9_normal);

        namesNormal_fromTop = getArguments().getStringArray(NAMES_NORMAL);
        positionsNormal_fromTop = getArguments().getStringArray(POSITONS_NORMAL);

        setInfo(namesNormal_fromTop, positionsNormal_fromTop);


        return v;
    }

    public void setInfo(String[] names, String[] positions) {

        // レイアウトに表示
        for(int i = 1;i < 10;i++){
            namesNormal_local[i].setText(names[i + 10]);
            changeTextSize(namesNormal_local[i]);
            positionsNormal_local[i].setText(positions[i + 10]);
        }

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
    public void textChange(int num, String position, String name) {

        namesNormal_local[num].setText(name);
        changeTextSize(namesNormal_local[num]);
        positionsNormal_local[num].setText(position);

    }
}
