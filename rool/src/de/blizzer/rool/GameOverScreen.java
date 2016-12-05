package de.blizzer.rool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GameOverScreen implements Screen {
    final roolGame game;
    Texture btImageplay;
    Texture btGbase;
    Rectangle btGBase;
    Rectangle btstart;
    Rectangle btleaderboards;
    Rectangle btachivments;
    Texture leadboard;
    Texture achivments;
    OrthographicCamera camera;
    int put;


    public GameOverScreen(final roolGame gam, int punkte){

        game = gam;
        put = punkte;
        btGbase = new Texture(Gdx.files.internal("data/GButton/Red-signin_Medium_base_44dp.png"));
        
        if(game.platformInterface.getSignedInGPGS())
        {
	        game.platformInterface.submitScoreGPGS(put);
	        if(punkte >= 100)
	         game.platformInterface.unlockAchievementGPGS("CgkIm-Oc9bAUEAIQAg");
	
	        if(punkte >= 200)
	            game.platformInterface.unlockAchievementGPGS("CgkIm-Oc9bAUEAIQAw");
	
	        if(punkte >= 300)
	            game.platformInterface.unlockAchievementGPGS("CgkIm-Oc9bAUEAIQBA");
	
	        if(punkte >= 400)
	            game.platformInterface.unlockAchievementGPGS("CgkIm-Oc9bAUEAIQBQ");
	
	        game.platformInterface.unlockAchievementGPGS("CgkIm-Oc9bAUEAIQAQ");
	        
	       
        }
        
       
        btachivments = new Rectangle(15, 120, 120, 120);
        btleaderboards = new Rectangle(Gdx.graphics.getWidth() - 135, 120, 120, 120);
        btImageplay = new Texture(Gdx.files.internal("data/playbutton.png"));
        leadboard = new Texture(Gdx.files.internal("data/games_leaderboards.png"));
        achivments = new Texture(Gdx.files.internal("data/games_achievements.png"));
        btGBase = new Rectangle(150, 120, 160, 54);
        btstart = new Rectangle(90,Gdx.graphics.getHeight() - 500, Gdx.graphics.getWidth() - 180, 100);
        

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        game.adControl.showAds(true);

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(btImageplay, 90, Gdx.graphics.getHeight() - 500, Gdx.graphics.getWidth() - 180, 100);
        if(game.platformInterface.getSignedInGPGS())
        {
    	
        game.batch.draw(leadboard, Gdx.graphics.getWidth() - 135, 120, 120, 120);
        game.batch.draw(achivments, 15, 120, 120, 120);
        }
        
        else
        {
        	
        	 game.batch.draw(btGbase, 160, 150, 160, 54);
        }
        game.batch.end();

        if (Gdx.input.justTouched()) {


            if(btstart.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()))
            {

                game.setScreen(new GameScreen(game));
                dispose();
            }

            if(btachivments.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()))
            {

                game.platformInterface.getAchievementsGPGS();

            }
            if(btleaderboards.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()))
            {

                game.platformInterface.getLeaderboardGPGS();

            }
            
            if (btGBase.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {

                game.platformInterface.loginGPGS();

            }
        }

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
        leadboard.dispose();
        achivments.dispose();
        btImageplay.dispose();

    }

}
