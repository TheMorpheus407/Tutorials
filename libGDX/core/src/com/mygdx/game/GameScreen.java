package com.mygdx.game;

import org.w3c.dom.views.AbstractView;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class GameScreen extends AbstractScreen {
	static ParticleEffect effect = new ParticleEffect();

	public GameScreen(Game game) {
		super(game);
		effect.load(Gdx.files.internal("data/particle.p"), Gdx.files.internal("data/"));
		effect.start();
		effect.setPosition(200, 200);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		MyGdxGame.sprite.translateX(MyGdxGame.movement);

		if(!MyGdxGame.sprite.isFlipX() && MyGdxGame.movement > 0)
			MyGdxGame.sprite.flip(true, false);
		if(MyGdxGame.sprite.isFlipX() && MyGdxGame.movement < 0)
			MyGdxGame.sprite.flip(true, false);
		
		
		//MyGdxGame.camera.position.x = MyGdxGame.sprite.getX() + MyGdxGame.sprite.getOriginX();
		//MyGdxGame.camera.position.y = MyGdxGame.sprite.getY() + MyGdxGame.sprite.getOriginY();
		//MyGdxGame.camera.zoom = 1000f;
		//MyGdxGame.camera.update();
		
		//MyGdxGame.batch.setProjectionMatrix(MyGdxGame.camera.combined);
		MyGdxGame.world.step(delta, 5, 2);
		
		MyGdxGame.sprite.setRotation((float)Math.toDegrees(MyGdxGame.body.getAngle()));
		MyGdxGame.sprite2.setRotation((float)Math.toDegrees(MyGdxGame.body2.getAngle()));
		
		MyGdxGame.sprite.setPosition(MyGdxGame.body.getPosition().x, MyGdxGame.body.getPosition().y);
		MyGdxGame.sprite2.setPosition(MyGdxGame.body2.getPosition().x, MyGdxGame.body2.getPosition().y);
		
		MyGdxGame.batch.begin();
		
		MyGdxGame.sprite.draw(MyGdxGame.batch);
		MyGdxGame.sprite2.draw(MyGdxGame.batch);
		effect.draw(MyGdxGame.batch, delta);
		
		MyGdxGame.batch.end();
		if(effect.isComplete())
		{
			effect.reset();
		}
	    
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
