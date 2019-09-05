package abhilash.example.com.melonicious.dashboard;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.adapters.DashboardViewPagerAdapter;
import abhilash.example.com.melonicious.addmentee.AddMenteeActivity;
import abhilash.example.com.melonicious.dashboard.dashboardfragments.awesomelist.AwesomeListFragment;
import abhilash.example.com.melonicious.dashboard.dashboardfragments.naughtylist.NaughtListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainDashboardFragment extends Fragment {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FloatingActionButton fab;

    public MainDashboardFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_dashboard, container, false);

        viewPager = view.findViewById(R.id.viewpager_dashboard);
        tabLayout = view.findViewById(R.id.tablayout_dashboard);
        fab = view.findViewById(R.id.fab);


        initializeViewPager();
        tabLayout.setupWithViewPager(viewPager);
        onFABClicked();
        Toast.makeText(getContext(), "This is the DashboardFragment", Toast.LENGTH_LONG)
                .show();
        return view;
    }

    private void initializeViewPager() {
        DashboardViewPagerAdapter viewPagerAdapter =
                new DashboardViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new NaughtListFragment(),
                getResources().getString(R.string.naughty_list));
        viewPagerAdapter.addFragment(new AwesomeListFragment(),
                getResources().getString(R.string.awesome_list));
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void onFABClicked() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddMenteeActivity.class));
            }
        });
    }

}
