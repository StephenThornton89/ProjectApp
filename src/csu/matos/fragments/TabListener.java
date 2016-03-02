package csu.matos.fragments;

import android.app.*;
import android.app.ActionBar.*;
import android.os.Bundle;
import android.widget.Toast;


public class TabListener <T extends Fragment> implements ActionBar.TabListener {

    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;


    // The constructor.
    public TabListener(Activity activity, String tag, Class<T> clz)  {
        mActivity = activity;
        mTag = tag;
        mClass = clz;
    }

    // When a tab is tapped, the FragmentTransaction replaces
    // the content of our main layout with the specified fragment;
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
       // Toast.makeText(mActivity, "selected", Toast.LENGTH_LONG).show();
        if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ft.add(android.R.id.content, mFragment, mTag);
        } else { // If it exists, we simply attach it
            ft.show(mFragment);
        }
    }

    // When a tab is unselected, hide it from the user's view.
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            ft.hide(mFragment);
        }
    }


    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }
}
