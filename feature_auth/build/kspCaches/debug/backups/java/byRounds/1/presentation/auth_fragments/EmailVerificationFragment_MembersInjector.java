package presentation.auth_fragments;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
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
public final class EmailVerificationFragment_MembersInjector implements MembersInjector<EmailVerificationFragment> {
  private final Provider<AuthenticationViewModelFactory> viewModelFactoryProvider;

  public EmailVerificationFragment_MembersInjector(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<EmailVerificationFragment> create(
      Provider<AuthenticationViewModelFactory> viewModelFactoryProvider) {
    return new EmailVerificationFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(EmailVerificationFragment instance) {
    injectViewModelFactory(instance, DoubleCheck.lazy(viewModelFactoryProvider));
  }

  @InjectedFieldSignature("presentation.auth_fragments.EmailVerificationFragment.viewModelFactory")
  public static void injectViewModelFactory(EmailVerificationFragment instance,
      Lazy<AuthenticationViewModelFactory> viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
