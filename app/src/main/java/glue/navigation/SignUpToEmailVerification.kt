package glue.navigation

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SignUpToEmailVerification

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SignUpToSignIn

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CongratsToHome

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EmailVerificationToCongrats

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SignInToEmailVerification

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SignInToHome

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SignInToForgotPassword
