// Generated by view binder compiler. Do not edit!
package com.nutrition.feature_auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.ads.AdView;
import com.google.android.material.textfield.TextInputEditText;
import com.nutrition.feature_auth.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentForgotPasswordBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AdView adView;

  @NonNull
  public final TextView alreadyRestorePassword;

  @NonNull
  public final ImageView backgroundEffects;

  @NonNull
  public final TextView emailError;

  @NonNull
  public final TextInputEditText emailTextField;

  @NonNull
  public final TextView forgotPasswordText;

  @NonNull
  public final AppCompatButton goBackButton;

  @NonNull
  public final AppCompatButton nextButton;

  @NonNull
  public final TextView textView4;

  private FragmentForgotPasswordBinding(@NonNull ConstraintLayout rootView, @NonNull AdView adView,
      @NonNull TextView alreadyRestorePassword, @NonNull ImageView backgroundEffects,
      @NonNull TextView emailError, @NonNull TextInputEditText emailTextField,
      @NonNull TextView forgotPasswordText, @NonNull AppCompatButton goBackButton,
      @NonNull AppCompatButton nextButton, @NonNull TextView textView4) {
    this.rootView = rootView;
    this.adView = adView;
    this.alreadyRestorePassword = alreadyRestorePassword;
    this.backgroundEffects = backgroundEffects;
    this.emailError = emailError;
    this.emailTextField = emailTextField;
    this.forgotPasswordText = forgotPasswordText;
    this.goBackButton = goBackButton;
    this.nextButton = nextButton;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentForgotPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_forgot_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentForgotPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adView;
      AdView adView = ViewBindings.findChildViewById(rootView, id);
      if (adView == null) {
        break missingId;
      }

      id = R.id.already_restore_password;
      TextView alreadyRestorePassword = ViewBindings.findChildViewById(rootView, id);
      if (alreadyRestorePassword == null) {
        break missingId;
      }

      id = R.id.backgroundEffects;
      ImageView backgroundEffects = ViewBindings.findChildViewById(rootView, id);
      if (backgroundEffects == null) {
        break missingId;
      }

      id = R.id.emailError;
      TextView emailError = ViewBindings.findChildViewById(rootView, id);
      if (emailError == null) {
        break missingId;
      }

      id = R.id.emailTextField;
      TextInputEditText emailTextField = ViewBindings.findChildViewById(rootView, id);
      if (emailTextField == null) {
        break missingId;
      }

      id = R.id.forgotPasswordText;
      TextView forgotPasswordText = ViewBindings.findChildViewById(rootView, id);
      if (forgotPasswordText == null) {
        break missingId;
      }

      id = R.id.goBackButton;
      AppCompatButton goBackButton = ViewBindings.findChildViewById(rootView, id);
      if (goBackButton == null) {
        break missingId;
      }

      id = R.id.nextButton;
      AppCompatButton nextButton = ViewBindings.findChildViewById(rootView, id);
      if (nextButton == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new FragmentForgotPasswordBinding((ConstraintLayout) rootView, adView,
          alreadyRestorePassword, backgroundEffects, emailError, emailTextField, forgotPasswordText,
          goBackButton, nextButton, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
