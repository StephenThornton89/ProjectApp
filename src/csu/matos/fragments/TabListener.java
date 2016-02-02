package csu.matos.fragments;

import android.app.ActionBar.*;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar;
import android.os.Bundle;
import android.widget.Toast;

public class TabListener <T extends Fragment> implements ActionBar.TabListener {

    //private Fragment fragment;
    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;


    // The contructor.
    public TabListener(Activity activity, String tag, Class<T> clz) {
        //this.mFragment = fragment;
        mActivity = activity;
        mTag = tag;
        mClass = clz;
    }

    // When a tab is tapped, the FragmentTransaction replaces
    // the content of our main layout with the specified fragment;
    // that's why we declared an id for the main layout.
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        Toast.makeText(mActivity, "selected", Toast.LENGTH_LONG).show();
        //ft.replace(R.id.activity_main, fragment);
        if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ft.add(android.R.id.content, mFragment, mTag);
        } else { // If it exists, we simply attach it
            ft.attach(mFragment);
        }
    }
//content
    // When a tab is unselected, we have to hide it from the user's view.
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // ft.remove(fragment);
        if (mFragment != null) {
            ft.detach(mFragment);
        }
    }

    // Nothing special here. Fragments already did the job.
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }
}
