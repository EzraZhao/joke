package com.lcu.joke;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.joke.frament.CheckFragment;
import com.joke.frament.DiscoveryFragment;
import com.joke.frament.HomeFragment;
import com.joke.frament.MessageFragment;
import com.joke.listener.MyCheckedChangerListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;


public class MainActivity extends FragmentActivity {

	RadioGroup group;
	HomeFragment homeFrament;
	DiscoveryFragment discoveryFrament;
	CheckFragment checkFrament;
	MessageFragment messageFrament;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局
		setContentView(R.layout.activity_main);
		group = (RadioGroup) findViewById(R.id.rg_main);
		//碎片管理
		FragmentTransaction fragmentTransaction = MainActivity.this.getSupportFragmentManager().beginTransaction();
		
		//
		homeFrament = new HomeFragment();
		fragmentTransaction.add(R.id.container, homeFrament);
		fragmentTransaction.commit();
		
		//设置鼠标点击事件
		group.setOnCheckedChangeListener(new MyCheckedChangerListener(this, homeFrament, 
				discoveryFrament, checkFrament, messageFrament));
		
		
		//侧滑界面
		SlidingMenu slidingMenu = new SlidingMenu(this);
		//左右滑
		slidingMenu.setMode(slidingMenu.LEFT);
		//设置布局
		slidingMenu.setMenu(R.layout.menu);
		//���û�������Ļ��Χ
		slidingMenu.setTouchModeAbove(slidingMenu.TOUCHMODE_MARGIN);
		//边距
		slidingMenu.setBehindOffset(150);
		
		//绑定到主界面
		slidingMenu.attachToActivity(this, slidingMenu.SLIDING_WINDOW);
	}
	
}
