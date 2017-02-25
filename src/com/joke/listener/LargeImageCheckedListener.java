package com.joke.listener;

import com.joke.bean.Image;
import com.lcu.joke.ShowLargeImageActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class LargeImageCheckedListener implements OnClickListener {

	Image image;
	Context context;
	int position;

	public LargeImageCheckedListener(Image image, Context context, int position) {
		super();
		this.image = image;
		this.context = context;
		this.position = position;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		Intent intent = new Intent();
		intent.setClass(context, ShowLargeImageActivity.class);
		intent.putExtra("is_gif", image.data.data.get(position).group.is_gif);
		intent.putExtra("uri",
				"http://p5a.pstatp.com/"
						+ image.data.data.get(position).group.large_image.uri);

		// 启动activity
		context.startActivity(intent);
	}

}
