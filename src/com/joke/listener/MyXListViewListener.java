package com.joke.listener;

import java.util.List;

import android.content.Context;

import com.joke.adapter.MyListViewAdapter;
import com.joke.bean.Joke;
import com.joke.db.SQLUtils;
import com.joke.frament.JokeFragment;

import me.maxwin.view.XListView;
import me.maxwin.view.XListView.IXListViewListener;

public class MyXListViewListener implements IXListViewListener{

	JokeFragment fragment;
	SQLUtils sqlUtils;
	List<Joke> jokes;
	int currentPosition = 0;
	XListView listView;
	Context context;
	public MyXListViewListener(JokeFragment fragment, Context context, XListView listView) {
		this.fragment = fragment;
		sqlUtils = new SQLUtils(context);
		this.listView = listView;
		this.context = context;
	}
	
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		fragment.getNetData();
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		currentPosition = currentPosition + 20;
		jokes = sqlUtils.selectData(currentPosition, false);
		listView.setAdapter(new MyListViewAdapter(context, jokes));
	}

}
