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
import com.google.android.material.textfield.TextInputEditText;
import com.nutrition.feature_auth.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SignUpFragmentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView alreadyHaveAccountButton;

  @NonNull
  public final ImageView appLogo;

  @NonNull
  public final AppCompatButton createAccountButton;

  @NonNull
  public final ImageView effects;

  @NonNull
  public final TextView emailError;

  @NonNull
  public final TextInputEditText emailTextField;

  @NonNull
  public final ImageView hideOrShowPasswordButton;

  @NonNull
  public final TextView nameError;

  @NonNull
  public final TextInputEditText nameTextField;

  @NonNull
  public final TextView passwordError;

  @NonNull
  public final TextInputEditText passwordTextField;

  @NonNull
  public final TextView title;

  private SignUpFragmentBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView alreadyHaveAccountButton, @NonNull ImageView appLogo,
      @NonNull AppCompatButton createAccountButton, @NonNull ImageView effects,
      @NonNull TextView emailError, @NonNull TextInputEditText emailTextField,
      @NonNull ImageView hideOrShowPasswordButton, @NonNull TextView nameError,
      @NonNull TextInputEditText nameTextField, @NonNull TextView passwordError,
      @NonNull TextInputEditText passwordTextField, @NonNull TextView title) {
    this.rootView = rootView;
    this.alreadyHaveAccountButton = alreadyHaveAccountButton;
    this.appLogo = appLogo;
    this.createAccountButton = createAccountButton;
    this.effects = effects;
    this.emailError = emailError;
    this.emailTextField = emailTextField;
    this.hideOrShowPasswordButton = hideOrShowPasswordButton;
    this.nameError = nameError;
    this.nameTextField = nameTextField;
    this.passwordError = passwordError;
    this.passwordTextField = passwordTextField;
    this.title = title;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SignUpFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SignUpFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.sign_up_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SignUpFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.alreadyHaveAccountButton;
      TextView alreadyHaveAccountButton = ViewBindings.findChildViewById(rootView, id);
      if (alreadyHaveAccountButton == null) {
        break missingId;
      }

      id = R.id.app_logo;
      ImageView appLogo = ViewBindings.findChildViewById(rootView, id);
      if (appLogo == null) {
        break missingId;
      }

      id = R.id.createAccountButton;
      AppCompatButton createAccountButton = ViewBindings.findChildViewById(rootView, id);
      if (createAccountButton == null) {
        break missingId;
      }

      id = R.id.effects;
      ImageView effects = ViewBindings.findChildViewById(rootView, id);
      if (effects == null) {
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

      id = R.id.hideOrShowPasswordButton;
      ImageView hideOrShowPasswordButton = ViewBindings.findChildViewById(rootView, id);
      if (hideOrShowPasswordButton == null) {
        break missingId;
      }

      id = R.id.nameError;
      TextView nameError = ViewBindings.findChildViewById(rootView, id);
      if (nameError == null) {
        break missingId;
      }

      id = R.id.nameTextField;
      TextInputEditText nameTextField = ViewBindings.findChildViewById(rootView, id);
      if (nameTextField == null) {
        break missingId;
      }

      id = R.id.passwordError;
      TextView passwordError = ViewBindings.findChildViewById(rootView, id);
      if (passwordError == null) {
        break missingId;
      }

      id = R.id.passwordTextField;
      TextInputEditText passwordTextField = ViewBindings.findChildViewById(rootView, id);
      if (passwordTextField == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new SignUpFragmentBinding((ConstraintLayout) rootView, alreadyHaveAccountButton,
          appLogo, createAccountButton, effects, emailError, emailTextField,
          hideOrShowPasswordButton, nameError, nameTextField, passwordError, passwordTextField,
          title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
