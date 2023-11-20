package domain.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0017"}, d2 = {"Ldomain/di/UseCaseModule;", "", "()V", "deleteUserFromFirebaseUseCase", "Ldomain/usecase/DeleteUserFromFirebaseUseCase;", "repository", "Ldomain/repository/AuthenticationRepository;", "provideAddUserToFireStoreUseCase", "Ldomain/usecase/AddUserToFireStoreUseCase;", "provideIsEmailVerifiedUseCase", "Ldomain/usecase/IsEmailVerifiedUseCase;", "provideLoginUseCase", "Ldomain/usecase/LoginUseCase;", "provideReloadUserUseCase", "Ldomain/usecase/ReloadUserUseCase;", "provideSendEmailVerificationLetterUseCase", "Ldomain/usecase/SendEmailVerificationLetterUseCase;", "provideSignOutWhileUsingEmailPasswordUseCase", "Ldomain/usecase/SignOutWhileUsingEmailPasswordUseCase;", "provideSignOutWhileUsingGmailAuth", "Ldomain/usecase/SignOutWhileUsingGmailAuth;", "provideSignUpUseCase", "Ldomain/usecase/SignUpUseCase;", "feature_auth_debug"})
public final class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.AddUserToFireStoreUseCase provideAddUserToFireStoreUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.DeleteUserFromFirebaseUseCase deleteUserFromFirebaseUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.LoginUseCase provideLoginUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.ReloadUserUseCase provideReloadUserUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.SendEmailVerificationLetterUseCase provideSendEmailVerificationLetterUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.SignOutWhileUsingEmailPasswordUseCase provideSignOutWhileUsingEmailPasswordUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.SignOutWhileUsingGmailAuth provideSignOutWhileUsingGmailAuth(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.SignUpUseCase provideSignUpUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final domain.usecase.IsEmailVerifiedUseCase provideIsEmailVerifiedUseCase(@org.jetbrains.annotations.NotNull
    domain.repository.AuthenticationRepository repository) {
        return null;
    }
}