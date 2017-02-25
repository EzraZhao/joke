package com.joke.adapter;

import com.joke.bean.Image;
import com.joke.listener.LargeImageCheckedListener;
import com.lcu.joke.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageListAdapter extends BaseAdapter {

	Image image;
	Context context;

	public ImageListAdapter(Image image, Context context) {
		super();
		this.image = image;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return image.data.data.size();
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

	// 每一行的布局和内容
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHander viewHander = null;
		// viewHolder优化

		if (convertView == null) {
			convertView = View.inflate(context, R.layout.image_listview, null);

			viewHander = new ViewHander();

			viewHander.test = (TextView) convertView
					.findViewById(R.id.tv_content);
			viewHander.name = (TextView) convertView.findViewById(R.id.tv_name);
			viewHander.favorite_count = (TextView) convertView
					.findViewById(R.id.tv_favCount);
			viewHander.bury_count = (TextView) convertView
					.findViewById(R.id.tv_buryCount);
			viewHander.comment_count = (TextView) convertView
					.findViewById(R.id.tv_commentCount);
			viewHander.avatar_url = (ImageView) convertView
					.findViewById(R.id.iv_icon);
			viewHander.middle_image = (ImageView) convertView
					.findViewById(R.id.iv_middle_image);
			// viewHander.middle_image = (ImageView)
			// convertView.findViewById(R.id.iv);

			convertView.setTag(viewHander);
		} else {

			viewHander = (ViewHander) convertView.getTag();

		}
		if (image.data.data.get(position).group != null) {
			viewHander.test.setText(image.data.data.get(position).group.text);
			viewHander.favorite_count
					.setText(image.data.data.get(position).group.favorite_count
							+ "");
			viewHander.bury_count
					.setText(image.data.data.get(position).group.bury_count
							+ "");
			viewHander.comment_count
					.setText(image.data.data.get(position).group.comment_count
							+ "");
			viewHander.name
					.setText(image.data.data.get(position).group.user.name);
			Picasso.with(context)
					.load(image.data.data.get(position).group.user.avatar_url)
					.into(viewHander.avatar_url);
			Picasso.with(context)
					.load("http://p5a.pstatp.com/"
							+ image.data.data.get(position).group.middle_image.uri)
					.into(viewHander.middle_image);
			viewHander.middle_image
					.setOnClickListener(new LargeImageCheckedListener(image,
							context, position));
		}

		return convertView;
	}

	class ViewHander {

		public TextView test;
		public TextView favorite_count;
		public TextView comment_count;
		public TextView bury_count;
		public TextView name;
		public ImageView avatar_url;
		public ImageView middle_image;
		public ImageView large_image;

	}

}
