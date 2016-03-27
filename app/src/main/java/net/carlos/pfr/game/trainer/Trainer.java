package net.carlos.pfr.game.trainer;

import android.graphics.Rect;
import android.graphics.Bitmap;
import net.carlos.pfr.game.pokemon.Pokemon;

public abstract class Trainer implements Desenhavel
{
   private float x, y;
   private long speed;
   private Bitmap texture;
   private Pokemon[] pokemons = new Pokemon[5];
   private Rect hitBox;
   
   public Trainer()
   {

   }

   public void addPokemon(Pokemon pokemon)
   {
      for (int i = 0; i <= pokemons.length; i++)
      {
	 if (pokemons[i] != null)
	    pokemons[i] = pokemon;
      }
   }

   public void removePokemon(Pokemon pokemon)
   {
      for (int i = 0; i <= pokemons.length; i++)
      {
	 if (pokemons[i] == pokemon)
	    pokemons[i] = null;
      }
   }

   public void setX(float x)
   {
      this.x = x;
   }

   public float getX()
   {
      return x;
   }

   public void setY(float y)
   {
      this.y = y;
   }

   public float getY()
   {
      return y;
   }

   public void setSpeed(long speed)
   {
      this.speed = speed;
   }

   public long getSpeed()
   {
      return speed;
   }

   public void setTexture(Bitmap texture)
   {
      this.texture = texture;
   }

   public Bitmap getTexture()
   {
      return texture;
   }

   public void setHitBox(Rect hitBox)
   {
      this.hitBox = hitBox;
   }

   public Rect getHitBox()
   {
      return hitBox;
   }
}
