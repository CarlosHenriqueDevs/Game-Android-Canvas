package net.carlos.pfr.game;

import android.view.SurfaceView;
import android.content.Context;
import android.view.SurfaceHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import net.carlos.pfr.R;
import net.carlos.pfr.game.util.SpriteHelper;
import net.carlos.pfr.game.tiles.TileMap;
import net.carlos.pfr.game.tiles.Level;
import net.carlos.pfr.game.trainer.Player;
import net.carlos.pfr.game.levels.BattleScene;

public class GameView extends SurfaceView implements Runnable
{
   public static Context GAME_CONTEXT;
   public static int DISPLAY_WIDTH;
   public static int DISPLAY_HEIGHT;

   private Thread gameThread;
   private SurfaceHolder ourHolder;
   volatile boolean running = true;

   private Canvas canvas;
   private Level levelM;
   private TileMap mapTiles;
   private BattleScene battle;

   public static Player player;

   public GameView(Context ctx, int screenX, int screenY)
   {
      super(ctx);

      GameView.GAME_CONTEXT = ctx;
      GameView.DISPLAY_WIDTH = screenX;
      GameView.DISPLAY_HEIGHT = screenY;
      GameView.player = new Player();

      this.ourHolder = getHolder();
      this.gameThread = new Thread(this);
      this.gameThread.start();
      this.mapTiles = new TileMap();
      this.levelM = new Level();
      this.battle = new BattleScene(player, player);
   }

   private void draw()
   {
      if (ourHolder.getSurface().isValid())
      {
	 canvas = ourHolder.lockCanvas();

	 canvas.drawColor(Color.BLACK);
	 levelM.draw(canvas);
	 player.draw(canvas);

	 ourHolder.unlockCanvasAndPost(canvas);
      }
   }

   private void update()
   {
      player.update();
   }

   private void control()
   {
      try
      {
	 gameThread.sleep(30);
      }
      catch (InterruptedException e)
      {}
   }

   @Override
   public void run()
   {
      while (running)
      {
	 draw();
	 update();
	 control();
      }
   }

   public void pause()
   {
      running = false;

      try
      {
	 gameThread.join();
      }
      catch (InterruptedException e)
      {}
   }

   public void resume()
   {
      gameThread = new Thread(this);
      gameThread.start();
   }
}
