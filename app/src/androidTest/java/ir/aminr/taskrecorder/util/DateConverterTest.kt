package ir.aminr.taskrecorder.util

import android.util.Log
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class DateConverterTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var dateConverter: DateConverter

    @Before
    fun init() {
        hiltRule.inject()

    }

    @Test
    fun testGetTotalSeconds() {
        val date1 = 1635096827803
        val date2 = 1635100427803
        val duration = dateConverter.getTotalSeconds(date1, date2)
        assertThat(duration.compareTo(3600) == 0).isTrue()
    }

    @Test
    fun testGetTotalSeconds2() {
        val date1 = 1635096827803
        val date2 = 1635096888864
        val duration = dateConverter.getTotalSeconds(date1, date2)
        assertThat(duration.compareTo(61) == 0).isTrue()
    }

    @Test
    fun testGetSeconds() {
        val date1 = 1635096827803
        val date2 = 1635096888864
        val duration = dateConverter.getSeconds(date1, date2)
        assertThat(duration.compareTo(1) == 0).isTrue()
    }

    @Test
    fun testGetTotalMinutes() {
        val date1 = 1635096827803
        val date2 = 1635100427803
        val duration = dateConverter.getTotalMinutes(date1, date2)
        assertThat(duration.compareTo(60) == 0).isTrue()
    }

    @Test
    fun testGetTotalMinutes2() {
        val date1 = 1635096827803
        val date2 = 1635096888864
        val duration = dateConverter.getTotalMinutes(date1, date2)
        assertThat(duration.compareTo(1) == 0).isTrue()
    }

    @Test
    fun testGetHours() {
        val date1 = 1635096827803
        val date2 = 1635100427803
        val duration = dateConverter.getTotalHours(date1, date2)
        assertThat(duration.compareTo(1) == 0).isTrue()
    }

    @Test
    fun testGetDay() {
        val date1 = 1635096827803
        val date2 = 1635100427803
        val duration = dateConverter.getTotalDays(date1, date2)
        assertThat(duration.compareTo(0) == 0).isTrue()
    }


}