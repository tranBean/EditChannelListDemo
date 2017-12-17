package com.awesome.tranbean.editchannellistdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.awesome.tranbean.editchannellistdemo.MainActivity;
import com.awesome.tranbean.editchannellistdemo.R;
import com.awesome.tranbean.editchannellistdemo.bean.Channel;

import java.util.ArrayList;


public class ChannelListAdapter extends BaseAdapter {

    private final MainActivity context;
    private final ArrayList list;

    public ChannelListAdapter(MainActivity context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Channel channel = (Channel) list.get(i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.channel_list_item, null);
        TextView title = inflate.findViewById(R.id.title);
        title.setText(channel.getTitle());
        return inflate;
    }
}
