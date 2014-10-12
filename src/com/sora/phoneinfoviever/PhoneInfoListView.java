package com.sora.phoneinfoviever;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by justyn on 14-5-18.
 */
public class PhoneInfoListView extends ListView {

	private class PhoneInfoAdapter extends BaseAdapter
	{
		private Context mContext;
		private LayoutInflater mInflate;

		public PhoneInfoAdapter(Context context)
		{
			mContext = context;
			mInflate = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount()
		{
			return info_items.size();
		}

		public long getItemId(int pos)
		{
			return pos;
		}

		public Object getItem(int pos)
		{
			if (pos < 0 || pos >= getCount()) {
				return null;
			}

			return info_items.get(pos);
		}

		public View getView(int position, View convertView, ViewGroup parent)
		{
			convertView = mInflate.inflate(R.layout.phone_info_item, null);

			String[] item = (String[])getItem(position);

			if (null == convertView)
				return null;

			TextView txt_title = (TextView)convertView.findViewById(R.id.info_title);
			txt_title.setText(item[0]);
			TextView txt_detail = (TextView)convertView.findViewById(R.id.info_detail);
			txt_detail.setText(item[1]);


			return convertView;
		}
	}

	ArrayList<String[]> info_items;

	public PhoneInfoListView(Context context, ArrayList<String[]> infoItems)
	{
		super(context);
		info_items = infoItems;

		this.setAdapter(new PhoneInfoAdapter(context));
	}
}
