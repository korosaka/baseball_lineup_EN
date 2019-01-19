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
        String positions[] = intent.getStringArrayExtra("positionsOfTop");
        String names[] = intent.getStringArrayExtra("namesOfTop");
        boolean isDh = intent.getBooleanExtra("isDh",false);

        //ある打順の守備位置dataがどこかのポジションと合致すれば、その打順登録名を守備フィールドに
        for(int i = 1;i < 11;i++){
            switch (positions[i]){
                case "(P)":
                    if(isDh){
                        position1.setText("[P] " + names[i]);
                    } else {
                        position1.setText("[" + i + "] " + names[i]);
                    }
                    changeTextSize(position1);
                    break;
                case "(C)":
                    position2.setText("[" + i + "] " + names[i]);
                    changeTextSize(position2);
                    break;
                case "(1B)":
                    position3.setText("[" + i + "] " + names[i]);
                    changeTextSize(position3);
                    break;
                case "(2B)":
                    position4.setText("[" + i + "] " + names[i]);
                    changeTextSize(position4);
                    break;
                case "(3B)":
                    position5.setText("[" + i + "] " + names[i]);
                    changeTextSize(position5);
                    break;
                case "(SS)":
                    position6.setText("[" + i + "] " + names[i]);
                    changeTextSize(position6);
                    break;
                case "(LF)":
                    position7.setText("[" + i + "] " + names[i]);
                    changeTextSize(position7);
                    break;
                case "(CF)":
                    position8.setText("[" + i + "] " + names[i]);
                    changeTextSize(position8);
                    break;
                case "(RF)":
                    position9.setText("[" + i + "] " + names[i]);
                    changeTextSize(position9);
                    break;
                case "(DH)":
                    positionDH.setText("[" + i + "] " + names[i]);
                    changeTextSize(positionDH);
                    break;
                default:
                    break;
            }
        }

        if(!isDh){
            positionDH.setText("");
        }

    }

    public void changeTextSize(TextView textView){
        // 字数取得
        int lengthOfText = textView.length();

        // 字数によって文字サイズ変更
        if(lengthOfText < 17){
            textView.setTextSize(13);
        } else if(lengthOfText < 19){
            textView.setTextSize(10);
        } else {
            textView.setTextSize(8);
        }

    }


    //戻るボタン
    public void onClickBack(View view){
        finish();
    }
}
