package kz.abcsoft.android.demo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment {

    final String LOG_TAG = "myLogs";

    public interface onSomeEventListener {
        public void someEvent(String s);
    }

    onSomeEventListener someEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " onSomeEventListener должен реализоваться");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, container, false);

        Button button = (Button) v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_TAG, "Button click in Fragment2");
                someEventListener.someEvent("Test text to Fragment1") ;
            }
        });


        return v;
    }


}

