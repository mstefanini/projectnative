package ingrid.jack.matteo.projectnative;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

public class MainActivity extends AppCompatActivity implements
        Home.OnFragmentInteractionListener, List.OnFragmentInteractionListener {

    private static final String FRAGMENT = "homeFragment";
    private FragmentManager fragmentManager = getFragmentManager();
    private Fragment myHomeFragment;
    private Fragment myListFragment;

    ArrayList<EventCaneva> event;
    Boolean riuscito = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                ("Home", ContextCompat.getColor(this, R.color.colorAccent), R.mipmap.ic_launcher);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("List", ContextCompat.getColor(this, R.color.colorAccent), R.mipmap.ic_launcher);
        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                if(index == 0)
                    fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, myHomeFragment, FRAGMENT)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
                if(index == 1)
                    fragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, myListFragment, FRAGMENT)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
            }
        });

        myHomeFragment = new Home();
        myListFragment = new List();
        fragmentManager.beginTransaction()
                .add(R.id.frameLayout, myHomeFragment, FRAGMENT)
                .commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public ArrayList<EventCaneva> getEvent(){
        return event;
    }

}
