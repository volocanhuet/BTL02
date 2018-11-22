package com.bom.bomberman.entities.tile.powerup;

import com.bom.bomberman.Game;
import com.bom.bomberman.entities.Entity;
import com.bom.bomberman.entities.mob.Player;
import com.bom.bomberman.graphics.Sprite;

public class PowerupBombs extends Powerup {

	public PowerupBombs(int x, int y, int level, Sprite sprite) {
		super(x, y, level, sprite);
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player) {
			((Player) e).addPowerup(this);
			remove();
			return true;
		}
		
		return false;
	}
	
	@Override
	public void setValues() {
		_active = true;
		Game.addBombRate(10);
	}
	


}
