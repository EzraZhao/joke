package com.joke.adapter;

import java.util.List;

import com.joke.bean.Joke;
import com.lcu.joke.R;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MyChenkedAdapter implements OnClickListener {

	Context context;
	TextView view;
	List<Joke> jokes;
	int position;

	public MyChenkedAdapter(Context context, TextView view, List<Joke> jokes, int position) {
		this.context = context;
		this.view = view;
		this.jokes = jokes;
		this.position = position;
	}
	
	public MyChenkedAdapter(Context context, List<Joke> jokes, int position) {
		this.context = context;
		this.jokes = jokes;
		this.position = position;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Animation anim = AnimationUtils.loadAnimation(context, R.anim.addone_anim);

		switch (v.getId()) {
		case R.id.tv_favCount:
			view.startAnimation(anim);
			jokes.get(position).setI_favCount(jokes.get(position).getI_favCount() + 1);
			((TextView)v).setText(jokes.get(position).getI_favCount() + "");
			break;
		case R.id.tv_buryCount:
			view.startAnimation(anim);
			jokes.get(position).setI_buryCount(jokes.get(position).getI_buryCount() + 1);
			((TextView)v).setText(jokes.get(position).getI_buryCount() + "");
			break;
		case R.id.tv_commentCount:
			
			break;
		case R.id.tv_shareCount:
			showShare();
			break;
		default:
			break;
		}
		

	}

	private void showShare() {
		ShareSDK.initSDK(context);
		OnekeyShare oks = new OnekeyShare();
		// 关闭sso授权
		oks.disableSSOWhenAuthorize();

		// 分享时Notification的图标和文字 2.5.9以后的版本不调用此方法
		//oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle("xxx");
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		//oks.setTitleUrl(jokes.get(position).getS_shareUrl());
		// text是分享文本，所有平台都需要这个字段
		oks.setText(jokes.get(position).getS_text());
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		oks.setImagePath("/sdcard/test.jpg");// 确保SDcard下面存在此张图片
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl("http://www.baidu.com");
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("我是测试评论文本");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite("内涵段子");
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl(jokes.get(position).getS_shareUrl());

		// 启动分享GUI
		oks.show(context);
	}
}
