package de.blizzer.rool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class MainMenuScreen implements Screen {

    final roolGame game;
    Texture btImageplay;
    Texture leadboard;
    Texture achivments;
    Texture logo;
    Texture btGbase;
    Rectangle btGBase;
    Rectangle btstart;
    Rectangle btleaderboards;
    Rectangle btachivments;
    private float size;
    private float posi;
	private float posi2;

    OrthographicCamera camera;

    public MainMenuScreen(final roolGame gam) {
        game = gam;
       
        size = (float)(Gdx.graphics.getWidth() * 0.9);
        posi = (float)(Gdx.graphics.getWidth() * 0.5 - (size / 2));
		posi2 = (float)(Gdx.graphics.getHeight() * 0.75 - (size / 2));
		
        btImageplay = new Texture(Gdx.files.internal("data/playbutton.png"));
        logo = new Texture(Gdx.files.internal("data/Ball-logo.png"));
        leadboard = new Texture(Gdx.files.internal("data/games_leaderboards.png"));
        achivments = new Texture(Gdx.files.internal("data/games_achievements.png"));


        btstart = new Rectangle(90,Gdx.graphics.getHeight() - 500, Gdx.graphics.getWidth() - 180, 100);
        
        btGBase = new Rectangle(150, 120, 160, 54);
        btGbase = new Texture(Gdx.files.internal("data/GButton/Red-signin_Medium_base_44dp.png"));

        btachivments = new Rectangle(15, 120, 120, 120);
        btleaderboards = new Rectangle(Gdx.graphics.getWidth() - 135, 120, 120, 120);
        

        
        

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
        
        if(!game.platformInterface.getSignedInGPGS())
        {
        
        game.batch.draw(btGbase, 160, 150, 160, 54);
        }
        
        else{

        
        game.batch.draw(leadboard, Gdx.graphics.getWidth() - 135, 120, 120, 120);
        game.batch.draw(achivments, 15, 120, 120, 120);
        }
        game.batch.draw(logo, posi, posi2, size, size);
        
        
        game.batch.draw(btImageplay, 90, Gdx.graphics.getHeight() - 500, Gdx.graphics.getWidth() - 180, 100);

        game.batch.end();

        if (Gdx.input.justTouched()) {

                if (btstart.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                    game.setScreen(new GameScreen(game));
                    dispose();
                }

                if (btachivments.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {

                    game.platformInterface.getAchievementsGPGS();

                }
                if (btGBase.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {

                    game.platformInterface.loginGPGS();

                }
                if (btleaderboards.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {

                    game.platformInterface.getLeaderboardGPGS();

                }

        }
    }






    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
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
    	btGbase.dispose();
        btImageplay.dispose();
        logo.dispose();
        achivments.dispose();
        leadboard.dispose();
    }

}
