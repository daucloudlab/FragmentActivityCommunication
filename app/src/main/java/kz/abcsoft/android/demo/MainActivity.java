package kz.abcsoft.android.demo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements Fragment2.onSomeEventListener {



    Fragment fragment2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getFragmentManager() ;
        FragmentTransaction fTrans = fm.beginTransaction() ;
        fragment2 = (Fragment2)fm.findFragmentById(R.id.fragment2Container) ;
        if(fragment2 == null){
            fragment2 = new Fragment2() ;
        }

//        Fragment2 fragment2 = new Fragment2() ;

        fTrans.add(R.id.fragment2Container, fragment2) ;
        fTrans.commit() ;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClick(View view) {
            Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
            ((TextView) frag1.getView().findViewById(R.id.textView))
                    .setText("Access to Fragment 1 from Activity");

//            Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2Container);
            ((TextView) fragment2.getView().findViewById(R.id.textView))
                    .setText("Access to Fragment 2 from Activity");
        }

    @Override
    public void someEvent(String s) {
        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment1) ;
        ((TextView)fragment1.getView().findViewById(R.id.textView)).setText("Text from fragment2: " + s);
    }
}

