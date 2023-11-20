package presentation

import android.text.method.HideReturnsTransformationMethod

object HideTransformation {

    fun instance():HideReturnsTransformationMethod{
        return HideReturnsTransformationMethod.getInstance()
    }

}