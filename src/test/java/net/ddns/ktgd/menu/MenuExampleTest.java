package net.ddns.ktgd.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MenuExampleTest {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        new Lwjgl3Application(new Game() {
            @Override
            public void create() {
                setScreen(new MenuExample(new Skin(Gdx.files.absolute(getClass().getResource("/skins/uiskin.json").getFile()))));
            }
        }, config);
    }
}
