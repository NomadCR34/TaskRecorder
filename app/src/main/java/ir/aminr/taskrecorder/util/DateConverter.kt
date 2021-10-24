package ir.aminr.taskrecorder.util

import java.util.*

/**
 * Convert Date Class
 * */
class DateConverter {

    /**
     * get duration between two date
     * @param startDateMillis
     * @param endDateMillis
     * @return duration in Long format
     *
     * */
    private fun getDuration(
        startDateMillis: Long,
        endDateMillis: Long
    ): Long {
        val startDate = getDate(startDateMillis)
        val endDate = getDate(endDateMillis)
        return endDate.time - startDate.time
    }

    /**
     * get date in milliseconds and return date object
     * @param date date in milliseconds
     * @return Date object
     *
     * */
    private fun getDate(date: Long): Date {
        var dateMillis = date
        val tz = TimeZone.getDefault()
        val cal = GregorianCalendar.getInstance(tz)
        val offsetInMillis = tz.getOffset(cal.timeInMillis)
        dateMillis -= offsetInMillis
        return Date(dateMillis)
    }

    fun getTotalSeconds(
        startDateMillis: Long,
        endDateMillis: Long
    ): Long {
        return getDuration(startDateMillis, endDateMillis) / 1000
    }

    fun getSeconds(
        startDateMillis: Long,
        endDateMillis: Long
    ): Long {
        return (getDuration(startDateMillis, endDateMillis) / 1000) % 60
    }

    fun getTotalMinutes(
        startDateMillis: Long,
        endDateMillis: Long
    ): Long {
        return getTotalSeconds(startDateMillis, endDateMillis) / 60
    }

    fun getTotalHours(
        startDateMillis: Long,
        endDateMillis: Long
    ): Long {
        return getTotalMinutes(startDateMillis, endDateMillis) / 60
    }

    fun getTotalDays(
        startDateMillis: Long,
        endDateMillis: Long
    ): Long {
        return getTotalHours(startDateMillis, endDateMillis) / 24
    }


}