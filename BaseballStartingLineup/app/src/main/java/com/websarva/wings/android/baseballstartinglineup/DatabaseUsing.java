package com.websarva.wings.android.baseballstartinglineup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

//データベース
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
            SQLiteDatabase dbR = helper.getReadableDatabase();
            try {
                //SQL文字列作成➡︎検索・表示（１〜９番 + 1人（ピッチャーor空白））
                //SELECT文の文字列作成
                String sqlSelect = "SELECT playerName,position FROM lineup WHERE number = " + MainActivity.numbers[j + k];
                //sql実行（カーソルオブジェクト（実行結果そのもの？）が戻り値）
                Cursor cursor = dbR.rawQuery(sqlSelect, null);
                //cursor.moveToNext() ➡︎データない時（移動ができなかった時）はfalseになる
                if(cursor.moveToNext())
                {
                    //カラムのインデックス値取得
                    int idxName = cursor.getColumnIndex("playerName");
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
                dbR.close();
            }
        }
    }

    // データベースに登録
    public void setPlayerInfo(int num,String position,String name,int k){

        SQLiteDatabase dbW = helper.getWritableDatabase();

        try {
            //今あるデータ削除➡その後インサート
            //削除用文字列
            String sqlDelete = "DELETE FROM lineup WHERE number = ?";
            //上記文字列からPreparedStatement取得（SQLを実行するためのインターフェース）
            SQLiteStatement stmt = dbW.compileStatement(sqlDelete);
            //変数バインド（数字は何番目の？に入れるか,？に入れるもの）（kはオプション選択によって変わる）
            stmt.bindLong(1,num + k);
            //削除SQL実行
            stmt.executeUpdateDelete();

            //インサート用文字
            String sqlInsert = "INSERT INTO lineup(_id, number, playerName, position) VALUES(?,?,?,?)";
            //PreparedStatement取得 (stmtは削除で使ったものの再利用)
            stmt = dbW.compileStatement(sqlInsert);
            //変数バインド（数字は何番目の？に入れるか,？に入れるもの）
            //_id(primary key) は設定不要らしい
            //サブオーダー選択時は打順は11~19番でデータベースに登録される
            stmt.bindLong(2,num + k);
            stmt.bindString(3,name);
            stmt.bindString(4,position);
            //インサートSQL実行
            stmt.executeInsert();
        }
        catch (Exception e){
            Log.d("error","例外発生");
        }
        finally {
            //データ接続プブジェクト解放
            dbW.close();
        }
    }


}
