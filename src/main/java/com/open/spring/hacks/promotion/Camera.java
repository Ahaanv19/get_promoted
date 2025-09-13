
package com.open.spring.hacks.promotion;

class Transform {
    float x, y;
    float xv, yv;
    int rotation;
    float zoom;

    Transform() {
        this.x = 0;
        this.y = 0;
        this.xv = 0;
        this.yv = 0;
        this.rotation = 0;
        this.zoom = 1;
    }
}

class Target {
    float x, y;
    int rotation;
    float zoom;

    Target(float x, float y, int rotation, float zoom) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.zoom = zoom;
    }
}

public class Camera {
    float speed = 0.1f;
    Transform transform;
    Target target;

    Camera() {
        this.transform = new Transform();
        this.target = new Target(0, 0, 0, 1);
    }

    void update() {
        this.transform.xv = (this.target.x - this.transform.x) * speed;
        this.transform.yv = (this.target.y - this.transform.y) * speed;
        this.transform.x += transform.xv;
        this.transform.y += transform.yv;
        this.transform.rotation += (this.target.rotation - this.transform.rotation) * speed;
        this.transform.zoom += (this.target.zoom - this.transform.zoom) * speed;
    }
}