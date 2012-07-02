package com.onebitpixel.shooter.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Entity {
	
	public static final int ENTITY_DEFAULT_HP = 100;

	// Physics body.
	public Body body;
	
	// Hit-points in game.
	private int hp;
	
	public Entity( Body body ) {
		initWithBody( body );
	}
	
	public Entity( World world, Vector2 position, Vector2 size ) {
		hp = ENTITY_DEFAULT_HP;
		
		BodyDef body_def = new BodyDef();
		body_def.type = BodyType.DynamicBody;
		body_def.position.set( position );
		
		Body body_new = world.createBody( body_def );
		
		PolygonShape body_shape = new PolygonShape();
		body_shape.setAsBox( size.x * 0.5f, size.y * 0.5f );
		
		FixtureDef body_fixture_def = new FixtureDef();
		body_fixture_def.shape = body_shape;
		body_fixture_def.density = 1.0f;
		body_fixture_def.friction = 0.3f;
		
		body_new.createFixture( body_fixture_def );
		
		initWithBody( body_new );
	}
	
	private void initWithBody( Body body ) {
		this.body = body;
		hp = ENTITY_DEFAULT_HP;
		body.setUserData( this );
	}
	
	public void takeDamage( int damage ) {
		hp -= damage;
		hp = hp < 0 ? 0 : hp;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void setHP( int new_hp ) {
		hp = new_hp;
	}
	
	public void applyForceToCentre( float x, float y ) {
		body.applyForceToCenter( x, y );
	}
	
	public void update( float delta ) {
		
	}
	
	public void render( float delta ) {
		
	}
}
