package domain.event

sealed class ReloadingEvent{
    data object Loading: ReloadingEvent()
    data object EmailVerified: ReloadingEvent()
    data class Error(val message:String): ReloadingEvent()
}
