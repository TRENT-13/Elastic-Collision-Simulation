import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.Color;


public class Particle {

    private static final double INFINITY = Double.POSITIVE_INFINITY;

    private double rx, ry; // location
    private double vx, vy; // velocity
    private  double radius;
    private double mass;
    private int count;
    private Color color;

    public  Particle(double rx, double ry, double vx, double vy, double radius, double mass, Color color) {
        // validity check
        isValid(rx, ry, vx, vy, radius, mass);
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
        this.mass = mass;
        this.color = color;
    }

    private void isValid(double x, double y,double vx, double vy, double radius, double mass) {
        if(!(radius > 0)) throw new IllegalArgumentException("radius must be greater than 0");
        if(!(mass > 0)) throw new IllegalArgumentException("mass must be greater than 0");
        if(rx - radius < -1.0 || rx + radius > 1.0) throw new IllegalArgumentException("radius must be greater than 0");
        if (ry - radius < -1.0 || ry + radius > 1.0) throw new IllegalArgumentException("radius must be greater than 0");
    }



    public Particle() {
        rx = StdRandom.uniformDouble(0.0, 1.0);
        ry = StdRandom.uniformDouble(0.0, 1.0);
        vx = StdRandom.uniformDouble(-0.005, 0.005);
        vy = StdRandom.uniformDouble(-0.005, 0.005);
        radius = 0.02;
        mass = 0.5;
        color = Color.BLACK;
    }

    //after a time position
    public void move(double dt) {
        rx += vx*dt;
        ry += vy*dt;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(rx, ry, radius);
    }

    public int count() {
        return count;
    }


    public double timeToHit(Particle that) {
        if(this == that) return INFINITY;
        double dx = that.rx - this.rx;
        double dy = that.ry - this.ry;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy*dvy;
        if(dvdr < 0) return INFINITY;
        double dvdv = dvx*dvx + dvy*dvy;
        if(dvdv < 0) return INFINITY;
        double drdr = dx*dx + dy*dy;
        double sigma = this.radius + that.radius;
        double d = (drdr*dvdr) -dvdv * (drdr - sigma*sigma);
        if(d < 0) return INFINITY;
        double t = - (dvdr + Math.sqrt(d)) / dvdv;
        if(t < 0) return INFINITY;
        return t;
    }


    public double timeToHitVerticalWall() {
        if (vx > 0 ) return (1.0 - rx - radius) / vx;
        if (vx < 0 ) return  (radius -rx) / vx;
        else return INFINITY;
    }

    public double timeToHitHorizontalWall() {
        if (vy > 0 ) return (1.0 - ry - radius) / vy;
        if (vy < 0 ) return  (radius - ry) / vy;
        else return INFINITY;
    }

    public void bounceOff(Particle that) {
        double dx = that.rx - this.rx;
        double dy = that.ry - this.ry;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy*dvy;
        double dist = this.radius + that.radius;

        // magnitude of normal force
        double magnitude = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);

        double fx = magnitude * dx / dist;
        double fy = magnitude * dy / dist;

        // update velocities according to normal force
        this.vx += fx / this.mass;
        this.vy += fy / this.mass;
        that.vx -= fx / that.mass;
        that.vy -= fy / that.mass;

        // update collision counts
        this.count++;
        that.count++;
    }


    public void bounceOffVerticalWall() {
        vx = -vx;
        count++;
    }
    public void bounceOffHorizontalWall() {
        vy = -vy;
    }


    public double kineticEnergy() {
        return 0.5 * mass * (vx*vx+vy*vy);
    }
}




