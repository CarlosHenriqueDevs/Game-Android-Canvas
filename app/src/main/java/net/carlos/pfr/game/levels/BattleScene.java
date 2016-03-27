package net.carlos.pfr.game.levels;

import net.carlos.pfr.game.tiles.Level;
import net.carlos.pfr.game.trainer.Trainer;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import net.carlos.pfr.game.GameView;
import net.carlos.pfr.R;

public class BattleScene extends Level
{
   private Trainer player;
   private Trainer adversario;

   private Bitmap backgroundBattle;
   private Bitmap battleScene;

   public BattleScene(Trainer player, Trainer adversario)
   {
      this.player = player;
      this.adversario = adversario;

      this.backgroundBattle = BitmapFactory
	 .decodeResource(GameView.GAME_CONTEXT.getResources(),
			 R.drawable.battle_scene);

      this.battleScene = getBackgroundBattle();
      this.battleScene = zoom();
   }

   @Override
   public void draw(Canvas canvas)
   {
      drawBattleScene(canvas);
   }

   private void drawBattleScene(Canvas c)
   {
      c.drawBitmap(battleScene, 0, 20, null);
   }

   private Bitmap getBackgroundBattle()
   {
      return Bitmap.createBitmap(backgroundBattle, 0, 0, 300, 180);
   }

   private Bitmap zoom()
   {
      return Bitmap.createScaledBitmap(battleScene, battleScene.getWidth() * 4,
				       battleScene.getHeight() * 4, false);
   }
}
