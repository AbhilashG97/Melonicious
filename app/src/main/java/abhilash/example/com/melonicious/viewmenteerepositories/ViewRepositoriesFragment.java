package abhilash.example.com.melonicious.viewmenteerepositories;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.adapters.ViewMenteeRepositoriesPagerAdapter;
import abhilash.example.com.melonicious.model.Mentee;

public class ViewRepositoriesFragment extends Fragment implements AppBarLayout.OnOffsetChangedListener {

    private ViewPager viewRepositoriesViewPager;
    private ViewRepositoriesViewModel mViewModel;
    private Mentee mentee;
    private Context context;

    public ViewRepositoriesFragment() {
        //Default constructor
    }

    public ViewRepositoriesFragment(Mentee mentee) {
        this.mentee = mentee;
    }

    public ViewRepositoriesFragment(Mentee mentee, Context context) {
        this.mentee = mentee;
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_repositories_fragment, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tabs_view_repositories);
        viewRepositoriesViewPager = view.findViewById(R.id.pager_view_repositories);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setSelectedTabIndicatorColor(getActivity().getResources().getColor(R.color.red));

        ViewMenteeRepositoriesPagerAdapter pagerAdapter
                = new ViewMenteeRepositoriesPagerAdapter(getActivity().getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewRepositoriesViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewRepositoriesViewPager);
        tabLayout.getTabAt(0).setText("Repositories");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewRepositoriesViewPager.setCurrentItem(tab.getPosition());
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

        return view;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

    }
}
