package com.awesome.tranbean.editchannellistdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.awesome.tranbean.editchannellistdemo.R;
import com.awesome.tranbean.editchannellistdemo.adapter.EditChannelListAdapter;
import com.awesome.tranbean.editchannellistdemo.bean.Channel;
import com.awesome.tranbean.editchannellistdemo.fragment.BaseFragment;

import java.util.ArrayList;

public class EditChannelListFragment extends BaseFragment {

    private static final int EDIT_CHANNEL_LIST_COUNT = 5+1;
    private ArrayList mData;
    private ListView editListView;
    private ArrayList editDatas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.edit_channel_list, null);
        editListView = inflate.findViewById(R.id.list_view);
        return inflate;
    }

    @Override
    protected void loadData() {
        this.editDatas = mContext.editDatas;
        initData();
        editListView.setAdapter(new EditChannelListAdapter(mContext, mData));
    }

    /**
     * データ整理
     */
    private void initData() {
        if (mData == null) {
            mData = new ArrayList();
        }
        for (int i = 1; i < EDIT_CHANNEL_LIST_COUNT; i++) {
            Channel channel = null;
            for (int j = 0; j < editDatas.size(); j++) {
                Channel channeltemp = (Channel) editDatas.get(j);
                if (Integer.parseInt(channeltemp.getIndex()) == i) {
                    channel = channeltemp;
                }
            }
            if (channel == null) {
                channel = new Channel();
            }
            mData.add(channel);
        }
    }
}
