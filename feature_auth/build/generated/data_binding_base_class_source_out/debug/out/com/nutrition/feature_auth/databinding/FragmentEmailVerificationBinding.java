// Generated by view binder compiler. Do not edit!
package com.nutrition.feature_auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.ads.AdView;
import com.nutrition.feature_auth.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEmailVerificationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AdView adView;

  @NonNull
  public final ImageView appLogo;

  @NonNull
  public final ImageView effects;

  @NonNull
  public final TextView messageText;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView sendEmailVerificationLetterRetry;

  @NonNull
  public final AppCompatButton verifyEmailButton;

  private FragmentEmailVerificationBinding(@NonNull ConstraintLayout rootView,
      @NonNull AdView adView, @NonNull ImageView appLogo, @NonNull ImageView effects,
      @NonNull TextView messageText, @NonNull ProgressBar progressBar,
      @NonNull TextView sendEmailVerificationLetterRetry,
      @NonNull AppCompatButton verifyEmailButton) {
    this.rootView = rootView;
    this.adView = adView;
    this.appLogo = appLogo;
    this.effects = effects;
    this.messageText = messageText;
    this.progressBar = progressBar;
    this.sendEmailVerificationLetterRetry = sendEmailVerificationLetterRetry;
    this.verifyEmailButton = verifyEmailButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEmailVerificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEmailVerificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_email_verification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEmailVerificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adView;
      AdView adView = ViewBindings.findChildViewById(rootView, id);
      if (adView == null) {
        break missingId;
      }

      id = R.id.app_logo;
      ImageView appLogo = ViewBindings.findChildViewById(rootView, id);
      if (appLogo == null) {
        break missingId;
      }

      id = R.id.effects;
      ImageView effects = ViewBindings.findChildViewById(rootView, id);
      if (effects == null) {
        break missingId;
      }

      id = R.id.messageText;
      TextView messageText = ViewBindings.findChildViewById(rootView, id);
      if (messageText == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.sendEmailVerificationLetterRetry;
      TextView sendEmailVerificationLetterRetry = ViewBindings.findChildViewById(rootView, id);
      if (sendEmailVerificationLetterRetry == null) {
        break missingId;
      }

      id = R.id.verifyEmailButton;
      AppCompatButton verifyEmailButton = ViewBindings.findChildViewById(rootView, id);
      if (verifyEmailButton == null) {
        break missingId;
      }

      return new FragmentEmailVerificationBinding((ConstraintLayout) rootView, adView, appLogo,
          effects, messageText, progressBar, sendEmailVerificationLetterRetry, verifyEmailButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
