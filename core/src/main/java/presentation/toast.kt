package presentation

import android.content.Context
import android.widget.Toast

fun showToast(
    message:String,
    context:Context
){
    return Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}

fun showToastLong(
    message:String,
    context:Context
){
    return Toast.makeText(context,message,Toast.LENGTH_LONG).show()
}