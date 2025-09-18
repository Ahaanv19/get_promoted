package com.open.spring.hacks.promotion;

// float Rotate(float x, float y, float angle) {
//     float rad = (float) Math.toRadians(angle);
//     float cosA = (float) Math.cos(rad);
//     float sinA = (float) Math.sin(rad);
//     return x * cosA - y * sinA, x * sinA + y * cosA;
// }

float Distance(float x1, float y1, float x2, float y2) {
    return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
}

// I'll add more later for like simplicity or something

private float pointAt(float x1, float y1, float x2, float y2) {
    return (float) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
}