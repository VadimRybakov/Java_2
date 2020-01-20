package circles;

import java.awt.*;

public class Background {
    private Color backgroundColor;
    Color[] colors = new Color[100];
    {
        for(int i = 0; i < colors.length; i++){
            colors[i] = new Color (
                    (int)(Math.random() * 128),
                    (int)(Math.random() * 128),
                    (int)(Math.random() * 128)
            );
        }
    }
/*    Background(){
        this.backgroundColor = colors[(int)(Math.random() * colors.length)];
    }*/
    void update(GameCanvas canvas, float deltaTime) {
        if(deltaTime > 0.025){
            this.backgroundColor = colors[(int)(Math.random() * colors.length)];
        }
    }
    void render(GameCanvas canvas) {
        canvas.setBackground(backgroundColor);
    }
}
