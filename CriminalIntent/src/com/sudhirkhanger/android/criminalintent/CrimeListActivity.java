package com.sudhirkhanger.android.criminalintent;

import android.support.v4.app.Fragment;

public abstract class CrimeListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new CrimeListFragment();
	}

}
