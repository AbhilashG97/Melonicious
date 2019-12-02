package abhilash.example.com.melonicious;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import abhilash.example.com.melonicious.dashboard.DashboardActivity;

public class SplashScreen extends AppCompatActivity {

    private static boolean splashLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!splashLoaded)
        {
            setContentView(R.layout.activity_splash_screen);
            int secondDelayed = 1;
            new Handler().postDelayed(() -> {
                startActivity(new Intent(SplashScreen.this,DashboardActivity.class));
                finish();
            }, secondDelayed*500);
            splashLoaded=true;
        }
        else
        {
            Intent goToMainActivity = new Intent(SplashScreen.this ,DashboardActivity.class );
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMainActivity);
            finish();
        }

    }



}
