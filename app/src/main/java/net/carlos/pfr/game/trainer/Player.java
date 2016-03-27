package net.carlos.pfr.game.trainer;

import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import net.carlos.pfr.game.GameView;
import net.carlos.pfr.R;
import android.graphics.Bitmap;
import net.carlos.pfr.game.tiles.Level;
import android.graphics.Rect;

public class Player extends Trainer
{
   public static final byte LEFT = 20;
   public static final byte RIGHT = 21;
   public static final byte TOP = 22;
   public static final byte BOTTOM = 23;
   public static final byte RUNNING_LEFT = 24;
   public static final byte RUNNING_RIGHT = 25;
   public static final byte RUNNING_TOP = 26;
   public static final byte RUNNING_BOTTOM = 27;

   private byte direction;

   public static boolean moveRight = true;
   public static boolean moveLeft = true;
   public static boolean moveTop = true;
   public static boolean moveBottom = true;
   private Rect hitBox;

   public Player()
   {
      setTexture(BitmapFactory.decodeResource(GameView.GAME_CONTEXT.getResources(), R.drawable.ic_launcher));
      setSpeed(3);
      setX(300);
      setY(300);
      hitBox = new Rect((int) getX(), (int) getY(), getTexture().getWidth(), 
			getTexture().getHeight());

      setHitBox(hitBox);
      direction = LEFT;
   }

   public void setDirection(byte direction)
   {
      this.direction = direction;
   }

   public byte getDirection()
   {
      return direction;
   }

   @Override
   public void draw(Canvas c)
   {
      c.drawBitmap(getTexture(), getX(), getY(), null);
   }

   @Override
   public void update()
   {
      updateHitBox();

      if (getHitBox().intersect(Level.treeHitbox))
      {
	 switch (getDirection())
	 {
	    case LEFT:
	       moveLeft = false;
	       break;

	    case RIGHT:
	       moveRight = false;
	       break;

	    case TOP:
	       moveTop = false;
	       break;

	    case BOTTOM:
	       moveBottom = false;
	 }
      }
      else
      {
	 moveLeft = true;
	 moveTop = true;
	 moveRight = true;
	 moveBottom = true;
      }
   }

   private void updateHitBox()
   {
      getHitBox().left = (int) getX();
      getHitBox().top = (int) getY();
      getHitBox().right = (int) getX() + getTexture().getWidth();
      getHitBox().bottom = (int) getY() + getTexture().getHeight();
   }

   private Bitmap getPlayerLeft()
   {
      return null;
   }

   private Bitmap getPlayerRight()
   {
      return null;
   }

   private Bitmap getPlayerTop()
   {
      return null;
   }

}
