package presentation.fragment;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import presentation.viewModel.SearchViewModelFactory;

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
public final class SearchFragment_MembersInjector implements MembersInjector<SearchFragment> {
  private final Provider<SearchViewModelFactory> viewModelFactoryProvider;

  public SearchFragment_MembersInjector(Provider<SearchViewModelFactory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<SearchFragment> create(
      Provider<SearchViewModelFactory> viewModelFactoryProvider) {
    return new SearchFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SearchFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("presentation.fragment.SearchFragment.viewModelFactory")
  public static void injectViewModelFactory(SearchFragment instance,
      SearchViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
