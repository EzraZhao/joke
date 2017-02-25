package com.joke.http;

import android.content.Context;
import android.widget.ListView;

import com.google.gson.Gson;
import com.joke.adapter.ImageListAdapter;
import com.joke.bean.Image;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

public class MyRequestCallBack<T> extends RequestCallBack<String> {

	Context context;
	ListView listView;
	
	public MyRequestCallBack(Context context, ListView listView) {
		super();
		this.context = context;
		this.listView = listView;
	}

	@Override
	public void onFailure(HttpException arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		String s = arg0.result;
		//json解析   gson 反射原理 映射
		Gson gson = new Gson();
		Image image = gson.fromJson(s, Image.class);

		
		listView.setAdapter(new ImageListAdapter(image, context));
	}

}
