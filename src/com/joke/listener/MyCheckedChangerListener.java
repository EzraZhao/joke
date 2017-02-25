package com.joke.listener;

import com.joke.frament.CheckFragment;
import com.joke.frament.DiscoveryFragment;
import com.joke.frament.HomeFragment;
import com.joke.frament.MessageFragment;
import com.lcu.joke.MainActivity;
import com.lcu.joke.R;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MyCheckedChangerListener implements OnCheckedChangeListener {
	
	MainActivity mainActivity;
	HomeFragment homeFrament;
	DiscoveryFragment discoveryFrament;
	CheckFragment checkFrament;
	MessageFragment messageFrament;
	
	//构造器解决
	public MyCheckedChangerListener(MainActivity mainActivity,
			HomeFragment homeFrament, DiscoveryFragment discoveryFrament,
			CheckFragment checkFrament, MessageFragment messageFrament) {
		super();
		this.mainActivity = mainActivity;
		this.homeFrament = homeFrament;
		this.discoveryFrament = discoveryFrament;
		this.checkFrament = checkFrament;
		this.messageFrament = messageFrament;
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		
		//碎片管理
		FragmentManager fragmentManager =  mainActivity.getSupportFragmentManager();
		//开始事务
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		//隐藏所有碎片（忘写）
		if(homeFrament != null) {
			fragmentTransaction.hide(homeFrament);
		}
		if(discoveryFrament != null) {
			fragmentTransaction.hide(discoveryFrament);
		}
		if(checkFrament != null) {
			fragmentTransaction.hide(checkFrament);
		}
		if(messageFrament != null) {
			fragmentTransaction.hide(messageFrament);
		}
		
		switch (arg1) {
		case R.id.home:
			  if(homeFrament == null) {
				  homeFrament = new HomeFragment();
				  fragmentTransaction.add(R.id.container, homeFrament);
			  } else {
				  fragmentTransaction.show(homeFrament);
			  }
			break;
		case R.id.discovery:
			if(discoveryFrament == null) {
				  discoveryFrament = new DiscoveryFragment();
				  fragmentTransaction.add(R.id.container, discoveryFrament);
			  } else {
				  fragmentTransaction.show(discoveryFrament);
			  }
			break;
		case R.id.check:
			if(checkFrament == null) {
				  checkFrament = new CheckFragment();
				  fragmentTransaction.add(R.id.container, checkFrament);
			  } else {
				  fragmentTransaction.show(checkFrament);
			  }
			break;
		case R.id.message:
			if(messageFrament == null) {
				  messageFrament = new MessageFragment();
				  fragmentTransaction.add(R.id.container, messageFrament);
			  } else {
				  fragmentTransaction.show(messageFrament);
			  }	
			break;
		default:
			break;
		}
		fragmentTransaction.commit();
	}
}

