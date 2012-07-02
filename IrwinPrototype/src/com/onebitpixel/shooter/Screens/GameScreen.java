package com.onebitpixel.shooter.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.utils.Array;
import com.onebitpixel.shooter.entity.Entity;
import com.onebitpixel.shooter.entity.Player;

public class GameScreen implements Screen {
	
	private float WORLD_WIDTH = 64f;
	private float WORLD_HEIGHT = 36f;
	
	OrthographicCamera camera = new OrthographicCamera();
	
	public static final int VELOCITY_ITERATIONS = 5;
	public static final int POSITION_ITERATIONS = 5;
	private World world = new World(new Vector2(0.0f, -9.81f), true);
	private Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	
	private MouseJoint mouseJoint;
	private Body mouseBody;
	private Body hitBody;
	
	private SpriteBatch batch;
	
	private Array< Entity > entities;
	
	private Entity player;
	
	public GameScreen() {
		BodyDef bodyDef = new BodyDef();
		mouseBody = world.createBody(bodyDef);
		batch = new SpriteBatch();
		entities = new Array< Entity >();
		
		createPlayer();
	}
	
	private void createPlayer() {
		player = new Player(
				world,
				new Vector2( Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f ),
				new Vector2( 1.0f, 1.0f ) );
		
		entities.add( player );
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}
	
	private void update(float delta) {
		for ( Entity entity : entities ) {
			entity.update( delta );
		}
		
		world.step(delta, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
	}

	@Override
	public void render(float delta) {
		update(delta);
		
		camera.update();
		renderer.render(world, camera.combined);

		for ( Entity entity : entities ) {
			entity.render( delta );
		}
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(true, WORLD_WIDTH, WORLD_HEIGHT);
	}

	@Override
	public void resume() {
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

}
