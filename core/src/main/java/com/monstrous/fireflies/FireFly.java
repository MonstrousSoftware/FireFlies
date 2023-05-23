package com.monstrous.fireflies;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class FireFly {
    public static final float SPEED = 15f; // pixels/s
    public static final float MAX_RUN = 5f; // s

    public Vector2 position;
    public Vector2 velocity;
    public float size;
    private float growRate;
    private Vector2 dv;
    private float timer;
    private int width;
    private int height;
    private int margin;

    public FireFly( int width, int height, int textureSize) {
        this.width = width;
        this.height = height;
        this.margin = textureSize;
        int x = MathUtils.random(width);
        int y = MathUtils.random(height);
        position = new Vector2(x,y);
        velocity = new Vector2(SPEED,0);
        velocity.rotateDeg( MathUtils.random(360 ));
        size = MathUtils.random(1,textureSize);
        dv = new Vector2();
    }
    public void update(float deltaTime ){
        timer -= deltaTime;
        if(timer <= 0){
            velocity.rotateDeg(MathUtils.random(90));
            timer = 0.1f* MathUtils.random(MAX_RUN*10);
            float targetSize = MathUtils.random(1, margin);
            growRate = (targetSize-size)/timer;

        }
        dv.set(velocity);
        dv.scl(deltaTime);
        position.add( dv );
        size += growRate * deltaTime;

        // wrap around the screen
        // use a margin to avoid visible popping
        if(position.x < -margin)
            position.x += width+margin;
        else if (position.x >= width)
            position.x -= width+margin;
        if(position.y < -margin)
            position.y += height+margin;
        else if (position.y >= height)
            position.y -= height+margin;

    }
}
