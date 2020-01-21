package circles;
import java.awt.*;

public interface CanvasListener {
    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime);
}
