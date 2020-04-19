package net.ddns.ktgd.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
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

    void show() {
        Gdx.input.setInputProcessor(stage);
    }

    void act(float delta) {
        stage.act(delta);
    }

    void draw() {
        stage.draw();
    }

    void resize(int newWidth, int newHeight) {
        stage.getViewport().update(newWidth, newHeight);
    }

    public void dispose() {
        stage.dispose();
    }
}
