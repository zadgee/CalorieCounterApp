package presentation.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lpresentation/viewModels/ValidationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_fieldsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldomain/models/validationModel/ValidationModel;", "fieldsState", "Lkotlinx/coroutines/flow/StateFlow;", "getFieldsState", "()Lkotlinx/coroutines/flow/StateFlow;", "validateEmail", "Ldomain/usecase/ValidateEmailUseCase;", "validateNameUseCase", "Ldomain/usecase/ValidateNameUseCase;", "validatePassword", "Ldomain/usecase/ValidatePasswordUseCase;", "checkEvent", "", "event", "Lpresentation/event/ValidationEvent;", "checkEventWhenSignIn", "eventWhenSignIn", "Lpresentation/event/ValidationEventWhenSignIn;", "validateData", "name", "", "email", "password", "validateDataWhenSignIn", "feature_auth_debug"})
public final class ValidationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.ValidateEmailUseCase validateEmail = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.ValidatePasswordUseCase validatePassword = null;
    @org.jetbrains.annotations.NotNull
    private final domain.usecase.ValidateNameUseCase validateNameUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<domain.models.validationModel.ValidationModel> _fieldsState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<domain.models.validationModel.ValidationModel> fieldsState = null;
    
    public ValidationViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<domain.models.validationModel.ValidationModel> getFieldsState() {
        return null;
    }
    
    public final void checkEvent(@org.jetbrains.annotations.NotNull
    presentation.event.ValidationEvent event) {
    }
    
    public final void checkEventWhenSignIn(@org.jetbrains.annotations.NotNull
    presentation.event.ValidationEventWhenSignIn eventWhenSignIn) {
    }
    
    private final void validateData(java.lang.String name, java.lang.String email, java.lang.String password) {
    }
    
    private final void validateDataWhenSignIn(java.lang.String email, java.lang.String password) {
    }
}