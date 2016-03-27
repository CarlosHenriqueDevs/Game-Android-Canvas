package net.carlos.pfr;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.content.Intent;

public class MainActivity extends Activity 
{
   public static boolean gameStarted;
   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
   }

   @Override
   public boolean onTouchEvent(MotionEvent event)
   {
      if (!gameStarted)
      {
	 Intent i = new Intent(getApplicationContext(), GameActivity.class);
	 startActivity(i);

	 gameStarted = true;
      }

      return super.onTouchEvent(event);
   }

}
