package net.carlos.pfr.game.tiles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import net.carlos.pfr.game.GameView;
import android.graphics.Rect;

public class Level
{
   private int width;
   private int height;

   private int tileWidth;
   private int tileHeight;

   private Bitmap grass;
   private Bitmap tree;
   private Bitmap flowers;
   private TileMap tile;

   public static Rect treeHitbox = new Rect();

   public Level()
   {
      this.height = GameView.DISPLAY_HEIGHT;

      tile = new TileMap();
      Context c = GameView.GAME_CONTEXT;

      this.grass = tile.getTile(TileMap.GRASS);
      this.tree = tile.zoom(tile.getTile(TileMap.TREE));
      this.flowers = tile.getTile(TileMap.FLOWERS);
   }

   public void draw(Canvas canvas)
   {
      drawStage(canvas);

      canvas.drawBitmap(tree, tree.getWidth(), 0, null);
      canvas.drawBitmap(tree, tree.getWidth(), tree.getHeight() * 2, null);
      canvas.drawBitmap(flowers, tree.getWidth() * 2, tree.getHeight() * 2, null);

      update();
   }

   private void drawStage(Canvas c)
   {
      for (int x = 0; x <= 70; x++)
      {
	 c.drawBitmap(grass, grass.getWidth() * x, 0, null);

	 for (int y = 0; y <= 70; y++)
	 {
	    c.drawBitmap(grass, grass.getWidth() * x, grass.getHeight() * y, null);
	 }
      }
   }

   private void update()
   {
      Level.treeHitbox.left = tree.getWidth();
      Level.treeHitbox.top = 0;
      Level.treeHitbox.right = tree.getWidth() + tree.getWidth();
      Level.treeHitbox.bottom = 0 + tree.getHeight();
   }
}
