package com.example.horiavtev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager2 pager;
    TabLayout tab;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        carregaPager();
    }

    private void carregaPager() {
        FragmentManager manager = getSupportFragmentManager();
        adaptador = new Adaptador(manager, getLifecycle());
        pager.setAdapter(adaptador);
        carregaTab();
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tab.selectTab(tab.getTabAt(position));
            }
        });
    }

    private void carregaTab() {
        tab.addTab(tab.newTab().setText("Dados"));
        tab.addTab(tab.newTab().setText("Cálculo de Vida"));
        tab.setSelectedTabIndicatorColor(Color.parseColor("#52393C"));
        tab.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#52393C"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}