package com.awesome.tranbean.editchannellistdemo.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.awesome.tranbean.editchannellistdemo.MainActivity;
import com.awesome.tranbean.editchannellistdemo.R;
import com.awesome.tranbean.editchannellistdemo.bean.Channel;

import java.util.ArrayList;


public class EditChannelListAdapter extends BaseAdapter implements View.OnClickListener {

    private final MainActivity context;
    private final ArrayList list;
    private final EditItemImpl mEditItemImpl;

    public EditChannelListAdapter(MainActivity context, ArrayList list) {
        this.context = context;
        this.list = list;
        this.mEditItemImpl = context;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.edit_channel_list_item, null);
        Button button = inflate.findViewById(R.id.button);
        TextView title = inflate.findViewById(R.id.title);
        Bundle bundle = new Bundle();
        bundle.putInt("position",i);
        bundle.putString("service_id",channel.getService_id());
        bundle.putString("index",channel.getIndex());
        bundle.putString("title",channel.getTitle());
        button.setTag(bundle);
        button.setOnClickListener(EditChannelListAdapter.this);
        title.setText(channel.getTitle());
        return inflate;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            requestEditView(view);
        }
    }

    private void requestEditView(View view) {
        context.mViewPager.setCurrentItem(1);
        Bundle bundle = (Bundle) view.getTag();
        int position = bundle.getInt("position");
        String service_id = bundle.getString("service_id");
        String index = bundle.getString("index");
        String title = bundle.getString("title");
        Channel channel = new Channel();
        channel.setIndex(index);
        channel.setService_id(service_id);
        channel.setTitle(title);
        if (mEditItemImpl != null) {
            mEditItemImpl.onAddItem(position, channel);
        }
    }

    public interface EditItemImpl {
        void onAddItem(int position, Channel channel);
    }
}
