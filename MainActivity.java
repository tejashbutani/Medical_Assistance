package tejashbutani.medicalassistance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;



import android.view.View;



import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity
{
    String s_mob;
    TextView maintxt;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainlayout);
        maintxt = findViewById(R.id.maintxt);
        //Bundle bundle = new Bundle();
        //String s_mob= bundle.getString("mob");
        SharedPreferences sharedPreferencesget = getSharedPreferences("key",MODE_PRIVATE);
        String secsh = sharedPreferencesget.getString("mob","default_data");
        s_mob= secsh;
        Animation bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_in);
        Animation rightInAnimation = AnimationUtils.loadAnimation(this,R.anim.right_in);
        Animation leftAnimation = AnimationUtils.loadAnimation(this,R.anim.left_in);
        leftAnimation.setDuration(1000);
        bottomAnimation.setDuration(1000);
        // registerLay.startAnimation(rightInAnimation);
        maintxt.startAnimation(leftAnimation);
        mainLayout.startAnimation(bottomAnimation);

    }


    public void profile(View view) {

        Intent intent=new Intent(this,Profile.class);
        intent.putExtra("mob",s_mob);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.stay);
    }

    public void upcoming(View view) {
        startActivity(new Intent(this, FetchUpcoming.class));

    }

    public void re(View view) {
        startActivity(new Intent(this, Require.class));
    }

    public void his(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("key",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("rep", "his");
        editor.commit();
        startActivity(new Intent(this, View_report.class));
    }

    public void med(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("key",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("rep", "med");
        editor.commit();
       startActivity(new Intent(this, View_report.class));
    }
    public void die(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("key",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("rep", "die");
        editor.commit();;
     startActivity(new Intent(this, View_report.class));
    }
    public void pre(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("key",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("rep", "pre");
        editor.commit();
       startActivity(new Intent(this, View_report.class));
    }

    public void setting(View view) {
        finish();
        startActivity(new Intent(this, Settings.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
