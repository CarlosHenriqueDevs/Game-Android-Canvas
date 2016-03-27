package net.carlos.pfr.game.tiles;

import android.graphics.Bitmap;
import android.content.Context;
import net.carlos.pfr.game.GameView;
import android.graphics.BitmapFactory;
import android.content.res.Resources;
import net.carlos.pfr.R;

public class TileMap
{
   // house tiles
   public static final byte POKE_CENTER = 0x10;
   public static final byte HOUSE_1 = 0x11;
   public static final byte HOUSE_2 = 0x12;
   public static final byte HOUSE_3 = 0x13;

   // map tiles
   public static final byte GRASS = 0x14;
   public static final byte TREE = 0x15;
   public static final byte ROCK = 0x16;
   public static final byte POKE_MARKET = 0x17;
   public static final byte WATER = 0x18;
   public static final byte ROCK_WATER = 0x19;
   public static final byte FLOWERS = 0x20;

   private Bitmap houseTiles;
   private Bitmap mapTiles;

   public TileMap()
   {
      Context c = GameView.GAME_CONTEXT;
      Resources res = c.getResources();

      this.houseTiles = BitmapFactory.decodeResource(res, R.drawable.house_tiles);
      this.mapTiles = BitmapFactory.decodeResource(res, R.drawable.tiles_maps);
   }

   public Bitmap getTile(byte tileId)
   {
      switch (tileId)
      {
	 case WATER:
	    return Bitmap.createBitmap(mapTiles, 0, 0, 30, 30);
	 case ROCK_WATER:
	    return Bitmap.createBitmap(mapTiles, 9, 32, 22, 24);
	 case FLOWERS:
	    return Bitmap.createBitmap(mapTiles, 9, 60, 22, 22);
	 case GRASS:
	    return Bitmap.createBitmap(mapTiles, 9, 88, 18, 17);
	 case TREE:
	    return Bitmap.createBitmap(mapTiles, 53, 98, 20, 36);

      }

      return null;
   }

   public static Bitmap zoom(Bitmap bitmap)
   {
      return Bitmap.
	 createScaledBitmap(bitmap, bitmap.getWidth() * 2, 
			    bitmap.getHeight() * 2, false);
   }
}
