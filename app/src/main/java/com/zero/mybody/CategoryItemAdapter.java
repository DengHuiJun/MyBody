package com.zero.mybody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zero.mybody.jsonResult.CategoryItemResult;
import com.zero.mybody.jsonResult.CategoryItemResult.CategoryItem;
import com.zero.mybody.net.HttpManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by zero on 16-9-19.
 */
public class CategoryItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<CategoryItemResult.CategoryItem> mList;

    public interface OnCategoryClickListener {
        void onClickItem(int id);
    }

    private OnCategoryClickListener listener;

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
        final CategoryItem item = mList.get(position);

        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.page_lv_item, null);
            holder.itemLy = convertView.findViewById(R.id.item_ly);
            holder.img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.descriptionTv = (TextView) convertView.findViewById(R.id.item_description_tv);
            holder.timeTv = (TextView) convertView.findViewById(R.id.item_time_tv);
            holder.titleTv = (TextView) convertView.findViewById(R.id.item_title_tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.titleTv.setText(item.getTitle());
        holder.timeTv.setText(toTime(item.getTime()));
        holder.descriptionTv.setText(item.getDescription());

        holder.itemLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickItem(item.getId());
            }
        });

        Glide.with(mContext).load(HttpManager.IMG_URL+item.getImg()).into(holder.img);
        return convertView;
    }

    public void setList(List<CategoryItem> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    private static class Holder {
        View itemLy;
        ImageView img;
        TextView descriptionTv;
        TextView titleTv;
        TextView timeTv;
    }

    public void setOnCategoryClickListener(OnCategoryClickListener listener) {
        this.listener = listener;
    }

    private String toTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }
}
