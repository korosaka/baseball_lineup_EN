package com.websarva.wings.android.baseballstartinglineup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LineupNormalFragment extends Fragment {

    private static final String NAMES = "namesOfNotDh";
    private static final String POSITONS = "positionsOfNotDh";

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

    private String[] namesOfNotDh = new String[10];
    private String[] positionsOfNotDh = new String[10];


    public static LineupNormalFragment newInstance(String[] names, String[] positions) {

        LineupNormalFragment fragment = new LineupNormalFragment();

        args = new Bundle();
        args.putStringArray(NAMES, names);
        args.putStringArray(POSITONS, positions);
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

        name1 = v.findViewById(R.id.name1_normal);
        name2 = v.findViewById(R.id.name2_normal);
        name3 = v.findViewById(R.id.name3_normal);
        name4 = v.findViewById(R.id.name4_normal);
        name5 = v.findViewById(R.id.name5_normal);
        name6 = v.findViewById(R.id.name6_normal);
        name7 = v.findViewById(R.id.name7_normal);
        name8 = v.findViewById(R.id.name8_normal);
        name9 = v.findViewById(R.id.name9_normal);
        position1 = v.findViewById(R.id.position1_normal);
        position2 = v.findViewById(R.id.position2_normal);
        position3 = v.findViewById(R.id.position3_normal);
        position4 = v.findViewById(R.id.position4_normal);
        position5 = v.findViewById(R.id.position5_normal);
        position6 = v.findViewById(R.id.position6_normal);
        position7 = v.findViewById(R.id.position7_normal);
        position8 = v.findViewById(R.id.position8_normal);
        position9 = v.findViewById(R.id.position9_normal);

        setInfo(namesOfNotDh, positionsOfNotDh);


        return v;
    }

    public void setInfo(String[] names, String[] positions) {

        // レイアウトにいっせい表示
        name1.setText(names[1]);
        name2.setText(names[2]);
        name3.setText(names[3]);
        name4.setText(names[4]);
        name5.setText(names[5]);
        name6.setText(names[6]);
        name7.setText(names[7]);
        name8.setText(names[8]);
        name9.setText(names[9]);

        position1.setText(positions[1]);
        position2.setText(positions[2]);
        position3.setText(positions[3]);
        position4.setText(positions[4]);
        position5.setText(positions[5]);
        position6.setText(positions[6]);
        position7.setText(positions[7]);
        position8.setText(positions[8]);
        position9.setText(positions[9]);

    }

    // 特定の打順の内容変更
    public void textChange(int num, String position, String name) {

        switch (num) {
            case 1:
                position1.setText(position);
                name1.setText(name);
                break;
            case 2:
                position2.setText(position);
                name2.setText(name);
                break;
            case 3:
                position3.setText(position);
                name3.setText(name);
                break;
            case 4:
                position4.setText(position);
                name4.setText(name);
                break;
            case 5:
                position5.setText(position);
                name5.setText(name);
                break;
            case 6:
                position6.setText(position);
                name6.setText(name);
                break;
            case 7:
                position7.setText(position);
                name7.setText(name);
                break;
            case 8:
                position8.setText(position);
                name8.setText(name);
                break;
            case 9:
                position9.setText(position);
                name9.setText(name);
                break;
        }


    }
}
