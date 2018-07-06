package me.ryrybread5.idlegame.meuns;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import me.ryrybread5.idlegame.Adventure;
import me.ryrybread5.idlegame.CookieClicker;
import me.ryrybread5.idlegame.cookie.Cookie;



public class StartMenu implements Screen {
	final CookieClicker game;


	OrthographicCamera camera;
	Texture p=new Texture("Perfect.png");
	Texture background= new Texture("background.jpg");
	Image back= new ImageIcon("background.jpg").getImage();
	TextureRegion[][] tmp = new TextureRegion(p).split(p.getWidth() / 1,   p.getHeight() / 3);
	BitmapFont	font = new BitmapFont();
	
	public int score=0;
	public String  nameOfRecordHolder;
	public StartMenu(final CookieClicker cookieclicker) {
		game = cookieclicker;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);

	}




	@Override
	public void render(float delta) {

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();

		game.batch.draw(background, 0, 0);

		game.batch.draw(tmp[0][0],800,500);
		game.batch.draw(tmp[1][0],800,500-tmp[0][0].getRegionHeight());

		game.batch.draw(new Texture("IceCreamClicker.png"),387,970); 


		game.batch.end();


	
		if (Gdx.input.isTouched()) {
			System.out.println(Gdx.input.getX());
			System.out.println(Gdx.input.getY());

			if((Gdx.input.getX()>800 && Gdx.input.getX()<=988) &&(Gdx.input.getY()>480 && Gdx.input.getY()<=570) )
			{
				//play

				game.setScreen(new Adventure(camera, game.batch));
				dispose();
				System.out.println("COOL");
			}
			else if(Gdx.input.getX()>800 && Gdx.input.getX()<=1090 &&(Gdx.input.getY()>580 && Gdx.input.getY()<=670))
			{
				//options
				//	game.setScreen(new MainMenuSample(game));
			}


			dispose();

		}

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		System.out.println("GOE");
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
