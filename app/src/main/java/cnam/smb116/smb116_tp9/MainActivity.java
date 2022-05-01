package cnam.smb116.smb116_tp9;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_menu);
        putFragment(new SensorsFragment());
        configureBottomNavListener();
    }

    public void configureBottomNavListener(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.Item_sensors:
                    putFragment(new SensorsFragment());
                    break;
                case R.id.Item_battery:
                    putFragment(new BatteryFragment());
            }
            return true;
        });
    }

    public void putFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit();
    }
}