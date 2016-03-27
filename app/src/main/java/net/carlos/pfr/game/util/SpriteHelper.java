package net.carlos.pfr.game.util;

import android.graphics.Bitmap;

public class SpriteHelper
{
   private int x, y;
   private int spriteWidth;
   private int spriteHeight;

   private int frame;

   private int linesVertical;
   private int linesHorizontal;
   private Bitmap sprite;
   
   public SpriteHelper(Bitmap sprite, int spriteWidth, int spriteHeight)
   {
      this.sprite = sprite;
      this.spriteWidth = spriteWidth;
      this.spriteHeight = spriteHeight;
   }

   public SpriteHelper(Bitmap sprite, int spriteWidth, int spriteHeight, int x, int y)
   {
      this(sprite, spriteWidth, spriteHeight);
      this.x = x;
      this.y = y;
   }

   public SpriteHelper(Bitmap sprite, int spriteWidth, int spriteHeight, 
		       int x, int y, int linhasVertical, 
		       int linhasHorizontal)
   {
      this(sprite, spriteWidth, spriteHeight, x, y);
      this.linesVertical = linhasVertical;
      this.linesHorizontal = linhasHorizontal;
   }

   public Bitmap getSprite(int frame)
   {
      int x = 0;
      int y = 0;

      if (frame > 1)
      {
	 x = frame + spriteWidth;

	 if (frame > linesHorizontal)
	 {
	    y = frame + spriteHeight;
	 }
      }

      Bitmap b = Bitmap.createBitmap(sprite, x, y, spriteWidth, spriteHeight);

      return b;
   }
}
