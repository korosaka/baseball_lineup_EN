package com.websarva.wings.android.baseballstartinglineup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

//データベースからデータ取得・データベースへデータ取得するクラス
public class DatabaseUsing {

    private DatabaseHelper helper;
    private String nameOfDataUsing;
    private String positionOfDataUsing;

    public DatabaseUsing(Context context){
        //データベースからデータを取り出してきて表示する処理
        //データベースヘルパーオブジェクト生成
        helper = new DatabaseHelper(context);
    };

//    TODO アプリ立ち上げ時に表示するデータ取り出し
    public void getPlayersInfo(int k){

        // DH制の場合は10人分のデータ
        int pitcher = 0;
        if(k == 0){pitcher = 1;}


        for (int j = 1;j < 10 + pitcher;j++) {
            //ヘルパーから接続オブジェクト取得
            SQLiteDatabase db = helper.getReadableDatabase();
            try {
                //SQL文字列作成➡︎検索・表示（１〜９番 + 1人（ピッチャーor空白））
                //SELECT文の文字列作成
                String sqlSelect = "SELECT playername,position FROM lineup WHERE number = " + MainActivity.numbers[j + k];
                //sql実行（カーソルオブジェクト（実行結果そのもの？）が戻り値）
                Cursor cursor = db.rawQuery(sqlSelect, null);
                //cursor.moveToNext() ➡︎データない時（移動ができなかった時）はfalseになる
                if(cursor.moveToNext())
                {
                    //カラムのインデックス値取得
                    int idxName = cursor.getColumnIndex("playername");
                    int idxPosition = cursor.getColumnIndex("position");
                    //カラムのインデックス値を元に実際のデータ取得
                    nameOfDataUsing = cursor.getString(idxName);
                    positionOfDataUsing = cursor.getString(idxPosition);
                    //名前の空白登録は未登録にする
                    if(nameOfDataUsing.equals("")){
                        nameOfDataUsing = "-----";
                    }
                }
                //データが無かった時
                else {
                    nameOfDataUsing = "-----";
                    positionOfDataUsing = "----";
                }
                //各打順の名前・ポジションを配列に格納しておく
                MainActivity.names[j + k] = nameOfDataUsing;
                MainActivity.positions[j + k] = positionOfDataUsing;
            }
            //catchないとエラー出る　
            catch (Exception e) {
                //エラーメッセージ出す
                Log.e("キャッチ", "エラー", e);
            } finally {
                //解放
                db.close();
            }
        }
    }

    // データベースに登録
    public void setPlayerInfo(int num,String position,String name){

    }


}
