package net.ddns.ktgd.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public final class MenuExample extends Menu {
    //Menu's items
    private final Actor SECOND_MENU_BUTTON;
    private final Actor BUTTON;
    private final Actor QUIT_BUTTON;
    private final Actor LONG_BUTTON;
    private final Actor BACK_BUTTON;

    //Menus
    private MenuStage MAIN_MENU;
    private MenuStage SECOND_MENU;

    {
        SECOND_MENU_BUTTON = getClickedActor(new TextButton("Second menu", uiSkin), (event) -> changeMenu(SECOND_MENU));
        BUTTON = new TextButton("Button", uiSkin);
        QUIT_BUTTON = getClickedActor(new TextButton("Quit", uiSkin), (event) -> Gdx.app.exit());
        LONG_BUTTON = new TextButton("really very long text on this button", uiSkin);
        BACK_BUTTON = getClickedActor(new TextButton("back", uiSkin), (event) -> changeMenu(MAIN_MENU));
    }

    public MenuExample(Skin menuSkin) {
        super(menuSkin);
    }

    @Override
    public void show() {
        MAIN_MENU = new MenuStage(SECOND_MENU_BUTTON, BUTTON, QUIT_BUTTON);
        SECOND_MENU = new MenuStage(LONG_BUTTON, BACK_BUTTON);
        changeMenu(MAIN_MENU);
    }

    @Override
    public void hide() {
        MAIN_MENU.dispose();
        MAIN_MENU = null;
        SECOND_MENU.dispose();
        SECOND_MENU = null;
    }
}
