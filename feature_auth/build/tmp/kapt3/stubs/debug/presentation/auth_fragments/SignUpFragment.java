package presentation.auth_fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\u001a\u0010\'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006)"}, d2 = {"Lpresentation/auth_fragments/SignUpFragment;", "Landroidx/fragment/app/Fragment;", "()V", "authenticationViewModel", "Lpresentation/viewModels/AuthenticationViewModel;", "getAuthenticationViewModel", "()Lpresentation/viewModels/AuthenticationViewModel;", "authenticationViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/nutrition/feature_auth/databinding/SignUpFragmentBinding;", "sharedPreferences", "Landroid/content/SharedPreferences;", "validationViewModel", "Lpresentation/viewModels/ValidationViewModel;", "getValidationViewModel", "()Lpresentation/viewModels/ValidationViewModel;", "validationViewModel$delegate", "viewModelFactory", "Ldagger/Lazy;", "Lpresentation/viewModels/AuthenticationViewModelFactory;", "getViewModelFactory", "()Ldagger/Lazy;", "setViewModelFactory", "(Ldagger/Lazy;)V", "handleAccountCreateAction", "", "context", "Landroid/content/Context;", "onAttach", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "feature_auth_debug"})
public final class SignUpFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.Nullable
    private com.nutrition.feature_auth.databinding.SignUpFragmentBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy validationViewModel$delegate = null;
    @javax.inject.Inject
    public dagger.Lazy<presentation.viewModels.AuthenticationViewModelFactory> viewModelFactory;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy authenticationViewModel$delegate = null;
    
    public SignUpFragment() {
        super();
    }
    
    private final presentation.viewModels.ValidationViewModel getValidationViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final dagger.Lazy<presentation.viewModels.AuthenticationViewModelFactory> getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    dagger.Lazy<presentation.viewModels.AuthenticationViewModelFactory> p0) {
    }
    
    private final presentation.viewModels.AuthenticationViewModel getAuthenticationViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleAccountCreateAction(android.content.Context context) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}