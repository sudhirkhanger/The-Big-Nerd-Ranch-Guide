package com.sudhirkhanger.app.criminalintent;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class TimePickerFragment extends DialogFragment {

	public static final String EXTRA_TIME = "com.bignerdranch.app.criminalintent.time";
	private Date mDate;

	public static TimePickerFragment newInstance(Date date) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_TIME, date);
		TimePickerFragment fragment = new TimePickerFragment();
		fragment.setArguments(args);
		return fragment;
	}

	private void sendResult(int resultCode) {
		if (getTargetFragment() == null)
			return;
		Intent i = new Intent();
		i.putExtra(EXTRA_TIME, mDate);
		getTargetFragment().onActivityResult(getTargetRequestCode(),
				resultCode, i);
	}

	/*
	 * Had to take cue from
	 * https://github.com/tkunstek/android-big-nerd-ranch/blob
	 * /master/CriminalIntent
	 * /src/com/bignerdranch/android/criminalintent/TimePickerFragment.java and
	 * http://forums.bignerdranch.com/viewtopic.php?f=409&t=6591
	 */

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		mDate = (Date) getArguments().getSerializable(EXTRA_TIME);

		// Create a Calendar to get the year, month, and day
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(mDate);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		View v = getActivity().getLayoutInflater().inflate(
				R.layout.dialog_time, null);

		TimePicker timePicker = (TimePicker) v
				.findViewById(R.id.dialog_time_timePicker);

		timePicker.setCurrentHour(hour);
		timePicker.setCurrentMinute(minute);

		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				final Calendar cal = Calendar.getInstance();
				cal.setTime(mDate);
				int year = cal.get(Calendar.YEAR);
				int monthOfYear = cal.get(Calendar.MONTH);
				int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
				mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth,
						hourOfDay, minute).getTime();
				// Update argument to preserve selected value on rotation
				getArguments().putSerializable(EXTRA_TIME, mDate);
			}
		});

		return new AlertDialog.Builder(getActivity())
				.setView(v)
				.setTitle(R.string.time_picker_title)
				.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								sendResult(Activity.RESULT_OK);
							}
						}).create();
	}

}
