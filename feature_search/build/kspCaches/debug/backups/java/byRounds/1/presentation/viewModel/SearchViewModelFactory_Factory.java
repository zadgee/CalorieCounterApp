package presentation.viewModel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import domain.SearchNavigationRouter;
import domain.SearchRepository;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SearchViewModelFactory_Factory implements Factory<SearchViewModelFactory> {
  private final Provider<SearchNavigationRouter> navigationRouterProvider;

  private final Provider<SearchRepository> repositoryProvider;

  public SearchViewModelFactory_Factory(Provider<SearchNavigationRouter> navigationRouterProvider,
      Provider<SearchRepository> repositoryProvider) {
    this.navigationRouterProvider = navigationRouterProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchViewModelFactory get() {
    return newInstance(navigationRouterProvider.get(), repositoryProvider.get());
  }

  public static SearchViewModelFactory_Factory create(
      Provider<SearchNavigationRouter> navigationRouterProvider,
      Provider<SearchRepository> repositoryProvider) {
    return new SearchViewModelFactory_Factory(navigationRouterProvider, repositoryProvider);
  }

  public static SearchViewModelFactory newInstance(SearchNavigationRouter navigationRouter,
      SearchRepository repository) {
    return new SearchViewModelFactory(navigationRouter, repository);
  }
}
