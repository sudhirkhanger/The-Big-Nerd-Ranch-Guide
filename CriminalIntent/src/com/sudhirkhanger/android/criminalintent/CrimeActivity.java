package com.sudhirkhanger.android.criminalintent;

import android.support.v4.app.Fragment;
import android.util.Log;

public class CrimeActivity extends SingleFragmentActivity {

	private static final String TAG = "CriminalActivity";

	@Override
	protected Fragment createFragment() {
		Log.d(TAG, "createFragment() method");
		return new CrimeFragment();
	}
}
