package planets;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Planet {
    private int x;
    private int y;
    private final int alpha;
    private double angle;
    private double speed;
    private final Image image;
    private final ArrayList<Integer> orbitParams;

    public Planet(int alpha, double speed, String imageName) throws IOException {
        this.alpha = alpha;
        this.angle = 0.1;
        this.speed = speed;
        this.image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource(imageName)));
        this.orbitParams = new ArrayList<>();

    }

    public void movement(){
        this.setX((int) (420 + ((150 + alpha) * Math.cos((this.getAngle())))));
        this.setY((int)(385 + ((100 + alpha) * Math.sin(this.getAngle()))));
        this.setAngle(this.getAngle() + this.getSpeed());
    }

    public ArrayList<Integer> getOrbit(){
        orbitParams.add(276 - alpha);
        orbitParams.add(292 - alpha);
        orbitParams.add((150 + alpha) * 2);
        orbitParams.add((100 + alpha) * 2);
        return orbitParams;
    }



    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }
    public int getAlpha() {
        return alpha;
    }

    public int getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public double getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
