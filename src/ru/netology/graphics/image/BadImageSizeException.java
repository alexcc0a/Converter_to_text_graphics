//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.netology.graphics.image;

public class BadImageSizeException extends Exception {
    public BadImageSizeException(double ratio, double maxRatio) {
        super("Максимальное соотношение сторон изображения " + maxRatio + ", а у этой " + ratio);
    }
}
