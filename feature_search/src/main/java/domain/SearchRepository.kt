package domain

import android.graphics.Typeface

interface SearchRepository {
    fun setupSearchViewFont(fontId:Int):Typeface
}