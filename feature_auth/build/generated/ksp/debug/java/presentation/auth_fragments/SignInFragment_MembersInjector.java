package presentation.auth_fragments;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import presentation.viewModels.AuthenticationViewModelFactory;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SignInFragment_MembersInjector implements MembersInjector<SignInFragment> {
  private final Provider<AuthenticationViewModelFactory> viewModelFactoryProvider;

  public SignInFragment_MembersInjector(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<SignInFragment> create(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    return new SignInFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SignInFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("presentation.auth_fragments.SignInFragment.viewModelFactory")
  public static void injectViewModelFactory(SignInFragment instance,
      AuthenticationViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
