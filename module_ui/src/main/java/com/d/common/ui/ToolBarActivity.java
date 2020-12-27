package com.d.common.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.d.lib.common.util.ViewHelper;
import com.d.lib.common.widget.SegmentView;
import com.d.lib.common.widget.btb.BottomBar;
import com.d.lib.common.widget.tab.ScrollTab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolBarActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_ui_activity_toolbar);
        initView();
    }

    private void initView() {
        ViewHelper.setOnClickListener(this, this, R.id.iv_title_left);

        initBtBar();

        initSegment();

        ScrollTab[] scrollTab0 = new ScrollTab[]{(ScrollTab) findViewById(R.id.stab_tab00), (ScrollTab) findViewById(R.id.stab_tab01), (ScrollTab) findViewById(R.id.stab_tab02)};
        ScrollTab[] scrollTab1 = new ScrollTab[]{(ScrollTab) findViewById(R.id.stab_tab10), (ScrollTab) findViewById(R.id.stab_tab11), (ScrollTab) findViewById(R.id.stab_tab12)};
        ViewPager pager0 = (ViewPager) findViewById(R.id.pager0);
        ViewPager pager1 = (ViewPager) findViewById(R.id.pager1);
        initScrollTab(scrollTab0, pager0, Arrays.asList("Kitkat", "Lollipop", "M"));
        initScrollTab(scrollTab1, pager1, Arrays.asList("Peach", "Lemon", "Watermelon", "Pear", "Avocado",
                "Banana", "Grape", "Apricot", "Orange", "Kumquat"));
    }

    private void initBtBar() {
        BottomBar[] btbBars = new BottomBar[]{ViewHelper.findViewById(this, R.id.btb_bar0),
                ViewHelper.findViewById(this, R.id.btb_bar1),
                ViewHelper.findViewById(this, R.id.btb_bar2),
                ViewHelper.findViewById(this, R.id.btb_bar3)};
        btbBars[0].create(Arrays.asList(new BottomBar.Item(BottomBar.Item.TYPE_SHARE, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_share)),
                new BottomBar.Item(BottomBar.Item.TYPE_DOWNLOAD, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_download))), new BottomBar.OnClickListener() {
            @Override
            public void onClick(int position, BottomBar.Item item) {

            }
        });
        btbBars[1].create(Arrays.asList(new BottomBar.Item(BottomBar.Item.TYPE_SHARE, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_share)),
                new BottomBar.Item(BottomBar.Item.TYPE_DOWNLOAD, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_download)),
                new BottomBar.Item(BottomBar.Item.TYPE_MOVE, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_move))
        ), new BottomBar.OnClickListener() {
            @Override
            public void onClick(int position, BottomBar.Item item) {

            }
        });
        btbBars[2].create(Arrays.asList(new BottomBar.Item(BottomBar.Item.TYPE_SHARE, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_share)),
                new BottomBar.Item(BottomBar.Item.TYPE_DOWNLOAD, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_download)),
                new BottomBar.Item(BottomBar.Item.TYPE_MOVE, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_move)),
                new BottomBar.Item(BottomBar.Item.TYPE_DELETE, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_delete)),
                new BottomBar.Item(BottomBar.Item.TYPE_RENAME, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_rename)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_info))), new BottomBar.OnClickListener() {
            @Override
            public void onClick(int position, BottomBar.Item item) {

            }
        });
        btbBars[3].create(Arrays.asList(new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label)),
                new BottomBar.Item(BottomBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, getResources().getString(R.string.module_ui_label))), new BottomBar.OnClickListener() {
            @Override
            public void onClick(int position, BottomBar.Item item) {

            }
        });
    }

    private void initSegment() {
        SegmentView svTab0 = (SegmentView) findViewById(R.id.sv_tab0);
        svTab0.setTitles(Arrays.asList(getResources().getString(R.string.module_ui_label1),
                getResources().getString(R.string.module_ui_label2)));
    }

    private void initScrollTab(ScrollTab[] tabs, final ViewPager pager, List<String> titles) {
        final ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            TabFragment fragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragments.get(arg0);
            }
        };
        pager.setOffscreenPageLimit(titles.size() - 1);
        pager.setAdapter(fragmentPagerAdapter);
        pager.addOnPageChangeListener(this);
        for (ScrollTab tab : tabs) {
            tab.setTitles(titles);
            tab.setNumber(1, "9", View.VISIBLE);//Set the red dot
            tab.setViewPager(pager);
            tab.setOnTabListener(new ScrollTab.OnTabListener() {
                @Override
                public void onChange(int index, View v) {
                    pager.setCurrentItem(index, true);
                }
            });
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public static class TabFragment extends Fragment {
        private View rootView;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            if (rootView == null) {
                rootView = new TextView(getActivity());
                rootView.setId(R.id.tv_content);
            } else {
                if (rootView.getParent() != null) {
                    ((ViewGroup) rootView.getParent()).removeView(rootView);
                }
            }
            init();
            return rootView;
        }

        private void init() {
            TextView tvContent = (TextView) rootView.findViewById(R.id.tv_content);
            tvContent.setGravity(Gravity.CENTER);
            tvContent.setText(getArguments() != null ? "" + getArguments().getInt("index") : "");
        }
    }
}
