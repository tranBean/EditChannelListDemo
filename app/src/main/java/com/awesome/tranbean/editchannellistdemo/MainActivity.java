package com.awesome.tranbean.editchannellistdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.awesome.tranbean.editchannellistdemo.adapter.EditChannelListAdapter;
import com.awesome.tranbean.editchannellistdemo.bean.Channel;
import com.awesome.tranbean.editchannellistdemo.fragment.ChannelListFragment;
import com.awesome.tranbean.editchannellistdemo.fragment.EditChannelListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements EditChannelListAdapter.EditItemImpl {

    public ViewPager mViewPager;
    private List mFragmentList = new ArrayList();
    public ChannelListFragment channelListFragment;
    public EditChannelListFragment editChannelListFragment;
    public ArrayList editDatas = new ArrayList();
    public ArrayList channelDatas = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDataFromServer();
    }

    /**
     * サーバからデータ取得
     */
    private void initDataFromServer() {
        Channel channelg1 = new Channel();
        channelg1.setIndex("1");
        channelg1.setService_id("g1");
        channelg1.setTitle("FOX HD");
        Channel channelg3 = new Channel();
        channelg3.setIndex("3");
        channelg3.setService_id("g3");
        channelg3.setTitle("FOX HD3");
        editDatas.add(channelg1);
        editDatas.add(channelg3);
    }

    /**
     * view 初期化
     */
    private void initView() {
        mViewPager = findViewById(R.id.edit_channel_list_vp);
        editChannelListFragment = new EditChannelListFragment();
        channelListFragment = new ChannelListFragment();
        mFragmentList.add(editChannelListFragment);
        mFragmentList.add(channelListFragment);
        mViewPager.setAdapter(new EditChannelListPageAdapter(getSupportFragmentManager(), mFragmentList));
    }

    /**
     * 選択中アイテム
     * @param position
     * @param channel
     */
    @Override
    public void onAddItem(int position, Channel channel) {
        System.out.println();
    }

    /**
     * viewpager アダプター
     */
    private class EditChannelListPageAdapter extends FragmentStatePagerAdapter {
        private List fragmentList;

        public EditChannelListPageAdapter(FragmentManager fm, List fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return (Fragment) fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

    /**
     * backKey 処理
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (mViewPager.getCurrentItem() == 1
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            mViewPager.setCurrentItem(0);
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

}
