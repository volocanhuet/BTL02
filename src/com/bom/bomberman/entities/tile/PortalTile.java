package com.bom.bomberman.entities.tile;

import com.bom.bomberman.Board;
import com.bom.bomberman.entities.Entity;
import com.bom.bomberman.entities.mob.Player;
import com.bom.bomberman.graphics.Sprite;

public class PortalTile extends Tile {

	protected Board _board;
	
	public PortalTile(int x, int y, Board board, Sprite sprite) {
		super(x, y, sprite);
		_board = board;
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player ) {
			
			if(_board.detectNoEnemies() == false)
				return false;
			
			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(_board.detectNoEnemies())
					_board.nextLevel();
			}
			
			return true;
		}
		
		return false;
	}

}
