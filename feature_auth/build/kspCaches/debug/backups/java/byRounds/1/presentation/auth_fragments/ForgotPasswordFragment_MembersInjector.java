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
public final class ForgotPasswordFragment_MembersInjector implements MembersInjector<ForgotPasswordFragment> {
  private final Provider<AuthenticationViewModelFactory> viewModelFactoryProvider;

  public ForgotPasswordFragment_MembersInjector(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<ForgotPasswordFragment> create(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    return new ForgotPasswordFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ForgotPasswordFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("presentation.auth_fragments.ForgotPasswordFragment.viewModelFactory")
  public static void injectViewModelFactory(ForgotPasswordFragment instance,
      AuthenticationViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
