package com.zero.mybody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zero.mybody.bean.CategoryItemResult;
import com.zero.mybody.bean.CategoryItemResult.CategoryItem;

import java.util.List;

/**
 *
 * Created by zero on 16-9-19.
 */
public class CategoryItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<CategoryItemResult.CategoryItem> mList;

    public CategoryItemAdapter(Context context, List<CategoryItem> list) {
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
        CategoryItem item = mList.get(position);

        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.page_lv_item, null);
            holder.img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.descriptionTv = (TextView) convertView.findViewById(R.id.item_description_tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.descriptionTv.setText(item.getDescription());
        Glide.with(mContext).load(HttpManager.IMG_URL+item.getImg()).into(holder.img);
        return convertView;
    }

    public void setList(List<CategoryItem> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    private static class Holder {
        ImageView img;
        TextView descriptionTv;
    }
}
