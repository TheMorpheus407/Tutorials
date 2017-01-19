package com.mygdx.game;

import sun.audio.AudioPlayer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Relicts extends ApplicationAdapter implements InputProcessor {
	static SpriteBatch batch;
	static Texture img;
	static int frame = 0;
	static int zeile = 0;
	static Sprite sprite;
	static TextureRegion[][] regions;
	static float movement = 0f;
	static Timer attack;
	static OrthographicCamera camera;
	static Music sound;
	
	@Override
	public void create () {
		sound = Gdx.audio.newMusic(Gdx.files.internal("data/Schwert.mp3"));
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		img = new Texture("data/Warrior Skeleton Animations/Attack 1/attack.png");
		regions = TextureRegion.split(img, 715, 1040);
		sprite = new Sprite(regions[0][0]);
		sprite.setScale(0.25f);
		attack = new Timer();
		attack.scheduleTask(new Task() {
			
			@Override
			public void run() {
				frame++;
				if(frame > 4)
				{
					frame = 0;
					if(zeile == 1)
					{
						zeile = 0;
					}
					else
					{
						zeile = 1;
					}
				}
				sprite.setRegion(regions[zeile][frame]);
			}
		}, 0, 1/20f);
		attack.stop();
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sprite.translateX(movement);

		if(!sprite.isFlipX() && movement > 0)
			sprite.flip(true, false);
		if(sprite.isFlipX() && movement < 0)
			sprite.flip(true, false);
		camera.position.x = sprite.getX() + sprite.getOriginX();
		camera.position.y = sprite.getY() + sprite.getOriginY();
		camera.zoom = 1000f;
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		sound.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.LEFT)
		{
			if(sprite.getX() > -200)
			{
				movement = -5f;
			}
		}
		if(keycode == Keys.RIGHT)
		{
			
			if(sprite.getX() < 1050)
			{
				movement = 5f;
			}
		}
		if(keycode == Keys.ALT_LEFT)
		{
			int samplingrate = 44100;
			final short[] data = new short[samplingrate*3];
			final AudioRecorder rec = Gdx.audio.newAudioRecorder(samplingrate, true);
			final AudioDevice player = Gdx.audio.newAudioDevice(samplingrate, true);
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					rec.read(data, 0, data.length);
					rec.dispose();
					player.writeSamples(data, 0, data.length);
					player.dispose();
				}
			}).start();
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.LEFT)
		{
			if(movement == -5f)
			{
				movement = 0f;
			}
		}
		if(keycode == Keys.RIGHT)
		{			
			if(movement == 5f)
			{
				movement = 0f;
			}
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(button == Buttons.LEFT)
		{
			attack.start();
			sound.play();
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(button == Buttons.LEFT)
		{
			attack.stop();
			sound.pause();
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
