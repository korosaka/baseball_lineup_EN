package com.websarva.wings.android.baseballstartinglineup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //選択した打順
    TextView tvSelectNum;
    //入力欄
    EditText etName;
    //登録ボタン
    Button record;
    //スタメンタイトル
    TextView title;
    //各打順の数字配列
    int numbers[] = new int[20];
    //グローバル変数i（データベースへの登録・検索で使う）
    int i = 0;
    //サブオーダー選択時に+10される
    int k = 0;
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
    //スピナーオブジェクト
    Spinner spinner;
    //クリアボタン（現在上部に入力中のものを未入力状態に戻す（選択打順も））
    Button clear;
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
    //各打順の名前,ポジション用配列
    String[] names;
    String[] positions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //上記のグローバルフィールド紐付け
        tvSelectNum = findViewById(R.id.selectNum);
        etName = findViewById(R.id.etName);
        record = findViewById(R.id.record);
        clear = findViewById(R.id.clear);
        title = findViewById(R.id.title);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        name4 = findViewById(R.id.name4);
        name5 = findViewById(R.id.name5);
        name6 = findViewById(R.id.name6);
        name7 = findViewById(R.id.name7);
        name8 = findViewById(R.id.name8);
        name9 = findViewById(R.id.name9);
        position1 = findViewById(R.id.position1);
        position2 = findViewById(R.id.position2);
        position3 = findViewById(R.id.position3);
        position4 = findViewById(R.id.position4);
        position5 = findViewById(R.id.position5);
        position6 = findViewById(R.id.position6);
        position7 = findViewById(R.id.position7);
        position8 = findViewById(R.id.position8);
        position9 = findViewById(R.id.position9);
        //打順配列に打順番号入れる(1~19番)
        for(int i = 1;i < 20;i++){
            numbers[i] = i;
        }
        //スピナー紐付け
        spinner = findViewById(R.id.position);
        //EditText入力不可に
        etName.setEnabled(false);

//        TODO データベースから引っ張ってきて表示するメソッドorないなら空情報を配列に入れる
    }

    //以下１〜９番の打順ボタン処理⬇
    public void onClick1(View view){
        commonMethod(1);
    }
    public void onClick2(View view){
        commonMethod(2);
    }
    public void onClick3(View view){
        commonMethod(3);
    }
    public void onClick4(View view){
        commonMethod(4);
    }
    public void onClick5(View view){
        commonMethod(5);
    }
    public void onClick6(View view){
        commonMethod(6);
    }
    public void onClick7(View view){
        commonMethod(7);
    }
    public void onClick8(View view) {
        commonMethod(8);
    }
    public void onClick9(View view){
        commonMethod(9);
    }
    //打順ボタン共通メソッド（打順・登録状態表示、EditText・登録/クリアボタンの有効化、データベース用の数字登録）
    public void commonMethod(int j){
        //numbersは表示打順のためkを反映させない
        String number = String.valueOf(j);
        tvSelectNum.setText(number);
        //下記メソッド使用
        setSpinner(spinner,positions[j + k]);
        etName.setText(names[j + k]);
        if(etName.getText().toString().equals("-----")){
            etName.setText("");
        }
        etName.setEnabled(true);
        record.setEnabled(true);
        clear.setEnabled(true);
        i = j;
    }
    //文字列からスピナーをセットするメソッド（上記メソッドで使用）
    public void setSpinner(Spinner spinner,String position){
        SpinnerAdapter adapter = spinner.getAdapter();
        int index = 0;
        for(int i = 0; i < adapter.getCount(); i++){
            if(adapter.getItem(i).equals(position)){
                index = i;
                break;
            }
        }
        spinner.setSelection(index);
    }

}
