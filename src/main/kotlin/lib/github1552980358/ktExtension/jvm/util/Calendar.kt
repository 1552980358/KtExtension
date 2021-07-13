package lib.github1552980358.ktExtension.jvm.util

import java.util.Calendar
import java.util.Calendar.JANUARY
import java.util.Calendar.FEBRUARY
import java.util.Calendar.MARCH
import java.util.Calendar.APRIL
import java.util.Calendar.MAY
import java.util.Calendar.JUNE
import java.util.Calendar.JULY
import java.util.Calendar.AUGUST
import java.util.Calendar.SEPTEMBER
import java.util.Calendar.OCTOBER
import java.util.Calendar.NOVEMBER
import java.util.Calendar.DECEMBER

val Calendar.getMonthDays get(): Int {
    return when (get(Calendar.MONTH)) {
        JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31
        APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
        FEBRUARY -> if (isLeapYear) 29 else 28
        /**
         * Refers to [java.util.Calendar.UNDECIMBER]
         * No support for it although java has this constant value within source code
         * Ignore this here
         **/
        // UNDECIMBER -> 0
        else -> 0
    }
}

val Calendar.getYearDays get() = if (isLeapYear) 366 else 365

val Calendar.isLeapYear get() = get(Calendar.YEAR).run {
    this % 4 == 0 && this % 100 != 0 || this % 400 != 0
}
