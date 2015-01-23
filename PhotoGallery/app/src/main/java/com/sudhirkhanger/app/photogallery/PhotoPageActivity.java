package com.sudhirkhanger.app.photogallery;

import android.support.v4.app.Fragment;

/**
 * Created on 1/22/15 by
 * Sudhir Khanger
 * sudhirkhanger.com
 * github.com/donniezazen
 * 5577 8CDB A059 085D 1D60  807F 8C00 45D9 F5EF C394
 */
public class PhotoPageActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new PhotoPageFragment();
    }
}
