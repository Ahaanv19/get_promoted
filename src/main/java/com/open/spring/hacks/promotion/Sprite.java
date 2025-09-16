
// Sprite game object java file
package com.open.spring.hacks.promotion;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import com.open.spring.hacks.promotion.Camera;
import com.open.spring.hacks.promotion.Function;

class Transform {
    float x, y;
    float xv, yv;
    int rotation;
    float scaleX, scaleY;

    Transform() {
        this.x = 0;
        this.y = 0;
        this.xv = 0;
        this.yv = 0;
        this.rotation = 0;
        this.scaleX = 1;
        this.scaleY = 1;
    }
}

class Image {
    String src;
    BufferedImage img;

    ImageWrapper(String src) {
        this.src = src;
        try {
            this.image = ImageIO.read(new File(src));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int getWidth() {
        return (image != null) ? image.getWidth() : 0;
    }

    int getHeight() {
        return (image != null) ? image.getHeight() : 0;
    }
}

class Hitbox {
    int width, height;

    Hitbox(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void MatchHitboxToImage(Image src) {
        this.width = src.getWidth();
        this.height = src.getHeight();
    }
}

class Qualities {
    boolean isVisible;
    boolean isCollidable;
    boolean isStatic;
    int id;

    Qualities(int id) {
        this.isVisible = true;
        this.isCollidable = true;
        this.isStatic = true;
        this.id = id;
    }
}


@RestController
@RequestMapping("/promotion")
@CrossOrigin(origins = "*")
public class Sprite {

    @GetMapping("/sprite")
    public Map<String, Object> getSprite() {
        Map<String, Object> spriteData = new HashMap<>();
        Map<String, Object> transform = new HashMap<>();
        transform.put("x", 100);
        transform.put("y", 200);
        transform.put("xv", 0);
        transform.put("yv", 0);
        transform.put("rotation", 0);
        transform.put("scaleX", 1);
        transform.put("scaleY", 1);

        spriteData.put("transform", transform);
        spriteData.put("sprite", "promotion-imgs/null-image.png");
        spriteData.put("hitbox", Map.of("width", 64, "height", 64));
        spriteData.put("qualities", Map.of("isVisible", true, "isCollidable", true, "isStatic", true, "id", 1));

        return spriteData;
    }

    public void update() {
        this.transform.xv *= 0.9f;
        this.transform.yv *= 0.9f;
        this.transform.x += this.transform.xv;
        this.transform.y += this.transform.yv;
    }

    public float getOnscreenPosition(Camera camera) {
        float onscreenX, onscreenY = Rotate(this.transform.x - camera.transform.x, this.transform.y - camera.transform.y, -camera.transform.rotation);
        onscreenX = (this.transform.x - camera.transform.x) * camera.transform.zoom;
        onscreenY = (this.transform.y - camera.transform.y) * camera.transform.zoom;
        float onscreenScaleX = this.transform.scaleX * camera.transform.zoom;
        float onscreenScaleY = this.transform.scaleY * camera.transform.zoom;
        float onscreenRotation = this.transform.rotation - camera.transform.rotation;
        
        return onscreenX, onscreenY, onscreenScaleX, onscreenScaleY, onscreenRotation;
    }
}