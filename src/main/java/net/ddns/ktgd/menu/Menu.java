package net.ddns.ktgd.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.function.Consumer;

public abstract class Menu implements Screen {
    private MenuStage stage;
    protected final Skin uiSkin;

    public Menu(Skin menuSkin) {
        uiSkin = menuSkin;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}

    protected void changeMenu(MenuStage menu) {
        stage = menu;
        stage.show();
    }

    protected Actor getClickedActor(Actor actor, Consumer<InputEvent> consumer) {
        actor.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                consumer.accept(event);
            }
        });
        return actor;
    }
}
