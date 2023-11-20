package presentation

import android.text.method.PasswordTransformationMethod

object PasswordTransformation {

    fun instance():PasswordTransformationMethod{
        return PasswordTransformationMethod.getInstance()
    }
}