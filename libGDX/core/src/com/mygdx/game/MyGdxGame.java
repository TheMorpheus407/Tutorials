package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class MyGdxGame implements ApplicationListener {
    public final static float HEIGHT = 500;
    public final static float WIDTH = 1000;
    
    private OrthographicCamera camera;
    private SpriteBatch batch;
    
    private Skin skin;
    private Stage stage;

    private Label messageReceived;
    private Label myIP;
    private TextArea ip;
    private TextArea msg;
    private TextButton button;
	private String ipadresse;
    
    @Override
    public void create() {        
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        
        try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			for(NetworkInterface I : Collections.list(interfaces))
			{
				for(InetAddress addr: Collections.list(I.getInetAddresses()))
				{
					if(addr instanceof Inet4Address)
					{
						ipadresse = ipadresse + addr.getHostAddress() + "\n";
					}
				}
			}
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        Group group = new Group();
        group.setBounds(0, 0, WIDTH, HEIGHT);
        messageReceived = new Label("The cake is a lie.", skin);
        myIP = new Label(ipadresse, skin);
        ip = new TextArea("Target IP", skin);
        msg = new TextArea("", skin);
        button = new TextButton("Senden", skin);
        
        messageReceived.setPosition(100, 100);
        myIP.setPosition(100,150);
        ip.setPosition(100,250);
        msg.setPosition(100,350);
        button.setPosition(100,400);
        group.addActor(messageReceived);
        group.addActor(myIP);
        group.addActor(ip);
        group.addActor(msg);
        group.addActor(button);
        
        stage.addActor(group);
        
        stage.getCamera().position.set(WIDTH/2, HEIGHT/2, 0);  
        
        button.addListener(new ClickListener(){
        	@Override
        	public void clicked(InputEvent event, float x, float y){
        		String send = "";
        		if(msg.getText().length() == 0)
        		{
        			send = "Der Kuchen ist eine Lüge\n";
        		}
        		else
        			send = msg.getText() + "\n";
        		
        		if(ip.getText().length() == 0)
        			return;
        		
        		SocketHints sh = new SocketHints();
        		sh.connectTimeout = 10000;
        		Socket socket = Gdx.net.newClientSocket(Protocol.TCP, ip.getText(), 1337, sh);
        		try {
					socket.getOutputStream().write(send.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        });
        
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				ServerSocketHints ssh = new ServerSocketHints();
				ssh.acceptTimeout = 0;
				
				ServerSocket socket = Gdx.net.newServerSocket(Protocol.TCP, 1337, ssh);
				while(true)
				{
					Socket s = socket.accept(null);
					BufferedReader buffer = new BufferedReader(new InputStreamReader(s.getInputStream()));
					
					try {
						messageReceived.setText(buffer.readLine());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				}
			}
		}).start();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {        
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        stage.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}











//
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.Input.Buttons;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.audio.AudioDevice;
//import com.badlogic.gdx.audio.AudioRecorder;
//import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Pixmap;
//import com.badlogic.gdx.graphics.PixmapIO;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.Body;
//import com.badlogic.gdx.physics.box2d.BodyDef;
//import com.badlogic.gdx.physics.box2d.Contact;
//import com.badlogic.gdx.physics.box2d.ContactImpulse;
//import com.badlogic.gdx.physics.box2d.ContactListener;
//import com.badlogic.gdx.physics.box2d.EdgeShape;
//import com.badlogic.gdx.physics.box2d.Fixture;
//import com.badlogic.gdx.physics.box2d.FixtureDef;
//import com.badlogic.gdx.physics.box2d.Manifold;
//import com.badlogic.gdx.physics.box2d.PolygonShape;
//import com.badlogic.gdx.physics.box2d.World;
//import com.badlogic.gdx.utils.BufferUtils;
//import com.badlogic.gdx.utils.ScreenUtils;
//import com.badlogic.gdx.utils.Timer;
//import com.badlogic.gdx.utils.Timer.Task;
//
//public class MyGdxGame extends Game implements InputProcessor {
//	static SpriteBatch batch;
//	static Texture img;
//	static int frame = 0;
//	static int zeile = 0;
//	static Sprite sprite;
//	static TextureRegion[][] regions;
//	static float movement = 0f;
//	static Timer attack;
//	//static OrthographicCamera camera;
//	static Music sound;
//	static World world;
//	static Body body;
//	static Sprite sprite2;
//	static Body body2;
//	
//	@Override
//	public void create () {
//		world = new World(new Vector2(0, -98f ), true);
//		sound = Gdx.audio.newMusic(Gdx.files.internal("data/Schwert.mp3"));
//		float w = Gdx.graphics.getWidth();
//		float h = Gdx.graphics.getHeight();
//		//camera = new OrthographicCamera(1, h/w);
//		batch = new SpriteBatch();
//		img = new Texture("data/Warrior Skeleton Animations/Attack 1/attack.png");
//		regions = TextureRegion.split(img, 715, 1040);
//		sprite = new Sprite(regions[0][0]);
//		sprite.setScale(0.25f);
//		
//		BodyDef bodyDef = new BodyDef();
//		bodyDef.type = BodyDef.BodyType.DynamicBody;
//		bodyDef.position.set(sprite.getX(), sprite.getY());
//		body = world.createBody(bodyDef);
//		PolygonShape shape = new PolygonShape();
//		shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
//		FixtureDef fd = new FixtureDef();
//		fd.shape = shape;
//		fd.density = 100;
//		fd.restitution = 2;
//		body.createFixture(fd);
//		shape.dispose();
//		
//		//Objekt 2
//		Texture img2 = new Texture("badlogic.jpg");
//		sprite2 = new Sprite(img2);
//		sprite2.setPosition(sprite.getX() + sprite.getWidth() / 2, Gdx.graphics.getHeight());
//		BodyDef bodyDef2 = new BodyDef();
//		bodyDef2.type = BodyDef.BodyType.DynamicBody;
//		bodyDef2.position.set(sprite2.getX(), sprite2.getY());
//		body2 = world.createBody(bodyDef2);
//		PolygonShape shape2 = new PolygonShape();
//		shape2.setAsBox(sprite2.getWidth()/2, sprite2.getHeight()/2);
//		FixtureDef fd2 = new FixtureDef();
//		fd2.shape = shape2;
//		fd2.density = 100;
//		fd2.restitution = 2;
//		body2.createFixture(fd2);
//		shape2.dispose();
//		
//		BodyDef bodenBodyDef = new BodyDef();
//		bodenBodyDef.type = BodyDef.BodyType.StaticBody;
//		bodenBodyDef.position.set(0, 0);
//		FixtureDef fixtureBoden = new FixtureDef();
//		EdgeShape edgeShape = new EdgeShape();
//		edgeShape.set(-Gdx.graphics.getWidth()/2, -Gdx.graphics.getHeight()+350, Gdx.graphics.getWidth()/2, -Gdx.graphics.getHeight()+350);
//		fixtureBoden.shape = edgeShape;
//		
//		Body bodyEdge = world.createBody(bodenBodyDef);
//		bodyEdge.createFixture(fixtureBoden);
//		edgeShape.dispose();
//		
//		world.setContactListener(new ContactListener() {
//			
//			@Override
//			public void preSolve(Contact contact, Manifold oldManifold) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void postSolve(Contact contact, ContactImpulse impulse) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void endContact(Contact contact) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void beginContact(Contact contact) {
//				if(contact.getFixtureA().getBody() == body && contact.getFixtureB().getBody() == body2
//						|| contact.getFixtureA().getBody() == body2 && contact.getFixtureB().getBody() == body){
//					GameScreen.effect.setPosition(750, 750);
//				}
//				
//			}
//		});
//		
//		
//		attack = new Timer();
//		attack.scheduleTask(new Task() {
//			
//			@Override
//			public void run() {
//				frame++;
//				if(frame > 4)
//				{
//					frame = 0;
//					if(zeile == 1)
//					{
//						zeile = 0;
//					}
//					else
//					{
//						zeile = 1;
//					}
//				}
//				sprite.setRegion(regions[zeile][frame]);
//			}
//		}, 0, 1/20f);
//		attack.stop();
//		setScreen(new MenuScreen(this));
//		Gdx.input.setInputProcessor(this);
//	}
//	@Override
//	public boolean keyDown(int keycode) {
//		if(keycode == Keys.LEFT)
//		{
//			body.setLinearVelocity(-100f, -10f);
//			if(sprite.getX() > -200)
//			{
//				movement = -5f;
//			}
//		}
//		if(keycode == Keys.RIGHT)
//		{
//			body.setLinearVelocity(100f, -10f);
//			if(sprite.getX() < 1050)
//			{
//				movement = 5f;
//			}
//		}
//		if(keycode == Keys.UP)
//		{
//			body.setLinearVelocity(0, 100f);
//		}
//		if(keycode == Keys.ALT_LEFT)
//		{
//			int samplingrate = 44100;
//			final short[] data = new short[samplingrate*3];
//			final AudioRecorder rec = Gdx.audio.newAudioRecorder(samplingrate, true);
//			final AudioDevice player = Gdx.audio.newAudioDevice(samplingrate, true);
//			
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					rec.read(data, 0, data.length);
//					rec.dispose();
//					player.writeSamples(data, 0, data.length);
//					player.dispose();
//				}
//			}).start();
//		}
//		if(keycode == Keys.ENTER)
//		{
//			byte[] pixel = ScreenUtils.getFrameBufferPixels(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), true);
//			Pixmap pixmap = new Pixmap(Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), Pixmap.Format.RGBA8888);
//			BufferUtils.copy(pixel, 0, pixmap.getPixels(), pixel.length);
//			PixmapIO.writePNG(Gdx.files.external("screenshot.png"), pixmap);
//			pixmap.dispose();
//		}
//		if(keycode == Keys.ALT_RIGHT)
//		{
//			body.setAngularVelocity(5f);
//		}
//		return true;
//	}
//
//	@Override
//	public boolean keyUp(int keycode) {
//		if(keycode == Keys.LEFT)
//		{
//			if(movement == -5f)
//			{
//				movement = 0f;
//			}
//		}
//		if(keycode == Keys.RIGHT)
//		{			
//			if(movement == 5f)
//			{
//				movement = 0f;
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public boolean keyTyped(char character) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//		if(button == Buttons.LEFT)
//		{
//			attack.start();
//			sound.play();
//		}
//		return false;
//	}
//
//	@Override
//	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//		if(button == Buttons.LEFT)
//		{
//			attack.stop();
//			sound.pause();
//		}
//		return false;
//	}
//
//	@Override
//	public boolean touchDragged(int screenX, int screenY, int pointer) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean mouseMoved(int screenX, int screenY) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean scrolled(int amount) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
