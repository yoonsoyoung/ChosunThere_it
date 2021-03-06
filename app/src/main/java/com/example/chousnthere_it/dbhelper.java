package com.example.chousnthere_it;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.example.chousnthere_it.Model.Classr;
import com.example.chousnthere_it.Model.Prof;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


class dbhelper extends SQLiteAssetHelper {

    //assets 폴더 안에 생성된 db파일
    String DB_PATH=""; //assets폴더에 db파일 생성할 것이므로 빈칸으로 둔다("")
    private static final String DB_NAME= "chosunIT.db";


    public dbhelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    //classroom 테이블 내용 호출
    public List<Classr> getClassr(){
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"cname", "u_id", "floor", "com"};
        String tableName="CLASSROOM";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db, sqlSelect, null, null, null, null, null);
        List<Classr> result= new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{
                Classr classr = new Classr();
                classr.setCname(cursor.getString(cursor.getColumnIndex("cname")));
                classr.setU_id(cursor.getString(cursor.getColumnIndex("u_id")));
                classr.setFloor(cursor.getString(cursor.getColumnIndex("floor")));
                classr.setCom(cursor.getString((cursor.getColumnIndex("com"))));

                result.add(classr);
            }while(cursor.moveToNext());
        }
        return result;
    }

    //검색을 위한 메소드
    public List<String> getClassrName(){
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"cname"};
        String tableName="CLASSROOM";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result= new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{
                result.add(cursor.getString(cursor.getColumnIndex("cname")));
            }while(cursor.moveToNext());
        }
        return result;
    }

    public List<Classr> getClassrByName(String cname){
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"cname","u_id","floor","com"};
        String tableName="CLASSROOM";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db, sqlSelect, "cname LIKE ?", new String[]{"%"+cname+"%"}, null, null, null);
        List<Classr> result= new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{
                Classr classr = new Classr();
                classr.setCname(cursor.getString(cursor.getColumnIndex("cname")));
                classr.setU_id(cursor.getString(cursor.getColumnIndex("u_id")));
                classr.setFloor(cursor.getString(cursor.getColumnIndex("floor")));
                classr.setCom(cursor.getString((cursor.getColumnIndex("com"))));

                result.add(classr);
            }while(cursor.moveToNext());
        }
        return result;
    }

    public List<Prof> getProf(){
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"name", "call", "location", "u_id"};
        String tableName="PROF";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db, sqlSelect, null, null, null, null, null);
        List<Prof> result= new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{
                Prof prof = new Prof();
                prof.setName(cursor.getString(cursor.getColumnIndex("name")));
                prof.setCall(cursor.getString(cursor.getColumnIndex("call")));
                prof.setLocation(cursor.getString(cursor.getColumnIndex("location")));
                prof.setU_id(cursor.getString((cursor.getColumnIndex("u_id"))));

                result.add(prof);
            }while(cursor.moveToNext());
        }
        return result;
    }

    public List<String> getProfName(){
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"name"};
        String tableName="PROF";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result= new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{
                result.add(cursor.getString(cursor.getColumnIndex("name")));
            }while(cursor.moveToNext());
        }
        return result;
    }

    public List<Prof> getProfByName(String name){
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"name", "call", "location", "u_id"};
        String tableName="PROF";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db, sqlSelect, "name LIKE ?", new String[]{"%"+name+"%"},null, null, null);
        List<Prof> result= new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{
                Prof prof = new Prof();
                prof.setName(cursor.getString(cursor.getColumnIndex("name")));
                prof.setCall(cursor.getString(cursor.getColumnIndex("call")));
                prof.setLocation(cursor.getString(cursor.getColumnIndex("location")));
                prof.setU_id(cursor.getString((cursor.getColumnIndex("u_id"))));

                result.add(prof);
            }while(cursor.moveToNext());
        }
        return result;
    }

}
