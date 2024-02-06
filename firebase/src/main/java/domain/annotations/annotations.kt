package domain.annotations

import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Singleton
@Retention(AnnotationRetention.BINARY)
annotation class GmailSignIn

@Qualifier
@Singleton
@Retention(AnnotationRetention.BINARY)
annotation class GmailSignUp