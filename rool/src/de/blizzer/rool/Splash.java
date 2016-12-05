package de.blizzer.rool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class Splash implements Screen{

	
	final roolGame game;
	private Texture splsh;
	private float size;
	private float posi;
	private float posi2;
	
	 public Splash(final roolGame gam) {
		game = gam;
		splsh = new Texture(Gdx.files.internal("data/Logo/blizzer-logo.png"));
		size = (float)(Gdx.graphics.getWidth() * 0.9);
		posi = (float)(Gdx.graphics.getWidth() * 0.5 - (size / 2));
		posi2 = (float)(Gdx.graphics.getHeight() * 0.5 - (size / 2));
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(splsh, posi , posi2 ,size,size);

        game.batch.end();
        
        if(game.platformInterface.getSignedInGPGS())
                game.setScreen(new MainMenuScreen(game));
        
        else
        	game.setScreen(new MainMenuScreen(game));
        

		
	}
	
	

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
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

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		splsh.dispose();
		
	}

}
