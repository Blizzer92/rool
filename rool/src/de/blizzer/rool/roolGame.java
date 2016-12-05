package de.blizzer.rool;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class roolGame extends Game implements ApplicationListener{


    GoogleInterface platformInterface;
    AdControl adControl;

    
    
    
    public roolGame(GoogleInterface aInterface, AdControl realControl){
        this.platformInterface = aInterface;

        adControl = realControl;
        adControl.showAds(false);
    }

    SpriteBatch batch;
    BitmapFont font;

    public void create() {
        //GLTexture.setEnforcePotImages(false);
        batch = new SpriteBatch();
        Texture.setEnforcePotImages(false);
        // Use LibGDX's default Arial font.
        font = new BitmapFont();

        
        this.setScreen(new Splash(this));

    }





    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}