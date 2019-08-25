package abhilash.example.com.melonicious.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.aboutauthor.AboutAuthorActivity;
import abhilash.example.com.melonicious.adapters.AboutAuthorViewPagerAdapter;
import abhilash.example.com.melonicious.adapters.DashboardViewPagerAdapter;
import abhilash.example.com.melonicious.dashboard.dashboardfragments.awesomelist.AwesomeListFragment;
import abhilash.example.com.melonicious.dashboard.dashboardfragments.naughtylist.NaughtListFragment;
import abhilash.example.com.melonicious.model.Mentee;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean mDoubleBackToExitPressedOnce = false;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DashboardViewModel viewModel;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager_dashboard);
        tabLayout = findViewById(R.id.tablayout_dashboard);
        fab = findViewById(R.id.fab);

        viewModel = ViewModelProviders.of(this,
                new DashboardViewModelFactory("AbhilashG97"))
                .get(DashboardViewModel.class);

        initializeViewPager();
        tabLayout.setupWithViewPager(viewPager);

        onFABClicked();
        observeViewModal();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void observeViewModal() {
        viewModel.getMenteeObservable().observe(this, new Observer<Mentee>() {
            @Override
            public void onChanged(Mentee mentee) {
                Log.i("FETCHED DATA", mentee.toString());
            }
        });
    }

    private void initializeViewPager() {
        DashboardViewPagerAdapter viewPagerAdapter =
                new DashboardViewPagerAdapter(getSupportFragmentManager());
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
                Snackbar.make(view, R.string.default_action, Snackbar.LENGTH_LONG)
                        .setAction(R.string.action, null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (mDoubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.mDoubleBackToExitPressedOnce = true;
            Snackbar.make(findViewById(R.id.main_activity_coordinator), R.string.action_exit,
                    Snackbar.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    mDoubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_add_user) {
            // add a user
        } else if (id == R.id.nav_users) {
            // show registered users
        } else if (id == R.id.nav_stats) {
            // show app stats
        } else if (id == R.id.nav_about) {
            showAboutDialog();
        } else if (id == R.id.nav_about_author) {
            startActivity(new Intent(this, AboutAuthorActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showAboutDialog() {
        AlertDialog.Builder aboutDialog = new AlertDialog.Builder(DashboardActivity.this);
        final View aboutDialogLayout = getLayoutInflater().inflate(R.layout.dialog_about, null);

        aboutDialog.setView(aboutDialogLayout);

        aboutDialog.setCancelable(true);
        AlertDialog about = aboutDialog.create();
        about.show();
    }

}
