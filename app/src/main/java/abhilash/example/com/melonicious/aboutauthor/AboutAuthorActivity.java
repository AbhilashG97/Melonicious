package abhilash.example.com.melonicious.aboutauthor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.adapters.AboutAuthorViewPagerAdapter;

public class AboutAuthorActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_author);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabs_view_repositories);
        viewPager = findViewById(R.id.pager_about_author);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setSelectedTabIndicatorColor(getColor(R.color.red));

        AboutAuthorViewPagerAdapter pagerAdapter =
                new AboutAuthorViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Skill Set");
        tabLayout.getTabAt(1).setText("Achievements");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tabLayout.getTabAt(tab.getPosition()).select();
                tabLayout.setScrollPosition(tab.getPosition(), 0f, true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

    }
}
