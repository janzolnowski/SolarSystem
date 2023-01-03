package planets;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Objects;


public class AnimationPanel extends JPanel implements Runnable{

	@Serial
    private static final long serialVersionUID = 1L;

    private final Planet sun;
    private final Planet mercury;
    private final Planet venus;
    private final Planet earth;
    private final Planet mars;
    private final Planet jupiter;
    private final Planet saturn;
    private final Planet uran;
    private final Planet neptune;
    private final Moon moon;
    private final Moon marsMoon1;
    private final Moon marsMoon2;
    private final Moon jupiterMoon1;
    private final Moon jupiterMoon2;
    private final Moon jupiterMoon3;
    private final Moon saturnMoon1;
    private final Moon saturnMoon2;
    private final Moon saturnMoon3;
    private final Moon saturnMoon4;

    private final Moon uranMoon1;
    private final Moon uranMoon2;
    private final Moon neptuneMoon;


    private final Image background;

    private final ArrayList<Planet> planets;
    private final ArrayList<Moon> moons;
    private boolean isPaused = false;

    public AnimationPanel() throws IOException {
        setDoubleBuffered(true);
        this.background = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("sky.png")));

        // Pictures source : https://en.wikipedia.org/wiki/Solar_System

        this.sun = new Planet(0, 0, "sun.jfif");
        this.earth = new Planet( 15 , 0.025, "earth.jpg");
        this.mercury = new Planet(-40 , earth.getSpeed()/0.44, "mercury.jpg");
        this.venus = new Planet(-20 , earth.getSpeed()/0.61, "wenus.jpg");
        this.mars = new Planet(50 , earth.getSpeed()/0.91, "mars.jpg");
        this.jupiter = new Planet( 110, earth.getSpeed()/3.4, "jupiter.jpg");
        this.saturn = new Planet(170, earth.getSpeed()/5.8, "saturn.jpg");
        this.uran = new Planet( 230, earth.getSpeed()/8.5, "uran.jfif");
        this.neptune =  new Planet(260, earth.getSpeed()/11.3, "neptun.jpg");

        this.moon = new Moon(20,  0.08, "moon.jpg");
        this.marsMoon1 = new Moon(17, 0.07, "moon.jpg");
        this.marsMoon2 = new Moon(25, 0.05, "mercury.jpg");
        this.jupiterMoon1 = new Moon(33, 0.061, "moon.jpg");
        this.jupiterMoon2 = new Moon(37, 0.067, "wenus.jpg");
        this.jupiterMoon3 = new Moon(40, 0.077, "neptun.jpg");
        this.saturnMoon1 = new Moon(26, 0.063, "moon.jpg");
        this.saturnMoon2 = new Moon(33, 0.069, "mars.jpg");
        this.saturnMoon3 = new Moon(36, 0.048, "moon.jpg");
        this.saturnMoon4 = new Moon(44, 0.082, "wenus.jpg");
        this.uranMoon1 = new Moon(25, 0.047, "moon.jpg");
        this.uranMoon2 = new Moon(30, 0.06, "wenus.jpg");
        this.neptuneMoon = new Moon(30, 0.07, "moon.jpg");



        this.planets = new ArrayList<>();
        planets.add(mercury);
        planets.add(venus);
        planets.add(earth);
        planets.add(mars);
        planets.add(jupiter);
        planets.add(saturn);
        planets.add(uran);
        planets.add(neptune);

        this.moons = new ArrayList<>();
        moons.add(moon);
        moons.add(marsMoon1);
        moons.add(marsMoon2);
        moons.add(jupiterMoon1);
        moons.add(jupiterMoon2);
        moons.add(jupiterMoon3);
        moons.add(saturnMoon1);
        moons.add(saturnMoon2);
        moons.add(saturnMoon3);
        moons.add(saturnMoon4);
        moons.add(uranMoon1);
        moons.add(uranMoon2);
        moons.add(neptuneMoon);


        Thread animThreat = new Thread(this);
        animThreat.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.GRAY);
        g2.drawImage(background, 0,0, 900,900,this);

        g2.drawOval(mercury.getOrbit().get(0), mercury.getOrbit().get(1), mercury.getOrbit().get(2), mercury.getOrbit().get(3));
        g2.drawOval(venus.getOrbit().get(0), venus.getOrbit().get(1), venus.getOrbit().get(2), venus.getOrbit().get(3));
        g2.drawOval(earth.getOrbit().get(0), earth.getOrbit().get(1), earth.getOrbit().get(2), earth.getOrbit().get(3));
        g2.drawOval(mars.getOrbit().get(0), mars.getOrbit().get(1), mars.getOrbit().get(2), mars.getOrbit().get(3));
        g2.drawOval(jupiter.getOrbit().get(0), jupiter.getOrbit().get(1), jupiter.getOrbit().get(2), jupiter.getOrbit().get(3));
        g2.drawOval(saturn.getOrbit().get(0), saturn.getOrbit().get(1), saturn.getOrbit().get(2), saturn.getOrbit().get(3));
        g2.drawOval(uran.getOrbit().get(0), uran.getOrbit().get(1), uran.getOrbit().get(2), uran.getOrbit().get(3));
        g2.drawOval(neptune.getOrbit().get(0), neptune.getOrbit().get(1), neptune.getOrbit().get(2), neptune.getOrbit().get(3));
        
        g2.drawImage(sun.getImage(), 380, 350,90,83, this);
        g2.drawImage(mercury.getImage(), mercury.getX(), mercury.getY(),12,12, this);
        g2.drawImage(venus.getImage(), venus.getX(), venus.getY(),13,13, this);
        g2.drawImage(earth.getImage(), earth.getX(), earth.getY(), 18, 18, this);
        g2.drawImage(mars.getImage(), mars.getX(), mars.getY() ,16,16,this);
        g2.drawImage(jupiter.getImage(), jupiter.getX(), jupiter.getY(), 35,35,this);
        g2.drawImage(saturn.getImage(), saturn.getX(), saturn.getY(), 30, 30, this);
        g2.drawImage(uran.getImage(), uran.getX(), uran.getY(), 25, 25, this);
        g2.drawImage(neptune.getImage(), neptune.getX(), neptune.getY(), 30, 30, this);
        g2.drawImage(moon.getImage(), moon.getX(), moon.getY(), 4, 4, this);
        g2.drawImage(marsMoon1.getImage(), marsMoon1.getX(), marsMoon1.getY(), 4, 4, this);
        g2.drawImage(marsMoon2.getImage(), marsMoon2.getX(), marsMoon2.getY(), 3, 3, this);
        g2.drawImage(jupiterMoon1.getImage(), jupiterMoon1.getX(), jupiterMoon1.getY(), 3, 3, this);
        g2.drawImage(jupiterMoon2.getImage(), jupiterMoon2.getX(), jupiterMoon2.getY(), 5, 5, this);
        g2.drawImage(jupiterMoon3.getImage(), jupiterMoon3.getX(), jupiterMoon3.getY(), 8, 8, this);
        g2.drawImage(saturnMoon1.getImage(), saturnMoon1.getX(), saturnMoon1.getY(), 3, 3, this);
        g2.drawImage(saturnMoon2.getImage(), saturnMoon2.getX(), saturnMoon2.getY(), 5, 5, this);
        g2.drawImage(saturnMoon3.getImage(), saturnMoon3.getX(), saturnMoon3.getY(), 8, 8, this);
        g2.drawImage(saturnMoon4.getImage(), saturnMoon4.getX(), saturnMoon4.getY(), 3, 3, this);
        g2.drawImage(uranMoon1.getImage(), uranMoon1.getX(), uranMoon1.getY(), 4, 4, this);
        g2.drawImage(uranMoon2.getImage(), uranMoon2.getX(), uranMoon2.getY(), 4, 4, this);
        g2.drawImage(neptuneMoon.getImage(), neptuneMoon.getX(), neptuneMoon.getY(), 6, 6, this);


    }
    public void movement() {
        mercury.movement();
        venus.movement();
        earth.movement();
        mars.movement();
        jupiter.movement();
        saturn.movement();
        uran.movement();
        neptune.movement();
        moon.movement(earth);
        marsMoon1.movement(mars);
        marsMoon2.movement(mars);
        jupiterMoon1.movement(jupiter);
        jupiterMoon2.movement(jupiter);
        jupiterMoon3.movement(jupiter);
        saturnMoon1.movement(saturn);
        saturnMoon2.movement(saturn);
        saturnMoon3.movement(saturn);
        saturnMoon4.movement(saturn);
        uranMoon1.movement(uran);
        uranMoon2.movement(uran);
        neptuneMoon.movement(neptune);


    }

    public void run() {
        
        while (true) {

        	if (!isPaused)
        	{
        		movement();
        		repaint();
        	}

            try {
                int refreshRate = 10;
                Thread.sleep(refreshRate);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            
        }
    }

    public void switchAnimationState()
    {
    	isPaused = !isPaused;
    }
    public void faster(){
        for (Planet p : planets){
            p.setSpeed(p.getSpeed() + 0.005);
        }
    }
    public void slower(){
        for (Planet p : planets){
            p.setSpeed(p.getSpeed() - 0.005);
        }
    }

    public void changeSpeed(double v) {
        for (Planet p : planets){
            p.setSpeed(v);
        }
    }
}