package me.ryrybread5.idlegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ryrybread5.idlegame.cookie.Cookie;

public class Adventure extends Game implements Screen 
{

	public SpriteBatch batch;

	public OrthographicCamera camera;

	
	public static boolean Times=false;
	float deltaX, deltaY;
	static int x=0;
	
	public Adventure(OrthographicCamera camera, SpriteBatch batch)
	{
	
		this.camera=camera;
		this.batch=batch;
		
	}
	
	@Override
	public void create () {

		
	
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,w-320,h+20);
		camera.update();

		
	}



	@Override
	public void dispose () {
	
		batch.dispose();
	
		
	}

	@Override
	public void show() {


	}

	@Override
	public void render(float delta) {
		batch = new SpriteBatch();
		batch.begin();
	
		 Cookie cook= new Cookie();
		if(camera==null)
			System.out.println("ss?");
		if(batch==null)
			System.out.println("sss?");
		camera.update();
		cook.render(camera, batch);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
}
