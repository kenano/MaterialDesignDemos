package com.example.kenanozdamar.materialdesignanimationsdemo1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView   imgStar;
    private TextView    txvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind layout elements to Activity and set listeners
        bindControl();
    }

    private void bindControl() {

        //bind layout elements
        Button btnExplodeJava   = (Button) findViewById(R.id.explodeJava);
        Button btnExplodeXML    = (Button) findViewById(R.id.explodeXML);
        Button btnSlideJava     = (Button) findViewById(R.id.slideJava);
        Button btnSlideXML      = (Button) findViewById(R.id.slideXML);
        Button btnFadeJava      = (Button) findViewById(R.id.fadeJava);
        Button btnFadeXML       = (Button) findViewById(R.id.fadeXML);

        LinearLayout layoutSharedElement = (LinearLayout) findViewById(R.id.shared_element);

        TextView txvRippleWithBorder            = (TextView) findViewById(R.id.txvRippleWithBorder);
        TextView txvRippleWithoutBorder         = (TextView) findViewById(R.id.txvRippleWithoutBorder);
        TextView txvCustomRippleWithBorder      = (TextView) findViewById(R.id.txvCustomRippleWithBorder);
        TextView txvCustomRippleWithoutBorder   = (TextView) findViewById(R.id.txvCustomRippleWithoutBorder);

        imgStar     = (ImageView) findViewById(R.id.imgStarSharedElement);
        txvShared   = (TextView) findViewById(R.id.txvSharedElement);

        //set listeners
        btnExplodeJava.setOnClickListener(this);
        btnExplodeXML.setOnClickListener(this);
        btnSlideJava.setOnClickListener(this);
        btnSlideXML.setOnClickListener(this);
        btnFadeJava.setOnClickListener(this);
        btnFadeXML.setOnClickListener(this);

        layoutSharedElement.setOnClickListener(this);

        //for ripple animations to be enabled onclick listener must be set.
        txvRippleWithBorder.setOnClickListener(this);
        txvRippleWithoutBorder.setOnClickListener(this);
        txvCustomRippleWithBorder.setOnClickListener(this);
        txvCustomRippleWithoutBorder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.explodeJava:

                //this obj must ve passed to Activity which will be transitioned to.
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
                intent.putExtra(TransitionActivity.KEY_ANIMATION_TYPE, AnimationType.ExplodeJava);
                //pass the options obj as a bundle
                startActivity(intent, options.toBundle());
                break;
            case R.id.explodeXML:
                break;
        }
    }
}
