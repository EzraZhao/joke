package com.lcu.joke;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

public class ShowLargeImageActivity extends Activity {

	ImageView imageView;
	GifImageView myGifImageView;
	String url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_largeimage);

		imageView = (ImageView) findViewById(R.id.large_image);

		Intent intent = this.getIntent();
		int is_gif = intent.getIntExtra("is_gif", 0);
		url = intent.getStringExtra("uri");

		if (is_gif == 0) {
			Picasso.with(this).load(url).into(imageView);
		} else {
			myGifImageView = (GifImageView) findViewById(R.id.myGifView);
			new AsyncTask<Void, Void, byte[]>() {

				@Override
				protected byte[] doInBackground(Void... params) {
					byte[] gifbyte = null;
					HttpURLConnection conn = null;
					try {
						URL ur = new URL(url);
						conn = (HttpURLConnection) ur.openConnection();
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						InputStream in = conn.getInputStream();

						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = in.read(buffer)) > 0) {
							out.write(buffer, 0, len);
						}
						gifbyte = out.toByteArray();
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						conn.disconnect();
					}

					return gifbyte;

				}

				protected void onPostExecute(byte[] gifbyte) {

					// 判断是否是gif图
					Movie gif = Movie.decodeByteArray(gifbyte, 0, gifbyte.length);
					if (gif != null) {
						GifDrawable gifDrawable = null;
						try {
							gifDrawable = new GifDrawable(gifbyte);
						} catch (IOException e) {
							e.printStackTrace();
						}
						myGifImageView.setImageDrawable(gifDrawable);
					} else {
						Bitmap gifBitmap = BitmapFactory.decodeByteArray(gifbyte,
								0, gifbyte.length);
						myGifImageView.setImageBitmap(gifBitmap);
					}

				};

			}.execute();
		}

	}

}
