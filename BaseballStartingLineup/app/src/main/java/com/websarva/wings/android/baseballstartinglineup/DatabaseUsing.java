package com.websarva.wings.android.baseballstartinglineup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseUsing {

    private DatabaseHelper helper;
    private String name;
    private String position;

    public DatabaseUsing(){
        //データベースからデータを取り出してきて表示する処理
        //データベースヘルパーオブジェクト生成
        helper = new DatabaseHelper(DatabaseUsing.class);
    };

//    TODO アプリ立ち上げ時に表示するデータ取り出し
    public void firstDisplay(){

        for (int j = 1;j < 10;j++) {
            //ヘルパーから接続オブジェクト取得
            SQLiteDatabase db = helper.getReadableDatabase();
            try {
                //SQL文字列作成➡︎検索・表示（１〜９番）
                //SELECT文の文字列作成
                String sqlSelect = "SELECT playername,position FROM batting WHERE number = " + numbers[j];
                //sql実行（カーソルオブジェクト（実行結果そのもの？）が戻り値）
                Cursor cursor = db.rawQuery(sqlSelect, null);
                //cursor.moveToNext() ➡︎データない時（移動ができなかった時）はfalseになる
                if(cursor.moveToNext())
                {
                    //カラムのインデックス値取得
                    int idxName = cursor.getColumnIndex("playername");
                    int idxPosition = cursor.getColumnIndex("position");
                    //カラムのインデックス値を元に実際のデータ取得
                    name = cursor.getString(idxName);
                    position = cursor.getString(idxPosition);
                    //名前の空白登録は未登録にする
                    if(name.equals("")){
                        name = "-----";
                    }
                }
                //データが無かった時
                else {
                    name = "-----";
                    position = "----";
                }
                //各打順の名前・ポジションを配列に格納しておく
                names[j] = name;
                positions[j] = position;
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


}
