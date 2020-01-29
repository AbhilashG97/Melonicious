package abhilash.example.com.melonicious.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.facebook.stetho.Stetho;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import abhilash.example.com.melonicious.R;
import abhilash.example.com.melonicious.SettingsActivity;
import abhilash.example.com.melonicious.addmentee.AddMenteeFragment;
import abhilash.example.com.melonicious.viewmentee.ViewMenteeFragment;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean mDoubleBackToExitPressedOnce = false;
    private DashboardViewModel viewModel;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(DashboardActivity.this,R.color.colorPrimary));


        viewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        initializeStetho();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        startDashboardMainFragment();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int id = menuItem.getItemId();
            switch (id){
                case R.id.nav_dashboard:
                    loadFragment(new MainDashboardFragment());
                    return true;
                case R.id.nav_add_user:
                    loadFragment(new AddMenteeFragment());
                    return true;
                case R.id.nav_users:
                    loadFragment(new ViewMenteeFragment());
                    return true;
                case R.id.nav_stats:
                    loadFragment(new Fragment());
                    return true;
                default:
                    return false;
            }
        }
    };
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.framelayout_content,fragment)
                .addToBackStack(null)
                .commit();
    }

    private void initializeStetho() {
        Stetho.initializeWithDefaults(this);
    }

    private void startDashboardMainFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.framelayout_content, new MainDashboardFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();



        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 1) {
            fragmentManager.beginTransaction()
                    .replace(R.id.framelayout_content, new MainDashboardFragment())
                    .addToBackStack(null)
                    .commit();

            super.onBackPressed();
            if (mDoubleBackToExitPressedOnce) {
                super.onBackPressed();
                this.finish();
            }

            this.mDoubleBackToExitPressedOnce = true;

            try {
                Snackbar.make(findViewById(R.id.main_fragment_coordinator), R.string.action_exit,
                        Snackbar.LENGTH_SHORT).show();
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    mDoubleBackToExitPressedOnce = false;
                }
            }, 2000);

        } else {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
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
            Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            fragment = new MainDashboardFragment();
        } else if (id == R.id.nav_add_user) {
            fragment = new AddMenteeFragment();
        } else if (id == R.id.nav_users) {
            fragment = new ViewMenteeFragment();
        } else if (id == R.id.nav_stats) {
            fragment = new Fragment();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.framelayout_content, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();


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
