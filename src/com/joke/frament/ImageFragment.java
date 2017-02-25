package com.joke.frament;

import com.joke.http.MyRequestCallBack;
import com.lcu.joke.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ImageFragment extends Fragment{
	
	ListView listView;
	public static final String IMAGE_URL = "http://ic.snssdk.com/2/essay/zone/category/data/?category_id=2&level=6&count=30";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.fragment_image, null);
		
		listView =  (ListView) view.findViewById(R.id.lv_image_details);
		//联网
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, ImageFragment.IMAGE_URL, new MyRequestCallBack<String>(getActivity(), listView));
		
		return view;
	}
}
