package com.joke.adapter;

import java.util.ArrayList;
import java.util.List;

import com.joke.frament.BookFragment;
import com.joke.frament.ImageFragment;
import com.joke.frament.JokeFragment;
import com.joke.frament.RecommendFragment;
import com.joke.frament.VideoFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter{
	
	List<Fragment>fragments = new ArrayList<Fragment>();
		
	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
		
		RecommendFragment recommendFragment = new RecommendFragment();
		VideoFragment videoFragment = new VideoFragment();
		ImageFragment imageFragment = new ImageFragment();
		JokeFragment jokeFragment = new JokeFragment();
		BookFragment bookFragment = new BookFragment();
		
		fragments.add(recommendFragment);
		fragments.add(videoFragment);
		fragments.add(imageFragment);
		fragments.add(jokeFragment);
		fragments.add(bookFragment);
			
	}
	//获取某一页
	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return fragments.get(position);
	}
	//数量
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

}
