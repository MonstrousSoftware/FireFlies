package com.monstrous.fireflies;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private FireFlies fireFlies;


    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        fireFlies = new FireFlies(100);
    }

    @Override
    public void render() {
        fireFlies.update(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.35f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(image, 140, 210);
        fireFlies.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        fireFlies.dispose();
    }
}
