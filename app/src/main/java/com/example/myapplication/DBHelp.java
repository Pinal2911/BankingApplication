package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DBHelp extends SQLiteOpenHelper {
    public DBHelp(@Nullable Context context) {
        super(context,"Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(name TEXT NOT NULL ,id INTEGER PRIMARY KEY ,addr TEXT NOT NULL ,mob TEXT NOT NULL ,amt TEXT NOT NULL ,acctype TEXT NOT NULL ,age TEXT NOT NULL )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Userdetails");
    }
    public Boolean addaccount(String name,String id,String addr,String mob,String amt,String acctype,String age){
        long res = 0;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        Cursor c=db.rawQuery("Select id from Userdetails",null);
        if(c.getCount()>0){
            while(c.moveToNext()){
                System.out.println(id);
                System.out.println(c);
                String id2=c.getString(0);
                if(id2.equals(id)){
                    res=-1;
                }
                else{
                    cv.put("name",name);
                    cv.put("id",id);
                    cv.put("addr",addr);
                    cv.put("mob",mob);
                    cv.put("amt",amt);
                    cv.put("acctype",acctype);
                    cv.put("age",age);
                }
            }
            res = db.insert("Userdetails", null, cv);
        }
        if (res == -1) {
            return false;
        } else {

            return true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("Select * from Userdetails",null);
        return c;
    }
    public Boolean deletedata(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("Select *from Userdetails where id = ?",new String[] {id});
        if(c.getCount()>0) {
            long result = db.delete("Userdetails ", "id = ?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
    public Boolean updatedata(String id,String amt){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        String amt2;
        Cursor c=db.rawQuery("Select amt from Userdetails where id = ?",new String[]
                {id});
        if(c.getCount()>0){
            while (c.moveToNext()) {
                amt2 = c.getString(0);
                int v1 = Integer.parseInt(amt);
                int v2 = Integer.parseInt(amt2);
                int v3 = v1 + v2;
                String a = Integer.valueOf(v3).toString();
                amt = a;
            }
            cv.put("amt",amt);
            long res=db.update("Userdetails",cv,"id=?",new String[]{id});

            if(res == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    public Boolean updatedata2(String id,String amt){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        String amt2;
        Cursor c=db.rawQuery("Select amt from Userdetails where id = ?",new String[]
                {id});
        if(c.getCount()>0){
            while (c.moveToNext()) {
                amt2 = c.getString(0);
                int v1 = Integer.parseInt(amt);
                int v2 = Integer.parseInt(amt2);
                int v3 = -(v1 - v2);
                String a = Integer.valueOf(v3).toString();
                amt = a;
            }
            cv.put("amt",amt);
            long res=db.update("Userdetails",cv,"id=?",new String[]{id});
            if(res == -1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}
