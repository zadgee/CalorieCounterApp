package presentation.auth_fragments

import android.content.Context
import app.DaggerDatabaseComponent
import app.DatabaseComponent
import auth_application.AuthComponent
import auth_application.DaggerAuthComponent
import data.di.AuthModule
import data.di.RoomModule

fun authComponent(
    context: Context
):AuthComponent{
    return DaggerAuthComponent
        .builder()
        .databaseComponent(databaseComponent(context))
        .authModule(AuthModule(context))
        .buildAuthComponent()
}

private fun databaseComponent(
    context: Context
):DatabaseComponent{
    return DaggerDatabaseComponent
        .builder()
        .roomModule(RoomModule(context))
        .build()
}