package egco.com.databaselistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Blind.db";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*insertDataToTableRoom(1,"meeting room");
        insertDataToTableRoom(2,"lecture room");
        insertDataToTableRoom(3,"small bedroom");
        insertDataToTableRoom(4,"big bedroom");
        insertDataToTableRoom(5,"lab room");

        insertDataToTableItem(1,"TV");
        insertDataToTableItem(2,"Bed");
        insertDataToTableItem(3,"Table");
        insertDataToTableItem(4,"Phone");
        insertDataToTableItem(5,"Project");

        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT);");
        db.execSQL("create table item_table (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT);");
        db.execSQL("create table itemInRoom_table (ID_ROOM INTEGER,ID_ITEM INTEGER,PATTERN TEXT,DISTANCE TEXT,primary key (ID_ROOM, ID_ITEM));");*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS item_table");
        db.execSQL("DROP TABLE IF EXISTS itemInRoom_table");
        onCreate(db);*/
    }

   /* public boolean insertDataToTableRoom(int id,String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataToTableItem(int id,String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        long result = db.insert("item_table",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataToTableItemInRoom(int room_id,int item_id,String pattern,String distance){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_ROOM",room_id);
        contentValues.put("ID_ITEM",item_id);
        contentValues.put("PATTERN",pattern);
        contentValues.put("DISTANCE",distance);
        long result = db.insert("itemInRoom_table",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }*/

    public Cursor getAllItemInRoom(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resource = db.rawQuery("select * from item_table" ,null );
        return resource;
    }
}
