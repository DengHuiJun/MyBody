package com.zero.mybody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zero.mybody.bean.HttpResult;

import java.util.List;

/**
 * Created by zero on 16-9-19.
 */
public class CategoryAdapter extends BaseAdapter {
    private Context mContext;
    private List<HttpResult.TngouBean> mList;

    public CategoryAdapter(Context context, List<HttpResult.TngouBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        HttpResult.TngouBean tngouBean = mList.get(position);

        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.main_lv_item, null);
            holder.title = (TextView) convertView.findViewById(R.id.item_title);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.title.setText(tngouBean.getTitle());
        return convertView;
    }

    public void setList(List<HttpResult.TngouBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    private static class Holder {
        TextView title;
    }
}
