package com.joke.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

	Context context;

	// 建库
	public SQLHelper(Context context) {
		super(context, "lcu.db", null, 1);
		// TODO Auto-generated constructor stub
		
	}
	
	//建表
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL("create table joke(id integer primary key autoincrement, name varchar, icon varchar, text varchar, favCount integer, buryCount integer, commentCount integer, shareCount integer, shareUrl varchar)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
