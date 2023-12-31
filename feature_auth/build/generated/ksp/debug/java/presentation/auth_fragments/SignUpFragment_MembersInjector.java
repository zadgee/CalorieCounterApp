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
public final class SignUpFragment_MembersInjector implements MembersInjector<SignUpFragment> {
  private final Provider<AuthenticationViewModelFactory> viewModelFactoryProvider;

  public SignUpFragment_MembersInjector(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<SignUpFragment> create(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    return new SignUpFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SignUpFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("presentation.auth_fragments.SignUpFragment.viewModelFactory")
  public static void injectViewModelFactory(SignUpFragment instance,
      AuthenticationViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
