package com.gonzalezblanchard.marvelheroes.utils

import android.content.Context
import javax.inject.Inject

/*
*
* read from fragment or adapter;
PrivateSharedPreferences(context).read()
save
PrivateSharedPreferences(context).save(true)
*
* */

class PreferencesManager @Inject constructor(
    private val context: Context
) {

    private val file = Constants.SHARED_PREFS_FILE
    private val key = Constants.SHARED_PREFS_KEY
    private var sharedPreferences = context.getSharedPreferences(file, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun readStringPreference(key:String): String? {
        return sharedPreferences.getString(key, "")
    }

    fun saveStringPreference(key:String, value:String){
        editor.putString(key, value)
        editor.apply()
    }

    fun deletePreference(key:String): Boolean{
        editor.remove(key)
        return true
    }


    fun readIntPreference(key:String): Int {
        return sharedPreferences.getInt(key, -1)
    }

    fun saveIntPreference(key:String, value:Int){
        editor.putInt(key, value)
        editor.apply()
    }

}