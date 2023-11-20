package auth_application;

@dagger.Component(modules = {presentation.di.PresentationModule.class}, dependencies = {app.DatabaseSubComponent.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lauth_application/AuthComponent;", "", "databaseComponent", "Lapp/DatabaseSubComponent;", "injectEmailVerificationFragment", "", "fragment", "Lpresentation/auth_fragments/EmailVerificationFragment;", "injectSignInFragment", "Lpresentation/auth_fragments/SignInFragment;", "injectSignUpFragment", "Lpresentation/auth_fragments/SignUpFragment;", "Builder", "feature_auth_debug"})
public abstract interface AuthComponent {
    
    @org.jetbrains.annotations.NotNull
    public abstract app.DatabaseSubComponent databaseComponent();
    
    public abstract void injectSignUpFragment(@org.jetbrains.annotations.NotNull
    presentation.auth_fragments.SignUpFragment fragment);
    
    public abstract void injectSignInFragment(@org.jetbrains.annotations.NotNull
    presentation.auth_fragments.SignInFragment fragment);
    
    public abstract void injectEmailVerificationFragment(@org.jetbrains.annotations.NotNull
    presentation.auth_fragments.EmailVerificationFragment fragment);
    
    @dagger.Component.Builder
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lauth_application/AuthComponent$Builder;", "", "authComponent", "Lauth_application/AuthComponent;", "provideContext", "context", "Landroid/content/Context;", "feature_auth_debug"})
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull
        public abstract auth_application.AuthComponent authComponent();
        
        @dagger.BindsInstance
        @org.jetbrains.annotations.NotNull
        public abstract auth_application.AuthComponent.Builder provideContext(@org.jetbrains.annotations.NotNull
        android.content.Context context);
    }
}