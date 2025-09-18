package com.open.spring.hacks.promotion;

import static java.lang.Math.*;

static float deltaTime() {
    return 0.016f;
}

public class Physics {
    float mass;
    float x;
    float y;
    float xv;
    float yv;
    float xa;
    float ya;
    float force;
    float dir;
    
    public Physics(float mass, float x, float y, float xv, float yv, float xa, float ya) {
        this.mass = mass;
        this.x = x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
        this.xa = xa;
        this.ya = ya;
        this.force = 0;
        this.dir = 0;
    }

    float applyForce(float f) {
        return (f / this.mass) * deltaTime;
    }

    void accelerate(float speed) {
        float rad = this.dir * (float) (PI / 180);
        this.xa += speed * sin(rad);
        this.ya += speed * cos(rad);
    }

    void update() {
        this.force = 0;
        // add force stuff
        accelerate(this.force);
        this.xv += this.xa * deltaTime;
        this.yv += this.ya * deltaTime;
        this.x += this.xv * deltaTime;
        this.y += this.yv * deltaTime;
    }

}

