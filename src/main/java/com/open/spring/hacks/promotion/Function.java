package com.open.spring.hacks.promotion;

public float Rotate(float x, float y, float angle) {
    float rad = (float) Math.toRadians(angle);
    float cosA = (float) Math.cos(rad);
    float sinA = (float) Math.sin(rad);
    return x * cosA - y * sinA, x * sinA + y * cosA;
}

// I'll add more later for like simplicity or something