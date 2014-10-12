package com.sudhirkhanger.android.criminalintent;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
	private Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	private static final String TAG = "CriminalFragment";
	public static final String EXTRA_CRIME_ID = "com.sudhirkhanger.android.criminalintent.crime_id";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(
				EXTRA_CRIME_ID);
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);

		mTitleField = (EditText) v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getTitle());
		mTitleField.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before,
					int count) {
				mCrime.setTitle(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count,
					int after) {
				// This space intentionally left blank
			}

			public void afterTextChanged(Editable c) {
				// This one too
			}
		});

		mDateButton = (Button) v.findViewById(R.id.crime_date);
		// Challenge: Formatting the Date pg 166
		mDateButton.setText((new SimpleDateFormat("EEEE, dd MMM yyyy",
				Locale.US).format(mCrime.getDate())));
		mDateButton.setEnabled(false);
		mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// Set the crime's solved property
						mCrime.setSolved(isChecked);
					}
				});
		return v;
	}
}
