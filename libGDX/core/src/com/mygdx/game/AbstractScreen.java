package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen{
	protected Game game;
	
	public AbstractScreen(Game game)
	{
		this.game = game;
	}

	@Override
	public abstract void show();
	@Override
	public abstract void render(float delta);
	@Override
	public abstract void resize(int width, int height);
	@Override
	public abstract void pause();
	@Override
	public void resume()
	{
		
	}
	@Override
	public abstract void hide();
	@Override
	public void dispose() {
	}
	

}
