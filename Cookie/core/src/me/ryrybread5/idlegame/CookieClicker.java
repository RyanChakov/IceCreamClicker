package me.ryrybread5.idlegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ryrybread5.idlegame.meuns.PauseMenu;
import me.ryrybread5.idlegame.meuns.StartMenu;



public class CookieClicker extends Game{



	public OrthographicCamera camera;

	
	
	float deltaX, deltaY;
	public 	SpriteBatch batch;
	public BitmapFont font;

	public void create() {
		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.

		this.setScreen(new StartMenu(this));
	}

	public void render() {
		Gdx.graphics.setTitle(""+1/Gdx.graphics.getRawDeltaTime());
		super.render(); // important!
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE))
		{
			System.out.println("HOPE NOT BROKEN");
			//dispose();
			this.setScreen(new PauseMenu(this));
		}
	}

	public void dispose() {
	
	
	batch.dispose();
		
	}


}
