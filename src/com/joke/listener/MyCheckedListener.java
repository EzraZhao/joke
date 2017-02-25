package com.joke.listener;

import com.lcu.joke.R;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MyCheckedListener implements OnCheckedChangeListener{

	ViewPager viewPager;
	
	public MyCheckedListener(ViewPager viewPager) {
		super();
		this.viewPager = viewPager;
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checked) {
		// TODO Auto-generated method stub
		
		switch (checked) {
		case R.id.recommend:
			viewPager.setCurrentItem(0, false);
			break;
		case R.id.video:
			viewPager.setCurrentItem(1, false);
			break;
		case R.id.image:
			viewPager.setCurrentItem(2, false);
			break;
		case R.id.joke:
			viewPager.setCurrentItem(3, false);
			break;
		case R.id.book:
			viewPager.setCurrentItem(4, false);
			break;
		default:
			break;
		}
		
	}

}
