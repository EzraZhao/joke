package com.joke.db;

import java.util.ArrayList;
import java.util.List;

import com.joke.bean.Joke;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLUtils {

	SQLHelper sqlHelper;
	Context context;
	List<Joke> jokes=new ArrayList<Joke>();
	
	public SQLUtils(Context context) {
		this.context = context;
		sqlHelper = new SQLHelper(context);
		
	}
	
	public void addData(Joke joke) {
		SQLiteDatabase db = sqlHelper.getWritableDatabase();
		db.execSQL(
				"insert into joke( name, icon , text , favCount , buryCount , commentCount , shareCount , shareUrl ) values (?,?,?,?,?,?,?,?)",
				new String[] {joke.getS_name(), joke.getS_icon(), joke.getS_text(), joke.getI_favCount() + "", joke.getI_buryCount() + "", joke.getI_commentCount() + "", joke.getI_shareCount() + "", joke.getS_shareUrl()});
		db.close();
	}
	
	public  void deleteData() {
		
	}
	
	public void updateData() {
		
	}
	
	public List<Joke> selectData(int position, boolean is_clear) {
		//判断是否需要清空
		if(is_clear) {
			jokes.clear();
		}
		
		SQLiteDatabase db = sqlHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from joke order by id desc limit ? , 20", new String[] {position + ""});
		
		while (cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String icon = cursor.getString(cursor.getColumnIndex("icon"));
			String text = cursor.getString(cursor.getColumnIndex("text"));
			int favCount = cursor.getInt(cursor.getColumnIndex("favCount"));
			int buryCount = cursor.getInt(cursor.getColumnIndex("buryCount"));
			int commentCount = cursor.getInt(cursor.getColumnIndex("commentCount"));
			int shareCount = cursor.getInt(cursor.getColumnIndex("shareCount"));
			String shareUrl = cursor.getString(cursor.getColumnIndex("shareUrl"));
			
			Joke joke = new Joke(text, favCount, buryCount, commentCount, shareCount, name, icon, shareUrl);
			
			jokes.add(joke);
		}
		
		db.close();
		return jokes;
	}
}
