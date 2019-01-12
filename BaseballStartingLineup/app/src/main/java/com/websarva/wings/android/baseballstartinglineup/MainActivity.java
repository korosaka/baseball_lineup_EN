package com.websarva.wings.android.baseballstartinglineup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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
    //キャンセルボタン
    Button cancel;
    //スタメンタイトル
    TextView title;
    //各打順の数字配列
    public static int numbers[] = new int[20];
    //グローバル変数i（データベースへの登録・検索で使う）
    int i = 0;
    //DH無し選択時に+10される
    int k = 0;
    //スピナーオブジェクト
    Spinner spinner;
    //クリアボタン（現在上部に入力中のものを未入力状態に戻す（選択打順も））
    Button clear;
    //各打順の名前,ポジション用配列(0は使わないので20個用意)
    public static String[] names = new String[20];
    public static String[] positions = new String[20];

    private DatabaseUsing databaseUsing;

    View view;

    LineupDhFragment dhFragment;

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
        cancel = findViewById(R.id.cancel);


        //打順配列に打順番号入れる(1~19番)
        for(int i = 1;i < 20;i++){
            numbers[i] = i;
        }
        //スピナー紐付け
        spinner = findViewById(R.id.position);
        //EditText入力不可に
        etName.setEnabled(false);

//        TODO データベースから引っ張ってきて表示するメソッドorないなら空情報を配列に入れる
        databaseUsing = new DatabaseUsing(this);
        databaseUsing.getPlayersInfo(k);

        // fragment作成
        dhFragment = LineupDhFragment.newInstance(names,positions);
        LineupNormalFragment normalFragment = new LineupNormalFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.lineup_container,dhFragment);
        transaction.add(R.id.lineup_container,normalFragment);
        transaction.show(dhFragment);
        transaction.hide(normalFragment);
        transaction.commit();

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
    public void onClickP(View view){
        commonMethod(10);
    }
    //打順ボタン共通メソッド（打順・登録状態表示、EditText・登録/クリアボタンの有効化、データベース用の数字登録）
    public void commonMethod(int j){
        //下記メソッド使用
        setSpinner(spinner,positions[j + k]);
        etName.setText(names[j + k]);
        if(etName.getText().toString().equals("-----")){
            etName.setText("");
        }
        etName.setFocusable(true);
        etName.setFocusableInTouchMode(true);
        etName.setEnabled(true);
        record.setEnabled(true);
        clear.setEnabled(true);
        cancel.setEnabled(true);

        i = j;

        // 投手選択時
        if(j == 10){
            tvSelectNum.setText("P");
            spinner.setEnabled(false);
        } else {
            // 野手
            tvSelectNum.setText(String.valueOf(j));
            spinner.setEnabled(true);
        }

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

    // 登録ボタンクリック
    public void onClickSave(View view){
        //入力文字列取得
        String playerName = etName.getText().toString();
        if(playerName.equals("")){
            playerName = "-----";
        }
        //ポジション取得
        String position = (String) spinner.getSelectedItem();
        if(i == 10){
            position = "(P)";
        }

        // データベースに登録
        databaseUsing.setPlayerInfo(i,position,playerName,k);


        //それぞれ初期状態に戻
        // TODO 要メソッド化（true時false時いちいち使っちゃってる）
        tvSelectNum.setText(getString(R.string.current_num));
        etName.setText("");
        spinner.setSelection(0);
        etName.setFocusable(false);
        etName.setFocusableInTouchMode(false);
        etName.setEnabled(false);
        record.setEnabled(false);
        cancel.setEnabled(false);
        clear.setEnabled(false);

        // レイアウトのオーダーに反映
        dhFragment.textChange(i,position,playerName);
        // フィールド変数にも反映
        names[i] = playerName;
        positions[i] = position;

    }

    // クリアーボタンクリック
    public void onClickClear(View view){
        //入力名をクリア状態に
        etName.setText("");
        //スピナー（守備位置）を未選択状態に戻す
        spinner.setSelection(0);
    }
    // キャンセルボタンクリック
    public void onClickCancel(View view){
        //それぞれ初期状態に戻す
        tvSelectNum.setText(getString(R.string.current_num));
        etName.setText("");
        spinner.setSelection(0);
        etName.setFocusable(false);
        etName.setFocusableInTouchMode(false);
        etName.setEnabled(false);
        record.setEnabled(false);
        cancel.setEnabled(false);
        clear.setEnabled(false);
    }

    // フィールド表示
    public void onClickField(View view){

        databaseUsing.getPlayersInfo(k);

        //遷移先に送るデータ（各守備位置・名前）
        String[] positionIntent = new String[11];
        String[] nameIntent = new String[11];
        //送るデータ（10人分）を抽出（正規orサブ）
        for (int i = 1;i < 11;i++){
            positionIntent[i] = positions[i + k];
            nameIntent[i] = names[i + k];
        }
        //フィールド画面へ
        Intent intent = new Intent(MainActivity.this,FieldActivity.class);
        intent.putExtra("positions",positionIntent);
        intent.putExtra("names",nameIntent);
        startActivity(intent);
    }


}
