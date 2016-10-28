package com.apnatutorials.androidviewflipper;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper vfMyViewFlipper;

    private ViewFlipper mViewFlipper;
    private Context mContext;
    private GestureDetectorCompat mDetector;

    //    RotateAnimation rotate = new RotateAnimation(0,-90);
//    RotateAnimation rotate1 = new RotateAnimation(0,90);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

//        mDetector = new GestureDetectorCompat(this,this);
        vfMyViewFlipper = (ViewFlipper) findViewById(R.id.vfMyViewFlipper);
        vfMyViewFlipper.setOnTouchListener(new OnFlingListener(this) {

            @Override
            public void onRightToLeft() {

                vfMyViewFlipper.setInAnimation(getApplicationContext(), R.anim.right_to_left);

                vfMyViewFlipper.showPrevious();
            }

            @Override
            public void onLeftToRight() {

                vfMyViewFlipper.setInAnimation(getApplicationContext(), R.anim.left_to_right);
                vfMyViewFlipper.showNext();
            }

            @Override
            public void onBottomToTop() {

            }

            @Override
            public void onTopToBottom() {

            }
        });

        vfMyViewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void flipperHandler(View view) {

        switch (view.getId()) {
            case R.id.btnStart:
                vfMyViewFlipper.setFlipInterval(3000);
                vfMyViewFlipper.setAutoStart(true);
                vfMyViewFlipper.setInAnimation(getApplicationContext(), R.anim.left_to_right);
                vfMyViewFlipper.startFlipping();

                break;
            case R.id.btnStop:
                vfMyViewFlipper.stopFlipping();

                vfMyViewFlipper.setAutoStart(false);
                break;

        }
    }


}
