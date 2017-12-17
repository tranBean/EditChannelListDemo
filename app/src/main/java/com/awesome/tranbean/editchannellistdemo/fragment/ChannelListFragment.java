package com.awesome.tranbean.editchannellistdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.awesome.tranbean.editchannellistdemo.MainActivity;
import com.awesome.tranbean.editchannellistdemo.R;
import com.awesome.tranbean.editchannellistdemo.adapter.ChannelListAdapter;
import com.awesome.tranbean.editchannellistdemo.bean.Channel;
import com.awesome.tranbean.editchannellistdemo.fragment.BaseFragment;

import java.util.ArrayList;

public class ChannelListFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ArrayList mData;
    private ListView mEditListView;
    private ArrayList mLocalData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.channel_list, null);
        mEditListView = inflate.findViewById(R.id.channel_list_select_view);
        mEditListView.setOnItemClickListener(this);
        return inflate;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Channel channel = (Channel) mData.get(i);
        Toast.makeText(getContext(), i + "         Index:" + channel.getIndex(), Toast.LENGTH_SHORT).show();
        mContext.mViewPager.setCurrentItem(0);
    }

    @Override
    protected void loadData() {
        initDataFromServer();
        mEditListView.setAdapter(new ChannelListAdapter(mContext, mData));
    }

    /**
     * データ整理
     */
    private void initDataFromServer() {
        if (mContext.channelDatas == null) {
            //this.mLocalData = mContext.channelDatas;
            mLocalData = new ArrayList();
        }

        ArrayList serverData = new ArrayList();

        Channel channelg1 = new Channel();
        channelg1.setIndex("1");
        channelg1.setService_id("g1");
        channelg1.setTitle("FOX HD");
        Channel channelg2 = new Channel();
        channelg2.setIndex("2");
        channelg2.setService_id("g2");
        channelg2.setTitle("FOX HD2");
        Channel channelg3 = new Channel();
        channelg3.setIndex("3");
        channelg3.setService_id("g3");
        channelg3.setTitle("FOX HD3");
        Channel channelg4 = new Channel();
        channelg4.setIndex("4");
        channelg4.setService_id("g4");
        channelg4.setTitle("FOX HD4");
        Channel channelg5 = new Channel();
        channelg5.setIndex("5");
        channelg5.setService_id("g5");
        channelg5.setTitle("FOX HD5");
        Channel channelf1 = new Channel();
        channelf1.setIndex("6");
        channelf1.setService_id("f1");
        channelf1.setTitle("SKY SPORT1");
        Channel channelf2 = new Channel();
        channelf2.setIndex("7");
        channelf2.setService_id("f2");
        channelf2.setTitle("SKY SPORT2");
        Channel channelf3 = new Channel();
        channelf3.setIndex("8");
        channelf3.setService_id("f3");
        channelf3.setTitle("SKY SPORT3");
        Channel channelf4 = new Channel();
        channelf4.setIndex("9");
        channelf4.setService_id("f4");
        channelf4.setTitle("SKY SPORT4");
        Channel channelf5 = new Channel();
        channelf5.setIndex("10");
        channelf5.setService_id("f5");
        channelf5.setTitle("SKY SPORT5");
        serverData.add(channelg1);
        serverData.add(channelg2);
        serverData.add(channelg3);
        serverData.add(channelg4);
        serverData.add(channelg5);
        serverData.add(channelf1);
        serverData.add(channelf2);
        serverData.add(channelf3);
        serverData.add(channelf4);
        serverData.add(channelf5);

        for (int i=0;i<serverData.size();i++) {
            if(!mLocalData.contains(serverData.get(i))){
                mLocalData.add(serverData.get(i));
            }
        }
        this.mData = mLocalData;
    }
}
