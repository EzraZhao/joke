package com.joke.adapter;

import com.joke.frament.JokeFragment;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

public class MyRefershAdapter implements OnRefreshListener{

	JokeFragment jokeFragment;
	
	public MyRefershAdapter(JokeFragment jokeFragment) {
		this.jokeFragment = jokeFragment;
	}
	
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		jokeFragment.getNetData();
	}

}
