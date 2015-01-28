package com.sudhirkhanger.app.runtracker;

import android.support.v4.app.Fragment;

/**
 * Created on 1/23/15 by
 * Sudhir Khanger
 * sudhirkhanger.com
 * github.com/donniezazen
 * 5577 8CDB A059 085D 1D60  807F 8C00 45D9 F5EF C394
 */
public class RunActivity extends SingleFragmentActivity {
    /**
     * A key for passing a run ID as a long
     */
    public static final String EXTRA_RUN_ID =
            "com.sudhirkhanger.app.runtracker.run_id";

    @Override
    protected Fragment createFragment() {
        long runId = getIntent().getLongExtra(EXTRA_RUN_ID, -1);
        if (runId != -1) {
            return RunFragment.newInstance(runId);
        } else {
            return new RunFragment();
        }
    }
}
