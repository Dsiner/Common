package com.d.common.component.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.d.lib.common.utils.ViewHelper;
import com.d.lib.common.view.SegementView;
import com.d.lib.common.view.tab.ScrollTab;

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
        setContentView(R.layout.component_ui_activity_toolbar);
        initView();
    }

    private void initView() {
        ViewHelper.setOnClick(this, this, R.id.iv_title_left);

        SegementView svTab0 = (SegementView) findViewById(R.id.sv_tab0);
        svTab0.setTitles(Arrays.asList(getResources().getString(R.string.component_ui_label1),
                getResources().getString(R.string.component_ui_label2)));

        ScrollTab[] scrollTab0 = new ScrollTab[]{(ScrollTab) findViewById(R.id.stab_tab00), (ScrollTab) findViewById(R.id.stab_tab01), (ScrollTab) findViewById(R.id.stab_tab02)};
        ScrollTab[] scrollTab1 = new ScrollTab[]{(ScrollTab) findViewById(R.id.stab_tab10), (ScrollTab) findViewById(R.id.stab_tab11), (ScrollTab) findViewById(R.id.stab_tab12)};
        ViewPager pager0 = (ViewPager) findViewById(R.id.pager0);
        ViewPager pager1 = (ViewPager) findViewById(R.id.pager1);
        initScrollTab(scrollTab0, pager0, Arrays.asList("Kitkat", "Lollipop", "M"));
        initScrollTab(scrollTab1, pager1, Arrays.asList("Peach", "Lemon", "Watermelon", "Pear", "Avocado",
                "Banana", "Grape", "Apricot", "Orange", "Kumquat"));
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
