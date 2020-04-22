package net.ddns.ktgd.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MenuStage {
    private final Stage stage;

    public MenuStage(Actor... items) {
        float width = 0;
        float height = (items.length + 1) * 10;
        for (Actor item : items) {
            height += item.getHeight();
            width = Math.max(width, item.getWidth());
        }
        stage = new Stage(new FitViewport(width, height));
        float y = stage.getViewport().getWorldHeight();
        for (Actor item : items) {
            y -= item.getHeight() + 10;
            item.setWidth(width);
            item.setPosition((stage.getViewport().getWorldWidth() - item.getWidth()) / 2, y);
            stage.addActor(item);
        }
    }

    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    public void act(float delta) {
        stage.act(delta);
    }

    public void draw() {
        stage.draw();
    }

    public void resize(int newWidth, int newHeight) {
        stage.getViewport().update(newWidth, newHeight);
    }

    public void dispose() {
        stage.dispose();
    }

    public boolean addListener(EventListener listener) {
        return stage.addListener(listener);
    }

    public boolean addKeyDownListener(KeyDownListener listener) {
        return stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                return listener.keyDown(keycode);
            }
        });
    }

    public Stage getStage() {
        return stage;
    }

    public interface KeyDownListener {
        boolean keyDown(int keycode);
    }
}
