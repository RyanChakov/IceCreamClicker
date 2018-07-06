package me.ryrybread5.idlegame.cookie;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import me.ryrybread5.idlegame.Items.ItemType;

public class Cookie extends Game {
	Sprite iceCream;
	static int [] value1X= new int[21];
	static int [] value1Y= new int[21];
	static int [] value2X= new int[21];
	static int [] value2Y= new int[21];
	static int [] value3X= new int[21];
	static int [] value3Y= new int[21];
	static int [] value4X= new int[21];
	static int [] value4Y= new int[21];

	static int [] value6X= new int[21];
	static int [] value6Y= new int[21];
	static int [] value7X= new int[21];
	static int [] value7Y= new int[21];
	static int [] value8X= new int[21];
	static int [] value8Y= new int[21];
	private static final int VIRTUAL_WIDTH = Gdx.graphics.getWidth();
	private static final int VIRTUAL_HEIGHT = Gdx.graphics.getHeight();
	BitmapFont font = new BitmapFont();
	Texture cone= new Texture("icecream.png");
	Texture[] cones= new Texture[6];
	private static final int CONEX = 100;
	private static final int CONEY = 300;
	public static int sprinkles =0,cherries=0,kind=0,MandM=0,Reeses=0,syrup=0,berry=0,bananas=0,dough=0,item9=0;
	public static double cookies=0,Ps=0,click=1;
	ItemType type;
	static long startTime=0;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		iceCream = new Sprite(cone);
		iceCream.setSize(480, 640);
		cones[0]= new Texture("icecream.png");
		cones[1]= new Texture("Pistachio IceCream.png");
		cones[2]= new Texture("Orange IceCream.png");
		cones[3]= new Texture("Vanilla IceCream.png");
		cones[4]= new Texture("Choclate and Vanilla IceCream.png");
		cones[5]= new Texture("Choclate IceCream.png");

	}



	public void render(OrthographicCamera camera, SpriteBatch batch) 
	{
		DecimalFormat df= new DecimalFormat("0");
		DecimalFormat def= new DecimalFormat("0.0");
		DecimalFormat defC= new DecimalFormat("0,000.0");
		DecimalFormat commas= new DecimalFormat("0,000");
		camera.setToOrtho(false, 1920, 1080);
		create();
		int middlepointX = VIRTUAL_WIDTH>>1;
		int middlepointY = VIRTUAL_HEIGHT>>1;

		//System.out.println(middlepointX+" "+middlepointY);
		//batch.draw(new Texture("Perfect.png"), 0, 0);

		batch.draw(new Texture("background.jpg"), 0, 0);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		font.getData().setScale(3f,3f);
		font.setColor(Color.BLACK);
		if(cookies<=999)
			font.draw(batch, String.valueOf(df.format(cookies)), 100, 980);
		else
		{
			font.draw(batch, String.valueOf(commas.format(cookies)), 100, 980);
		}
		if(Ps<=999)
			font.draw(batch, "IceCream Per Second:"+String.valueOf(def.format(Ps)), 70, 930);
		else
		{
			font.draw(batch, "IceCream Per Second:"+String.valueOf(defC.format(Ps)), 70, 930);
		}

		batch.draw(cones[kind], 100, 300);

		batch.draw(new Texture("List of Menu Items.png"), 1250, 0);
		font.getData().setScale(2f,2f);
		font.setColor(Color.WHITE);
		if(type.SPRINKLES.getCost()<=999)
			font.draw(batch, String.valueOf(type.SPRINKLES.getCost()), 1400, 1010);
		else
		{
			font.draw(batch, String.valueOf(commas.format(type.SPRINKLES.getCost())), 1400, 1010);
		}
		if(type.CHERRY.getCost()<=999)
			font.draw(batch, String.valueOf(type.CHERRY.getCost()), 1400, 900);
		else
		{
			font.draw(batch, String.valueOf(commas.format(type.CHERRY.getCost())), 1400, 900);
		}
		font.draw(batch, String.valueOf(commas.format(type.MM.getCost())), 1400, 790);
		font.draw(batch, String.valueOf(commas.format(type.REESE.getCost())), 1400, 680);
		font.draw(batch, String.valueOf(commas.format(type.CHOCLATES.getCost())), 1400, 570);
		font.draw(batch, String.valueOf(commas.format(type.STRAWBERRIES.getCost())), 1400, 460);
		font.draw(batch, String.valueOf(commas.format(type.BANANAS.getCost())), 1400, 350);
		font.draw(batch, String.valueOf(commas.format(type.COOKIEDOUGH.getCost())), 1400, 240);
		font.getData().setScale(2.5f,2.5f);
		font.draw(batch, String.valueOf(sprinkles), 1800, 1030);
		font.draw(batch, String.valueOf(cherries), 1800, 920);
		font.draw(batch, String.valueOf(MandM), 1800, 810);
		font.draw(batch, String.valueOf(Reeses), 1800, 700);
		font.draw(batch, String.valueOf(syrup), 1800, 590);
		font.draw(batch, String.valueOf(berry), 1800, 480);
		font.draw(batch, String.valueOf(bananas), 1800, 370);
		font.draw(batch, String.valueOf(dough), 1800, 260);


		sprinkles(batch);
		cherries(batch);
		MMS(batch);
		Reeses(batch);
		Strawberries(batch);
		Bananas(batch);
		CookieDough(batch);
		batch.draw(new Texture("IceCreamBackGround.png"), 100, 590);

		if(syrup!=0)
			batch.draw(new Texture("Syrup.png"), 100, 460,361,160);


		if (TimeUtils.timeSinceNanos(startTime) > 100000000) { 
			cookies+=Ps/10;
			startTime = TimeUtils.nanoTime();
		}





		if(Gdx.input.justTouched())
		{
			//Cone Touch
			if(Gdx.input.getX() > CONEX && Gdx.input.getX() < CONEX + cone.getWidth())
			{
				if(Gdx.input.getY() > 190 && Gdx.input.getY() <190 + cone.getHeight())
				{
					cookies+=click;

				}
			}
			//Menus
			if(Gdx.input.getX()>1250 && Gdx.input.getX()< VIRTUAL_WIDTH)
			{
				int min =300+cone.getHeight()/2;
				int max =190 + cone.getHeight();
				System.out.println(Gdx.input.getY());
				//Sprinkles
				if(Gdx.input.getY() >0 && Gdx.input.getY()<98)
				{
					if(cookies>=type.SPRINKLES.getCost())
					{

						cookies-=type.SPRINKLES.getCost();
						sprinkles++;
						type.SPRINKLES.setCost((int)(Math.floor(type.SPRINKLES.getCost()*1.25)));
						if(sprinkles<=20)
						{
							value1X[sprinkles] = (int)(Math.random()*(310 - 130)) + 130;
							value1Y[sprinkles] = (int)(Math.random()*(max - min)) + min;
						}
						Ps+=type.SPRINKLES.getaddPS();
					}
				}
				//Cherries
				if(Gdx.input.getY() >112 && Gdx.input.getY()<208)
				{
					if(cookies>=type.CHERRY.getCost())
					{
						cookies-=type.CHERRY.getCost();
						type.CHERRY.setCost((int)(Math.floor(type.CHERRY.getCost()*1.25)));
						Ps+=type.CHERRY.getaddPS();
						cherries++;
						if(cherries<=20)
						{
							value2X[cherries] = (int)(Math.random()*(310 - 130)) + 130;
							value2Y[cherries] = (int)(Math.random()*(max - min)) + min;
						}
					}
				}
				if(Gdx.input.getY() >214 && Gdx.input.getY()<313)
				{

					if(cookies>=type.MM.getCost())
					{

						cookies-=type.MM.getCost();
						type.MM.setCost((int)(Math.floor(type.MM.getCost()*1.25)));
						Ps+=type.MM.getaddPS();
						MandM++;
						if(MandM<=20)
						{
							value3X[MandM]= (int)(Math.random()*(310 - 130)) + 130;
							value3Y[MandM] = (int)(Math.random()*(max - min)) + min;
						}
					}
				}
				if(Gdx.input.getY() >321 && Gdx.input.getY()<424)
				{

					if(cookies>=type.REESE.getCost())
					{
						cookies-=type.REESE.getCost();
						type.REESE.setCost((int)(Math.floor(type.REESE.getCost()*1.25)));
						Ps+=type.REESE.getaddPS();
						Reeses++;
						if(Reeses<=20)
						{
							value4X[Reeses]= (int)(Math.random()*(310 - 130)) + 130;
							value4Y[Reeses] = (int)(Math.random()*(max - min)) + min;
						}
					}
				}
				if(Gdx.input.getY() >433 && Gdx.input.getY()<536)
				{

					if(cookies>=type.CHOCLATES.getCost())
					{
						cookies-=type.CHOCLATES.getCost();
						type.CHOCLATES.setCost((int)(Math.floor(type.CHOCLATES.getCost()*1.25)));
						Ps+=type.CHOCLATES.getaddPS();
						syrup++;

					}
				}
				if(Gdx.input.getY() >540 && Gdx.input.getY()<648)
				{

					if(cookies>=type.STRAWBERRIES.getCost())
					{
						cookies-=type.STRAWBERRIES.getCost();
						type.STRAWBERRIES.setCost((int)(Math.floor(type.STRAWBERRIES.getCost()*1.25)));
						Ps+=type.STRAWBERRIES.getaddPS();
						berry++;
						if(berry<=20)
						{
							value6X[berry] = (int)(Math.random()*(310 - 130)) + 130;
							value6Y[berry] = (int)(Math.random()*(max - min)) + min;
						}
					}
				}
				if(Gdx.input.getY() >662 && Gdx.input.getY()<760)
				{

					if(cookies>=type.BANANAS.getCost())
					{
						cookies-=type.BANANAS.getCost();
						type.BANANAS.setCost((int)(Math.floor(type.BANANAS.getCost()*1.25)));
						Ps+=type.BANANAS.getaddPS();
						bananas++;
						if(bananas<=20)
						{
							value7X[bananas] = (int)(Math.random()*(310 - 130)) + 130;
							value7Y[bananas] = (int)(Math.random()*(max - min)) + min;
						}
					}
				}
				if(Gdx.input.getY() >764 && Gdx.input.getY()<872)
				{

					if(cookies>=type.COOKIEDOUGH.getCost())
					{
						cookies-=type.COOKIEDOUGH.getCost();
						type.COOKIEDOUGH.setCost((int)(Math.floor(type.COOKIEDOUGH.getCost()*1.25)));
						Ps+=type.CHOCLATES.getaddPS();
						dough++;
						if(dough<=20)
						{
							value8X[dough] = (int)(Math.random()*(310 - 130)) + 130;
							value8Y[dough] = (int)(Math.random()*(max - min)) + min;
						}
					}
				}
				//Ice Cream Parlor
				//87 all around
				if(Gdx.input.getY() >953 && Gdx.input.getY()<1040)
				{
					if(Gdx.input.getX()>1278 && Gdx.input.getX()<1278+87)
					{
						kind=1;
					}
					if(Gdx.input.getX()>1413 && Gdx.input.getX()<1413+87)
					{
						kind=2;
					}
					if(Gdx.input.getX()>1548 && Gdx.input.getX()<1548+87)
					{
						kind=3;
					}
					if(Gdx.input.getX()>1679 && Gdx.input.getX()<1679+87)
					{
						kind=4;
					}
					if(Gdx.input.getX()>1799 && Gdx.input.getX()<1799+87)
					{
						kind=5;
					}
				}


			}			
		}
		//Keep this here idk why yet
		batch.draw(new Texture("IceCreamClicker.png"), 101, 101);
	}



	public void update(float deltaTime) {
		// TODO Auto-generated method stub

	}

	public void sprinkles(SpriteBatch batch)
	{
		if(sprinkles>=1)
			batch.draw(new Texture("sprinkles.png"), value1X[1], value1Y[1],100,100);
		if(sprinkles>=2)
			batch.draw(new Texture("sprinkles.png"), value1X[2], value1Y[2],100,100);
		if(sprinkles>=3)
			batch.draw(new Texture("sprinkles.png"), value1X[3], value1Y[3],100,100);
		if(sprinkles>=4)
			batch.draw(new Texture("sprinkles.png"), value1X[4], value1Y[4],100,100);
		if(sprinkles>=5)
			batch.draw(new Texture("sprinkles.png"), value1X[5], value1Y[5],100,100);
		if(sprinkles>=6)
			batch.draw(new Texture("sprinkles.png"), value1X[6], value1Y[6],100,100);
		if(sprinkles>=7)
			batch.draw(new Texture("sprinkles.png"), value1X[7], value1Y[7],100,100);
		if(sprinkles>=8)
			batch.draw(new Texture("sprinkles.png"), value1X[8], value1Y[8],100,100);
		if(sprinkles>=9)
			batch.draw(new Texture("sprinkles.png"), value1X[9], value1Y[9],100,100);
		if(sprinkles>=10)
			batch.draw(new Texture("sprinkles.png"), value1X[10], value1Y[10],100,100);
		if(sprinkles>=11)
			batch.draw(new Texture("sprinkles.png"), value1X[11], value1Y[11],100,100);
		if(sprinkles>=12)
			batch.draw(new Texture("sprinkles.png"), value1X[12], value1Y[12],100,100);
		if(sprinkles>=13)
			batch.draw(new Texture("sprinkles.png"), value1X[13], value1Y[13],100,100);
		if(sprinkles>=14)
			batch.draw(new Texture("sprinkles.png"), value1X[14], value1Y[14],100,100);
		if(sprinkles>=15)
			batch.draw(new Texture("sprinkles.png"), value1X[15], value1Y[15],100,100);
		if(sprinkles>=16)
			batch.draw(new Texture("sprinkles.png"), value1X[16], value1Y[16],100,100);
		if(sprinkles>=17)
			batch.draw(new Texture("sprinkles.png"), value1X[17], value1Y[17],100,100);
		if(sprinkles>=18)
			batch.draw(new Texture("sprinkles.png"), value1X[18], value1Y[18],100,100);
		if(sprinkles>=19)
			batch.draw(new Texture("sprinkles.png"), value1X[19], value1Y[19],100,100);
		if(sprinkles>=20)
			batch.draw(new Texture("sprinkles.png"), value1X[20], value1Y[20],100,100);

	}
	public void cherries(SpriteBatch batch)
	{
		if(cherries>=1)
			batch.draw(new Texture("cherry.png"), value2X[1], value2Y[1] );
		if(cherries>=2)
			batch.draw(new Texture("cherry.png"), value2X[2], value2Y[2] );
		if(cherries>=3)
			batch.draw(new Texture("cherry.png"), value2X[3], value2Y[3] );
		if(cherries>=4)
			batch.draw(new Texture("cherry.png"), value2X[4], value2Y[4] );
		if(cherries>=5)
			batch.draw(new Texture("cherry.png"), value2X[5], value2Y[5] );
		if(cherries>=6)
			batch.draw(new Texture("cherry.png"), value2X[6], value2Y[6] );
		if(cherries>=7)
			batch.draw(new Texture("cherry.png"), value2X[7], value2Y[7] );
		if(cherries>=8)
			batch.draw(new Texture("cherry.png"), value2X[8], value2Y[8] );
		if(cherries>=9)
			batch.draw(new Texture("cherry.png"), value2X[9], value2Y[9] );
		if(cherries>=10)
			batch.draw(new Texture("cherry.png"), value2X[10], value2Y[10] );
		if(cherries>=11)
			batch.draw(new Texture("cherry.png"), value2X[11], value2Y[11] );
		if(cherries>=12)
			batch.draw(new Texture("cherry.png"), value2X[12], value2Y[12] );
		if(cherries>=13)
			batch.draw(new Texture("cherry.png"), value2X[13], value2Y[13] );
		if(cherries>=14)
			batch.draw(new Texture("cherry.png"), value2X[14], value2Y[14] );
		if(cherries>=15)
			batch.draw(new Texture("cherry.png"), value2X[15], value2Y[15] );
		if(cherries>=16)
			batch.draw(new Texture("cherry.png"), value2X[16], value2Y[16] );
		if(cherries>=17)
			batch.draw(new Texture("cherry.png"), value2X[17], value2Y[17] );
		if(cherries>=18)
			batch.draw(new Texture("cherry.png"), value2X[18], value2Y[18] );
		if(cherries>=19)
			batch.draw(new Texture("cherry.png"), value2X[19], value2Y[19] );
		if(cherries>=20)
			batch.draw(new Texture("cherry.png"), value2X[20], value2Y[20] );

	}
	public void MMS(SpriteBatch batch)
	{
		if(MandM>=1)
			batch.draw(new Texture("M&M.png"), value3X[1], value3Y[1],50,50);
		if(MandM>=2)
			batch.draw(new Texture("M&M.png"), value3X[2], value3Y[2],50,50);
		if(MandM>=3)
			batch.draw(new Texture("M&M.png"), value3X[3], value3Y[3],50,50);
		if(MandM>=4)
			batch.draw(new Texture("M&M.png"), value3X[4], value3Y[4],50,50);
		if(MandM>=5)
			batch.draw(new Texture("M&M.png"), value3X[5], value3Y[5],50,50);
		if(MandM>=6)
			batch.draw(new Texture("M&M.png"), value3X[6], value3Y[6],50,50);
		if(MandM>=7)
			batch.draw(new Texture("M&M.png"), value3X[7], value3Y[7],50,50);
		if(MandM>=8)
			batch.draw(new Texture("M&M.png"), value3X[8], value3Y[8],50,50);
		if(MandM>=9)
			batch.draw(new Texture("M&M.png"), value3X[9], value3Y[9],50,50);
		if(MandM>=10)
			batch.draw(new Texture("M&M.png"), value3X[10], value3Y[10],50,50);
		if(MandM>=11)
			batch.draw(new Texture("M&M.png"), value3X[11], value3Y[11],50,50);
		if(MandM>=12)
			batch.draw(new Texture("M&M.png"), value3X[12], value3Y[12],50,50);
		if(MandM>=13)
			batch.draw(new Texture("M&M.png"), value3X[13], value3Y[13],50,50);
		if(MandM>=14)
			batch.draw(new Texture("M&M.png"), value3X[14], value3Y[14],50,50);
		if(MandM>=15)
			batch.draw(new Texture("M&M.png"), value3X[15], value3Y[15],50,50);
		if(MandM>=16)
			batch.draw(new Texture("M&M.png"), value3X[16], value3Y[16],50,50);
		if(MandM>=17)
			batch.draw(new Texture("M&M.png"), value3X[17], value3Y[17],50,50);
		if(MandM>=18)
			batch.draw(new Texture("M&M.png"), value3X[18], value3Y[18],50,50);
		if(MandM>=19)
			batch.draw(new Texture("M&M.png"), value3X[19], value3Y[19],50,50);
		if(MandM>=20)
			batch.draw(new Texture("M&M.png"), value3X[20], value3Y[20],50,50);

	}
	public void Reeses(SpriteBatch batch)
	{
		if(Reeses>=1)
			batch.draw(new Texture("Reeces.png"), value4X[1], value4Y[1],50,50);
		if(Reeses>=2)
			batch.draw(new Texture("Reeces.png"), value4X[2], value4Y[2],50,50);
		if(Reeses>=3)
			batch.draw(new Texture("Reeces.png"), value4X[3], value4Y[3],50,50);
		if(Reeses>=4)
			batch.draw(new Texture("Reeces.png"), value4X[4], value4Y[4],50,50);
		if(Reeses>=5)
			batch.draw(new Texture("Reeces.png"), value4X[5], value4Y[5],50,50);
		if(Reeses>=6)
			batch.draw(new Texture("Reeces.png"), value4X[6], value4Y[6],50,50);
		if(Reeses>=7)
			batch.draw(new Texture("Reeces.png"), value4X[7], value4Y[7],50,50);
		if(Reeses>=8)
			batch.draw(new Texture("Reeces.png"), value4X[8], value4Y[8],50,50);
		if(Reeses>=9)
			batch.draw(new Texture("Reeces.png"), value4X[9], value4Y[9],50,50);
		if(Reeses>=10)
			batch.draw(new Texture("Reeces.png"), value4X[10], value4Y[10],50,50);
		if(Reeses>=11)
			batch.draw(new Texture("Reeces.png"), value4X[11], value4Y[11],50,50);
		if(Reeses>=12)
			batch.draw(new Texture("Reeces.png"), value4X[12], value4Y[12],50,50);
		if(Reeses>=13)
			batch.draw(new Texture("Reeces.png"), value4X[13], value4Y[13],50,50);
		if(Reeses>=14)
			batch.draw(new Texture("Reeces.png"), value4X[14], value4Y[14],50,50);
		if(Reeses>=15)
			batch.draw(new Texture("Reeces.png"), value4X[15], value4Y[15],50,50);
		if(Reeses>=16)
			batch.draw(new Texture("Reeces.png"), value4X[16], value4Y[16],50,50);
		if(Reeses>=17)
			batch.draw(new Texture("Reeces.png"), value4X[17], value4Y[17],50,50);
		if(Reeses>=18)
			batch.draw(new Texture("Reeces.png"), value4X[18], value4Y[18],50,50);
		if(Reeses>=19)
			batch.draw(new Texture("Reeces.png"), value4X[19], value4Y[19],50,50);
		if(Reeses>=20)
			batch.draw(new Texture("Reeces.png"), value4X[20], value4Y[20],50,50);

	}
	public void Strawberries(SpriteBatch batch)
	{
		if(berry>=1)
			batch.draw(new Texture("Strawberrry.png"), value6X[1], value6Y[1],100,100);
		if(berry>=2)
			batch.draw(new Texture("Strawberrry.png"), value6X[2], value6Y[2],100,100);
		if(berry>=3)
			batch.draw(new Texture("Strawberrry.png"), value6X[3], value6Y[3],100,100);
		if(berry>=4)
			batch.draw(new Texture("Strawberrry.png"), value6X[4], value6Y[4],100,100);
		if(berry>=5)
			batch.draw(new Texture("Strawberrry.png"), value6X[5], value6Y[5],100,100);
		if(berry>=6)
			batch.draw(new Texture("Strawberrry.png"), value6X[6], value6Y[6],100,100);
		if(berry>=7)
			batch.draw(new Texture("Strawberrry.png"), value6X[7], value6Y[7],100,100);
		if(berry>=8)
			batch.draw(new Texture("Strawberrry.png"), value6X[8], value6Y[8],100,100);
		if(berry>=9)
			batch.draw(new Texture("Strawberrry.png"), value6X[9], value6Y[9],100,100);
		if(berry>=10)
			batch.draw(new Texture("Strawberrry.png"), value6X[10], value6Y[10],100,100);
		if(berry>=11)
			batch.draw(new Texture("Strawberrry.png"), value6X[11], value6Y[11],100,100);
		if(berry>=12)
			batch.draw(new Texture("Strawberrry.png"), value6X[12], value6Y[12],100,100);
		if(berry>=13)
			batch.draw(new Texture("Strawberrry.png"), value6X[13], value6Y[13],100,100);
		if(berry>=14)
			batch.draw(new Texture("Strawberrry.png"), value6X[14], value6Y[14],100,100);
		if(berry>=15)
			batch.draw(new Texture("Strawberrry.png"), value6X[15], value6Y[15],100,100);
		if(berry>=16)
			batch.draw(new Texture("Strawberrry.png"), value6X[16], value6Y[16],100,100);
		if(berry>=17)
			batch.draw(new Texture("Strawberrry.png"), value6X[17], value6Y[17],100,100);
		if(berry>=18)
			batch.draw(new Texture("Strawberrry.png"), value6X[18], value6Y[18],100,100);
		if(berry>=19)
			batch.draw(new Texture("Strawberrry.png"), value6X[19], value6Y[19],100,100);
		if(berry>=20)
			batch.draw(new Texture("Strawberrry.png"), value6X[20], value6Y[20],100,100);

	}
	public void Bananas(SpriteBatch batch)
	{
		if(bananas>=1)
			batch.draw(new Texture("Bannana.png"), value7X[1], value7Y[1],100,100);
		if(bananas>=2)
			batch.draw(new Texture("Bannana.png"), value7X[2], value7Y[2],100,100);
		if(bananas>=3)
			batch.draw(new Texture("Bannana.png"), value7X[3], value7Y[3],100,100);
		if(bananas>=4)
			batch.draw(new Texture("Bannana.png"), value7X[4], value7Y[4],100,100);
		if(bananas>=5)
			batch.draw(new Texture("Bannana.png"), value7X[5], value7Y[5],100,100);
		if(bananas>=6)
			batch.draw(new Texture("Bannana.png"), value7X[6], value7Y[6],100,100);
		if(bananas>=7)
			batch.draw(new Texture("Bannana.png"), value7X[7], value7Y[7],100,100);
		if(bananas>=8)
			batch.draw(new Texture("Bannana.png"), value7X[8], value7Y[8],100,100);
		if(bananas>=9)
			batch.draw(new Texture("Bannana.png"), value7X[9], value7Y[9],100,100);
		if(bananas>=10)
			batch.draw(new Texture("Bannana.png"), value7X[10], value7Y[10],100,100);
		if(bananas>=11)
			batch.draw(new Texture("Bannana.png"), value7X[11], value7Y[11],100,100);
		if(bananas>=12)
			batch.draw(new Texture("Bannana.png"), value7X[12], value7Y[12],100,100);
		if(bananas>=13)
			batch.draw(new Texture("Bannana.png"), value7X[13], value7Y[13],100,100);
		if(bananas>=14)
			batch.draw(new Texture("Bannana.png"), value7X[14], value7Y[14],100,100);
		if(bananas>=15)
			batch.draw(new Texture("Bannana.png"), value7X[15], value7Y[15],100,100);
		if(bananas>=16)
			batch.draw(new Texture("Bannana.png"), value7X[16], value7Y[16],100,100);
		if(bananas>=17)
			batch.draw(new Texture("Bannana.png"), value7X[17], value7Y[17],100,100);
		if(bananas>=18)
			batch.draw(new Texture("Bannana.png"), value7X[18], value7Y[18],100,100);
		if(bananas>=19)
			batch.draw(new Texture("Bannana.png"), value7X[19], value7Y[19],100,100);
		if(bananas>=20)
			batch.draw(new Texture("Bannana.png"), value7X[20], value7Y[20],100,100);

	}
	public void CookieDough(SpriteBatch batch)
	{
		if(dough>=1)
			batch.draw(new Texture("Dough.png"), value8X[1], value8Y[1],100,100);
		if(dough>=2)
			batch.draw(new Texture("Dough.png"), value8X[2], value8Y[2],100,100);
		if(dough>=3)
			batch.draw(new Texture("Dough.png"), value8X[3], value8Y[3],100,100);
		if(dough>=4)
			batch.draw(new Texture("Dough.png"), value8X[4], value8Y[4],100,100);
		if(dough>=5)
			batch.draw(new Texture("Dough.png"), value8X[5], value8Y[5],100,100);
		if(dough>=6)
			batch.draw(new Texture("Dough.png"), value8X[6], value8Y[6],100,100);
		if(dough>=7)
			batch.draw(new Texture("Dough.png"), value8X[7], value8Y[7],100,100);
		if(dough>=8)
			batch.draw(new Texture("Dough.png"), value8X[8], value8Y[8],100,100);
		if(dough>=9)
			batch.draw(new Texture("Dough.png"), value8X[9], value8Y[9],100,100);
		if(dough>=10)
			batch.draw(new Texture("Dough.png"), value8X[10], value8Y[10],100,100);
		if(dough>=11)
			batch.draw(new Texture("Dough.png"), value8X[11], value8Y[11],100,100);
		if(dough>=12)
			batch.draw(new Texture("Dough.png"), value8X[12], value8Y[12],100,100);
		if(dough>=13)
			batch.draw(new Texture("Dough.png"), value8X[13], value8Y[13],100,100);
		if(dough>=14)
			batch.draw(new Texture("Dough.png"), value8X[14], value8Y[14],100,100);
		if(dough>=15)
			batch.draw(new Texture("Dough.png"), value8X[15], value8Y[15],100,100);
		if(dough>=16)
			batch.draw(new Texture("Dough.png"), value8X[16], value8Y[16],100,100);
		if(dough>=17)
			batch.draw(new Texture("Dough.png"), value8X[17], value8Y[17],100,100);
		if(dough>=18)
			batch.draw(new Texture("Dough.png"), value8X[18], value8Y[18],100,100);
		if(dough>=19)
			batch.draw(new Texture("Dough.png"), value8X[19], value8Y[19],100,100);
		if(dough>=20)
			batch.draw(new Texture("Dough.png"), value8X[20], value8Y[20],100,100);

	}









}
