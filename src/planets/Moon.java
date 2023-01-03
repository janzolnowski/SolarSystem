package planets;

import java.io.IOException;

public class Moon extends Planet{

    private final int alpha;
    private final double speed;

    public Moon(int alpha, double speed, String imageName) throws IOException {
        super(alpha, speed, imageName);
        this.alpha = alpha;
        this.speed = speed;

    }

    public void movement(Planet planet) {
        this.setX((int) (planet.getX() + 6 + ((alpha) * Math.cos((this.getAngle())))));
        this.setY((int)(planet.getY() + 10 + ((alpha) * Math.sin(this.getAngle()))));
        this.setAngle(this.getAngle() + this.getSpeed());
    }
}
