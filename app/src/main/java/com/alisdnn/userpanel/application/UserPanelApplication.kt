package com.alisdnn.userpanel.application

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import androidx.preference.PreferenceManager
import com.alisdnn.userpanel.BuildConfig
import com.alisdnn.userpanel.domain.extension.allowReads
import com.alisdnn.userpanel.presentation.base.preference.Settings
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class UserPanelApplication : MultiDexApplication() {

    override fun onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork() // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    //.penaltyDeath() //TODO
                    .build()
            )
        }
        super.onCreate()
        setNightMode()
        Timber.plant(Timber.DebugTree())
    }

    private fun setNightMode() {
        allowReads {
            val prefs = PreferenceManager.getDefaultSharedPreferences(this)
            val mode = prefs.getInt(Settings.NIGHT_MODE, Settings.MODE_NIGHT_DEFAULT)
            AppCompatDelegate.setDefaultNightMode(mode)
        }
    }

}