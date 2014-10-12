package com.sora.phoneinfoviever;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class PhoneInfoViewerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		ArrayList<String[]> infos = loadPhoneInfo();

		PhoneInfoListView info_view = new PhoneInfoListView(this, infos);

		setContentView(info_view);

//		RequestQueue queue = Volley.newRequestQueue(this);
//		StringRequest stringRequest = new StringRequest("http://www.baidu.com", new Response.Listener<String>() {
//			@Override
//			public void onResponse(String s) {
//				Log.d("houyuqi", "recevei string: " + s);
//			}
//		}, new Response.ErrorListener() {
//			@Override
//			public void onErrorResponse(VolleyError volleyError) {
//			}
//		});
//
//	    queue.add(stringRequest);
	}

	protected ArrayList<String[]> loadPhoneInfo()
	{
		ArrayList<String[]> infos = new ArrayList<String[]>(10);

		DisplayMetrics dm = getResources().getDisplayMetrics();

		String[] item = new String[2];

		// screen size
		String info_title = getResources().getString(R.string.info_size);
		item[0] = info_title;
		item[1] = dm.widthPixels + "*" + dm.heightPixels;
		infos.add(item);

		item = new String[2];
		info_title = getResources().getString(R.string.info_density);
		item[0] = info_title;
		item[1] = dm.density + "";
		infos.add(item);

		item = new String[2];
		info_title = getString(R.string.info_density_dpi);
		item[0] = info_title;
		item[1] = dm.densityDpi + "";
		infos.add(item);

		item = new String[2];
		info_title = getString(R.string.info_scaled_density);
		item[0] = info_title;
		item[1] = dm.scaledDensity + "";
		infos.add(item);

		item = new String[2];
		info_title = getString(R.string.info_xdpi);
		item[0] = info_title;
		item[1] = dm.xdpi + "";
		infos.add(item);

		item = new String[2];
		info_title = getString(R.string.info_ydpi);
		item[0] = info_title;
		item[1] = dm.ydpi + "";
		infos.add(item);

		return infos;
	}
}
