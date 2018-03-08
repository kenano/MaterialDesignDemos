package com.example.kenanozdamar.materialdesignanimationsdemo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

/**
 * Created by kenanozdamar on 7/16/17.
 */

public class TransitionActivity extends AppCompatActivity {

    private AnimationType animationType;
    public static final String KEY_ANIMATION_TYPE = "animation_type";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate
        // Must be called before setContentView
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        animationType = (AnimationType) getIntent().getSerializableExtra(KEY_ANIMATION_TYPE);

        setUpAnimation();

        bindControl();

//        setupToolbar();
    }

    private void bindControl() {
        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Reverses the Activity Scene entry Transition and triggers the calling Activity to reverse its exit Transition.
                finishAfterTransition();
            }
        });
    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle(toolbarTitle);
    }

    private void setUpAnimation() {
        switch (animationType) {
            case ExplodeJava:

                Explode enterTransition = new Explode();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                getWindow().setEnterTransition(enterTransition);
                break;

            case ExplodeXML:
                Transition transitionAnimation = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                transitionAnimation.setDuration(1000);
                getWindow().setEnterTransition(transitionAnimation);
                break;

            case SlideJava:
                Slide enterAnimation = new Slide();
                enterAnimation.setSlideEdge(Gravity.RIGHT);
                enterAnimation.setDuration(1000);
                getWindow().setEnterTransition(enterAnimation);
                break;


            case SlideXML: { // For Slide by XML

                transitionAnimation  = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                transitionAnimation.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                getWindow().setEnterTransition(transitionAnimation);
                break;
            }

            case FadeJava: { // For Fade By Code

                Fade enterFadeAnimation = new Fade();
                enterFadeAnimation.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                getWindow().setEnterTransition(enterFadeAnimation);
                break;
            }

            case FadeXML: { // For Fade by XML

                Transition enterFadeAnimation = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                enterFadeAnimation.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                getWindow().setEnterTransition(enterFadeAnimation);
                break;
            }
        }
    }
}
