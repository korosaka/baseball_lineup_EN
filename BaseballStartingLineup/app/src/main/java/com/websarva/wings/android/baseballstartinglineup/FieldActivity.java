package com.websarva.wings.android.baseballstartinglineup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FieldActivity extends AppCompatActivity {

    //戻るボタン
    //各ポジションのテキスト
    private TextView position1;
    private TextView position2;
    private TextView position3;
    private TextView position4;
    private TextView position5;
    private TextView position6;
    private TextView position7;
    private TextView position8;
    private TextView position9;
    private TextView positionDH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        //ポジション紐付け
        position1 = findViewById(R.id.pitcher);
        position2 = findViewById(R.id.catcher);
        position3 = findViewById(R.id.first);
        position4 = findViewById(R.id.second);
        position5 = findViewById(R.id.third);
        position6 = findViewById(R.id.shortStop);
        position7 = findViewById(R.id.left);
        position8 = findViewById(R.id.center);
        position9 = findViewById(R.id.right);
        positionDH = findViewById(R.id.dh);


        //インテントobject
        Intent intent = getIntent();
        //data取得
        String positions[] = intent.getStringArrayExtra("positions");
        String names[] = intent.getStringArrayExtra("names");

        //ある打順の守備位置dataがどこかのポジションと合致すれば、その打順登録名を守備フィールドに
        for(int i = 1;i < 11;i++){
            switch (positions[i]){
                case "(投)":
                    position1.setText(names[i] + " (P)");
                    break;
                case "(C)":
                    position2.setText(names[i] + " (" + i + ")");
                    break;
                case "(1B)":
                    position3.setText(names[i] + " (" + i + ")");
                    break;
                case "(2B)":
                    position4.setText(names[i] + " (" + i + ")");
                    break;
                case "(3B)":
                    position5.setText(names[i] + " (" + i + ")");
                    break;
                case "(SS)":
                    position6.setText(names[i] + " (" + i + ")");
                    break;
                case "(LF)":
                    position7.setText(names[i] + " (" + i + ")");
                    break;
                case "(CF)":
                    position8.setText(names[i] + " (" + i + ")");
                    break;
                case "(RF)":
                    position9.setText(names[i] + " (" + i + ")");
                    break;
                case "(DH)":
                    positionDH.setText(names[i] + " (" + i + ")");
                    break;
                default:
                    position1.setText(names[i] + " (" + (i + 1) + ")");
                    break;
            }
        }


    }
    //戻るボタン
    public void onClickBack(View view){
        finish();
    }
}
