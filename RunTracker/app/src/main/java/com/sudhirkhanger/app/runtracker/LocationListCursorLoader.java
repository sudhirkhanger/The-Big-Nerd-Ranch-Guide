package com.sudhirkhanger.app.runtracker;

import android.content.Context;
import android.database.Cursor;

/**
 * Created on 1/29/15
 * Sudhir Khanger
 * sudhirkhanger.com
 * github.com/donniezazen
 * 5577 8CDB A059 085D 1D60  807F 8C00 45D9 F5EF C394
 */
public class LocationListCursorLoader extends SQLiteCursorLoader {
    private long mRunId;
    public LocationListCursorLoader(Context c, long runId) {
        super(c);
        mRunId = runId;
    }
    @Override
    protected Cursor loadCursor() {
        return RunManager.get(getContext()).queryLocationsForRun(mRunId);
    }

}
