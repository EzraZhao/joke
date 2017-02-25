package com.joke.listener;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MyPageChangeListener implements OnPageChangeListener{
	
	RadioGroup radioGroup;
	
	public MyPageChangeListener(RadioGroup radioGroup) {
		super();
		this.radioGroup = radioGroup;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		
		RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);
		radioButton.setChecked(true);
	}
	
}
