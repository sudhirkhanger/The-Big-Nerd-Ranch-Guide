package com.sudhirkhanger.app.runtracker;

import android.support.v4.app.Fragment;

/**
 * Created by donnie on 1/28/15.
 */
public class RunListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RunListFragment();
    }
}
