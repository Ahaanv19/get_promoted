package com.open.spring.hacks.promotion;
import com.open.spring.hacks.promotion.Sprite;

class Player extends Sprite {
    Player(String imgSrc, int hitboxWidth, int hitboxHeight) {
        super(imgSrc, hitboxWidth, hitboxHeight);
    }

    void update() {
        this.transform.xv = 0.0f;
        this.transform.x += this.transform.xv;
        this.transform.y += this.transform.yv;

        if (this.transform.x > 800) {
            this.transform.x = 0;
        }
    }
}