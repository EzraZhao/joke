package com.joke.frament;

import com.joke.adapter.MyPagerAdapter;
import com.joke.listener.*;
import com.lcu.joke.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class HomeFragment extends Fragment{
	
	ViewPager viewPager;
	RadioGroup radioGroup;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//加载碎片
		View view = inflater.inflate(R.layout.fragment_home, null);
		
		radioGroup = (RadioGroup)view.findViewById(R.id.rg_home);
		
		viewPager = (ViewPager) view.findViewById(R.id.vp_home);
		
		radioGroup.setOnCheckedChangeListener(new MyCheckedListener(viewPager));
		//viewpage 5个fragment
		//adapter适配器
		//getSupportFragmentManager()  getChildFragmentManager() 碎片中包含碎片 
		//getFragmentManager()  区别stack overflow
		
		viewPager.setOnPageChangeListener(new MyPageChangeListener(radioGroup));
		
		viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
		return view;
	}
	
}
