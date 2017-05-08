package com.example.expensediary;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Welcome extends Activity {
	
	//VERIABLE DECLARATION
	MediaPlayer welcomeSound;

	@Override
	protected void onCreate(Bundle welcomeScreen) {
		// TODO Auto-generated method stub
		super.onCreate(welcomeScreen);
		setContentView(R.layout.welcome);
		//CREATING THE SOUND ON START
		welcomeSound = MediaPlayer.create(Welcome.this, R.raw.booing);
		welcomeSound.start();
		//CREATING THE NEW THREAD TO MAKE THE ACTIVITY SLEEP.
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}
				catch(InterruptedException ex){
					ex.printStackTrace();
				}
				finally{
					Intent openLoginScreen = new Intent("com.example.expensediary.LOGIN");
					startActivity(openLoginScreen);
				}
			}
		};
		timer.start();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//STOPPING THE SOUND
		welcomeSound.release();
		//DESTROYING THIS ACTIVITY FOR THE REST OF THE APPLICATION DURATION.
		finish();
	}

}
