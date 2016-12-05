package de.blizzer.rool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class GameScreen implements Screen{

    final roolGame game;
    Texture ballImage;
    Texture linieright;
    Rectangle lineleft;
    Rectangle lineright;
    Rectangle ball;
    int y = Gdx.graphics.getHeight();
    int punkte = 0;
    float randomwidth;
    float randomheigh;
    Music levelmusic;


    OrthographicCamera camera;

    public GameScreen(final roolGame gam){

        game = gam;
        ballImage = new Texture(Gdx.files.internal("data/Ball.png"));
        linieright = new Texture(Gdx.files.internal("data/linie.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ball = new Rectangle();
        ball.x = 0;
        ball.y = 0;
        ball.height = 58;
        ball.width = 57;
        lineleft = new Rectangle();
        lineleft.x = 0;
        lineleft.y = 0;
        lineleft.height = 10;
        lineleft.width = Gdx.graphics.getWidth();
        lineright = new Rectangle();
        lineright.x = 0;
        lineright.y = 0;
        lineright.height = 10;
        lineright.width = Gdx.graphics.getWidth();
        levelmusic = Gdx.audio.newMusic(Gdx.files.internal("data/sound/DST-1990.mp3"));
        levelmusic.setVolume(0.5f);
        levelmusic.setLooping(true);
        levelmusic.play();
        getRandomwidth();
        getRandomheigh();

        game.adControl.showAds(false);



    }



    public float getRandomwidth()
    {
        randomwidth = MathUtils.random(0, Gdx.graphics.getWidth() - 100);
        return randomwidth;

    }

    public float getRandomheigh()
    {

        randomheigh = MathUtils.random(10, 200);
        return randomheigh;
    }

    @Override
    public void render(float delta) {




        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        game.batch.draw(ballImage,ball.x, ball.y );




        game.batch.draw(linieright,0,y,randomwidth,randomheigh);
        game.batch.draw(linieright,randomwidth + 100 ,y,Gdx.graphics.getWidth() - randomwidth,randomheigh);
        game.font.draw(game.batch, "Punkte: " + punkte, 0, Gdx.graphics.getHeight());



        game.batch.end();


        lineleft.y = y;
        lineleft.height = randomheigh;
        lineleft.width = randomwidth;

        lineright.y = y;
        lineright.height = randomheigh;
        lineright.x = randomwidth + 100;






        if (ball.x < 0)
            ball.x = 0;
        if (ball.x > Gdx.graphics.getWidth() + 58)
            ball.x = Gdx.graphics.getWidth() - 58;
        // if (ball.y > 64 - 64)
        //   ball.y = 64 - 64;

        if((punkte >= 0) && (punkte < 10))
        {
            y = y - 5;
        }


        else if((punkte >= 10) && (punkte < 20))
        {
            y = y - 7;
        }


        else if((punkte >= 20) && (punkte < 30))
        {
            y = y - 8;
        }

        else if((punkte >= 30) && (punkte < 40))
        {
            y = y - 10;
        }

        else if((punkte >= 40) && (punkte < 50))
        {
            y = y - 12;
        }

        else if((punkte >= 50) && (punkte < 60))
        {
            y = y - 14;
        }

        else if((punkte >= 60) && (punkte < 70))
        {
            y = y - 16;
        }

        else if((punkte >= 70))
        {
            y = y - 18;
        }



        if(y <= ball.y - randomheigh)
        {
            y=Gdx.graphics.getHeight();
            getRandomwidth();
            getRandomheigh();
            punkte += 1;
        }

        if(Intersector.overlapRectangles(ball, lineleft) || Intersector.overlapRectangles(ball, lineright))
        {

            game.setScreen(new GameOverScreen(game, punkte));
            dispose();

        }

        if (Gdx.input.isTouched()) {
            ball.x = Gdx.input.getX() - 32;
            ball.y = Gdx.graphics.getHeight() - Gdx.input.getY() + 58;

        }
    }



    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {



    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        levelmusic.stop();
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
        ballImage.dispose();
        linieright.dispose();
        levelmusic.stop();
        levelmusic.dispose();
        punkte = 0;
        ball.x = 0;
        ball.y = 0;




    }

}
