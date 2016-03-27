package net.carlos.pfr.game.pokemon;

import android.graphics.Bitmap;

public abstract class Pokemon
{
   private long level = 1;
   private long xp = 0;
   private long maxXp = 10;
   private long health = 10;
   private long speed = 2;
   private long defense = 2;
   private long attack = 2;
   private long precision = 2;
   private Bitmap texture;

   public Pokemon()
   {

   }

   public void setLevel(long level)
   {
      this.level = level;
   }

   public long getLevel()
   {
      return level;
   }

   public void setXp(long xp)
   {
      this.xp = xp;
   }

   public long getXp()
   {
      return xp;
   }

   public void setMaxXp(long maxXp)
   {
      this.maxXp = maxXp;
   }

   public long getMaxXp()
   {
      return maxXp;
   }

   public void setHealth(long health)
   {
      this.health = health;
   }

   public long getHealth()
   {
      return health;
   }

   public void setSpeed(long speed)
   {
      this.speed = speed;
   }

   public long getSpeed()
   {
      return speed;
   }

   public void setDefense(long defense)
   {
      this.defense = defense;
   }

   public long getDefense()
   {
      return defense;
   }

   public void setAttack(long attack)
   {
      this.attack = attack;
   }

   public long getAttack()
   {
      return attack;
   }

   public void setPrecision(long precision)
   {
      this.precision = precision;
   }

   public long getPrecision()
   {
      return precision;
   }

   public void setTexture(Bitmap texture)
   {
      this.texture = texture;
   }

   public Bitmap getTexture()
   {
      return texture;
   }
}
