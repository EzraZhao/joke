package com.joke.adapter;

import java.util.List;

import com.joke.bean.Joke;
import com.lcu.joke.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListViewAdapter extends BaseAdapter {

	Context context;
	List<Joke> jokes;

	public MyListViewAdapter(Context context, List<Joke> jokes) {
		this.context = context;
		this.jokes = jokes;
	}

	//数量
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return jokes.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	//每一行的布局和内容
	//只执行当前显示的
	//convertView 内容的复用
	@Override
	public View getView(int position, View converView, ViewGroup parent) {
		// TODO Auto-generated method stub

		View view = View.inflate(context, R.layout.joke_listview, null);
		// 头像
		ImageView userIcon = (ImageView) view.findViewById(R.id.iv_icon);
		//xutils
//		BitmapUtils bitmapUtils=new BitmapUtils(context);
//		bitmapUtils.display(usericonView,jokes.get(position).getUserIcon() );
		//picasso
		Picasso.with(context).load(jokes.get(position).getS_icon()).into(userIcon);
		// 用户姓名
		TextView userNameView = (TextView) view.findViewById(R.id.tv_name);
		userNameView.setText(jokes.get(position).getS_name() + "");
		// 内容
		TextView content = (TextView) view.findViewById(R.id.tv_content);
		content.setText(jokes.get(position).getS_text() + "");
		// 点赞数
		TextView favCount = (TextView) view.findViewById(R.id.tv_favCount);
		favCount.setText(jokes.get(position).getI_favCount() + "");
		//点赞效果
		TextView favAddOne = (TextView) view.findViewById(R.id.tv_add_fav);
		favCount.setOnClickListener(new MyChenkedAdapter(context, favAddOne, jokes, position));
		// 倒彩数
		TextView buryCount = (TextView) view.findViewById(R.id.tv_buryCount);
		buryCount.setText(jokes.get(position).getI_buryCount() + "");
		//踩效果
		TextView buryAddOne = (TextView) view.findViewById(R.id.tv_add_bury);
		buryCount.setOnClickListener(new MyChenkedAdapter(context, buryAddOne, jokes, position));
		// 评论数
		TextView commentCount = (TextView) view.findViewById(R.id.tv_commentCount);
		commentCount.setText(jokes.get(position).getI_commentCount() + "");
		// 分享数
		TextView shareCount = (TextView) view.findViewById(R.id.tv_shareCount);
		shareCount.setText(jokes.get(position).getI_shareCount() + "");
		// 注册点击分享事件监听器
		shareCount.setOnClickListener(new MyChenkedAdapter(context, jokes, position));

		return view;
	}

}
