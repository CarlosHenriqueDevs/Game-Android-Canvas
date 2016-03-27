package net.carlos.pfr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import net.carlos.pfr.game.GameView;
import android.view.Display;
import android.graphics.Point;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.ImageView;
import net.carlos.pfr.game.trainer.Player;
import android.widget.ImageButton;

public class GameActivity extends Activity implements OnTouchListener
{
   private GameView game;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      // TODO: Implement this method
      super.onCreate(savedInstanceState);

      Display d = getWindowManager().getDefaultDisplay();
      Point p = new Point();
      d.getSize(p);

      this.game = new GameView(this, p.x, p.y);

      setContentView(R.layout.game);

      LinearLayout ll = (LinearLayout) findViewById(R.id.gameLinearLayout);
      ll.addView(game);

      ImageButton left = (ImageButton) findViewById(R.id.move_left);
      ImageButton right = (ImageButton) findViewById(R.id.move_right);
      ImageButton top = (ImageButton) findViewById(R.id.move_top);
      ImageButton bottom = (ImageButton) findViewById(R.id.move_bottom);

      left.setOnTouchListener(this);
      right.setOnTouchListener(this);
      top.setOnTouchListener(this);
      bottom.setOnTouchListener(this);
   }

   @Override
   protected void onPause()
   {
      super.onPause();
      game.pause();
   }

   @Override
   protected void onResume()
   {
      super.onResume();
      game.resume();
   }

   @Override
   protected void onDestroy()
   {
      super.onDestroy();

      MainActivity.gameStarted = false;
   }

   @Override
   public boolean onTouch(View p1, MotionEvent p2)
   {
      Player p = GameView.player;

      switch (p1.getId())
      {
	 case R.id.move_left:
	    p.setDirection(Player.LEFT);
	    if (p.moveLeft)
	       p.setX(p.getX() - p.getSpeed());
	    break;

	 case R.id.move_bottom:
	    p.setDirection(Player.BOTTOM);
	    if (p.moveBottom)
	       p.setY(p.getY() + p.getSpeed());
	    break;

	 case R.id.move_top:
	    p.setDirection(Player.TOP);
	    if (p.moveTop)
	       p.setY(p.getY() - p.getSpeed());
	    break;

	 case R.id.move_right:
	    p.setDirection(Player.RIGHT);
	    if (p.moveRight)
	       p.setX(p.getX() + p.getSpeed());
	    break;
      }

      return false;
   }

}
