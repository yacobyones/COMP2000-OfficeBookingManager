package com.yacobyones.officebookingmanager

import androidx.fragment.app.Fragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun Fragment.pickDate(onPicked: (String) -> Unit) {
    val picker = MaterialDatePicker.Builder.datePicker().setTitleText("Select date").build()
    picker.addOnPositiveButtonClickListener { millis ->
        val f = SimpleDateFormat("EEE d MMM", Locale.UK)
        f.timeZone = TimeZone.getTimeZone("UTC")
        onPicked(f.format(Date(millis)))
    }
    picker.show(parentFragmentManager, "date")
}

fun Fragment.pickTime(onPicked: (String) -> Unit) {
    val picker = MaterialTimePicker.Builder()
        .setTimeFormat(TimeFormat.CLOCK_24H).setHour(10).setMinute(0)
        .setTitleText("Start time").build()
    picker.addOnPositiveButtonClickListener {
        val end = (picker.hour + 1) % 24
        onPicked("%02d:%02d–%02d:%02d".format(picker.hour, picker.minute, end, picker.minute))
    }
    picker.show(parentFragmentManager, "time")
}