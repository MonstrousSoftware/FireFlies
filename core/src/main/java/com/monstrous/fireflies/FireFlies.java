package com.monstrous.fireflies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class FireFlies {

    private Array<FireFly> flies;
    private Texture textureParticle;

    public FireFlies(int number) {
        textureParticle = new Texture("particle.png");

        flies = new Array<>();
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();

        for(int i = 0 ; i < number; i++){
            FireFly fly = new FireFly(w, h, textureParticle.getWidth());
            flies.add(fly);
        }
    }

    public void update(float deltaTime ) {
        for (FireFly fireFly : flies) {
            fireFly.update(deltaTime);
        }
    }

    public void render( SpriteBatch batch ) {
        for( FireFly fireFly : flies ){
            batch.draw(textureParticle, fireFly.position.x, fireFly.position.y, fireFly.size, fireFly.size);
        }
    }

    public void dispose() {
        textureParticle.dispose();
    }
}
