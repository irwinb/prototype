package com.onebitpixel.shooter.entity;

public abstract class Entity {

	// update
	// render
	
	public Entity() {
		
	}
	
	public abstract void update( float delta );
	public abstract void render( float delta );
}
