package com.onebitpixel.shooter.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Entity {

	public static final float MAX_PLAYER_VELOCITY = 5.0f;
	
	public Player(World world, Vector2 position, Vector2 size) {
		super(world, position, size);
	}

	public void update( float delta ) {
		
		if ( Gdx.input.isKeyPressed( Keys.A ) ) {
			
		}
		if ( Gdx.input.isKeyPressed( Keys.S) ) {
			
		}
		if ( Gdx.input.isKeyPressed( Keys.D ) ) {
			
		}
		if ( Gdx.input.isKeyPressed( Keys.W ) ) {
			
		}
	}
}
