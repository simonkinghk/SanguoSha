package com.meowplushk.sanguosha;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.ads.*;


public class SanguoShaActivity extends Activity {
	
	ImageView img;
	AdView adview;
	final int NUM_IMAGES = 10;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        img = (ImageView) findViewById(R.id.imageView1);
        
        //create ad view
        adview = new AdView(this, AdSize.BANNER, "a14ef039abaf42f");
        LinearLayout layout = (LinearLayout)findViewById(R.id.Adlayout);
        layout.addView(adview);
        adview.loadAd(new AdRequest());
        
        
        
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
//            	Context context = getApplicationContext();
//            	CharSequence text = "Testing";
//            	int duration = Toast.LENGTH_SHORT;
//
//            	Toast toast = Toast.makeText(context, text, duration);
//            	toast.show();
            	
            	
            	// setContentView(R.layout.sanguo1);
            	
            	adview.loadAd(new AdRequest());
            	
            	Animation anim = null;  
                anim = new RotateAnimation(0.0f,+360.0f);  
                anim.setInterpolator(new AccelerateDecelerateInterpolator());  
                anim.setDuration(3000);  
                findViewById(R.id.imageView1).startAnimation(anim);  
            	
              
                Handler handler = new Handler(); 
                handler.postDelayed(new Runnable() { 
                     public void run() { 
                    	 update();
                     } 
                }, 1500); 

            }
        });
    }
    
    
    private void update() {
    	int imageArr[] = new int[NUM_IMAGES]; 
    	imageArr[0] = R.drawable.i1;
    	imageArr[1] = R.drawable.i2;
    	imageArr[2] = R.drawable.i3;
    	imageArr[3] = R.drawable.i4;
    	imageArr[4] = R.drawable.i5;
    	imageArr[5] = R.drawable.i6;
    	imageArr[6] = R.drawable.i7;
    	imageArr[7] = R.drawable.i8;
    	imageArr[8] = R.drawable.i9;
    	imageArr[9] = R.drawable.i10;
    	int n = (int) (Math.random()*NUM_IMAGES);
    	img.setImageResource(imageArr[n]);
    }

}