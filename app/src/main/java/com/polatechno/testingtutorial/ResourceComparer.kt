package com.polatechno.testingtutorial

import android.content.Context

class ResourceComparer {

    fun isEquel(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}