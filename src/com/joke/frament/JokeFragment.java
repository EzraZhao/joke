package com.joke.frament;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.XListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.joke.adapter.MyListViewAdapter;
import com.joke.bean.Joke;
import com.joke.db.SQLUtils;
import com.joke.listener.MyXListViewListener;
import com.lcu.joke.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class JokeFragment extends Fragment {

	XListView listView;
	List<Joke> jokes;
	SwipeRefreshLayout swipeRefreshLayout;
	SQLUtils sqlUtils;
	int currentPosition = 0;

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 2) {
				// 加载listview
				
				jokes = sqlUtils.selectData(currentPosition, true);
				
				listView.setAdapter(new MyListViewAdapter(getActivity(), jokes));
				//下拉刷新上拉加载
//				swipeRefreshLayout.setRefreshing(false);		停止刷新
				onLoad();
			}
		};
	};

	private void onLoad() {
		listView.stopRefresh();
		listView.stopLoadMore();
		listView.setRefreshTime(getLastUpdateTime());
	}
	
	private String getLastUpdateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(System.currentTimeMillis());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = inflater.inflate(R.layout.fragment_joke, null);
		sqlUtils = new SQLUtils(getActivity());
		listView = (XListView) view.findViewById(R.id.lv_joke_details);
		
		getNetData();
		//侧滑界面
//		swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh);
//		swipeRefreshLayout.setColorScheme(R.color.a, R.color.b, R.color.c, R.color.d);
//		swipeRefreshLayout.setOnRefreshListener(new MyRefershAdapter(this));

		
		listView.setXListViewListener(new MyXListViewListener(this,getActivity(),listView));
		listView.setPullLoadEnable(true);
		

		return view;
	}

	// 联网方式
	// HttpUrlconnection HttpClient锛坅pache锛�
	// 绗笁鏂箈uitls volley okhttp asyncHttpClient-->github

	public void getNetData() {
		// 开线程
		new Thread() {
			public void run() {
				try {
					URL url = new URL(
							"http://ic.snssdk.com/2/essay/zone/category/data/?category_id=1&level=6&count=30");
					// 鎵撳紑閾炬帴
					HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
					// httpURLConnection.setConnectTimeout(timeoutMillis);
					// httpURLConnection.setDoInput(newValue);
					// httpURLConnection.setDoOutput(newValue);
					// 杩炴帴
					httpURLConnection.connect();

					// 娴� 杈撳叆娴佽緭鍑烘祦/楂樼骇娴佷綆绾ф祦/瀛楄妭娴侊紙Stream锛夊瓧绗︽祦锛圧eader锛�
					InputStream inputStream = httpURLConnection.getInputStream();
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

					String str_message = null;
					StringBuffer stringBuffer = new StringBuffer();
					while ((str_message = bufferedReader.readLine()) != null) {
						stringBuffer.append(str_message);
					}

					parseJson(stringBuffer.toString());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}.start();
	}

	public void parseJson(String json) {
		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONObject jb_data = jsonObject.getJSONObject("data");
			String s_tip = jb_data.getString("tip");
			JSONArray ja_data = jb_data.getJSONArray("data");
			for (int i = 0; i < ja_data.length(); i++) {
				JSONObject jsonObject2 = ja_data.getJSONObject(i);
				if (jsonObject2.has("group")) {
					JSONObject js_group = jsonObject2.getJSONObject("group");
					String s_text = js_group.getString("text");
					int i_favCount = js_group.getInt("favorite_count");
					int i_commentCount = js_group.getInt("comment_count");
					int i_shareCount = js_group.getInt("share_count");
					int i_buryCount = js_group.getInt("bury_count");
					
					String s_shareUrl = js_group.getString("share_url");
							
					JSONObject js_user = js_group.getJSONObject("user");
					String s_name = js_user.getString("name");
					String s_icon = js_user.getString("avatar_url");

					// 灏佽
//					Joke joke = new Joke(s_text, i_favCount, i_commentCount,
//							i_shareCount, i_buryCount, s_name, s_icon);
					
					Joke joke = new Joke();
					joke.setS_icon(s_icon);
					joke.setS_name(s_name);
					joke.setS_text(s_text);
					joke.setI_favCount(i_favCount);
					joke.setI_buryCount(i_buryCount);
					joke.setI_commentCount(i_commentCount);
					joke.setI_shareCount(i_shareCount);
					joke.setS_shareUrl(s_shareUrl);
					
					SQLUtils sqlUtils = new SQLUtils(getActivity());
					sqlUtils.addData(joke);

					//jokes.add(joke);
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// handler.sendEmptyMessage(2);

		// 发送消息
		Message msg = new Message();
		msg.what = 2;
		// 鍙惡甯︽秷鎭被鍨�
		// msg.arg1 = 1;
		// msg.arg2 = 3;
		// msg.obj = "xxx";
		handler.sendMessage(msg);
	}

}
