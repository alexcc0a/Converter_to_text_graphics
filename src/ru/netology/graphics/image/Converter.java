//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.netology.graphics.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Converter implements TextGraphicsConverter {
    private int maxWidth = 200;
    private int maxHeight = 400;
    private double maxRatio;
    private TextColorSchema schema;

    public Converter() {
    }

    public String convert(String url) throws IOException, BadImageSizeException {
        BufferedImage img = ImageIO.read(new URL(url));
        if (!this.checkRatio(img)) {
            throw new BadImageSizeException((double)Math.abs(img.getWidth() / img.getHeight()), this.maxRatio);
        } else {
            if (this.schema == null) {
                this.schema = new TextColorSchemaDefault();
            }

            double scale = this.calculateScale(img.getWidth(), img.getHeight());
            int newHeight = (int)((double)img.getHeight() / scale);
            int newWidth = (int)((double)img.getWidth() / scale);
            Image scaledImage = img.getScaledInstance(newWidth, newHeight, 4);
            BufferedImage bwImg = new BufferedImage(newWidth, newHeight, 10);
            Graphics2D graphics = bwImg.createGraphics();
            graphics.drawImage(scaledImage, 0, 0, (ImageObserver)null);
            WritableRaster bwRaster = bwImg.getRaster();
            StringBuilder picture = new StringBuilder();

            for(int h = 0; h < bwRaster.getHeight(); ++h) {
                for(int w = 0; w < bwRaster.getWidth(); ++w) {
                    int color = bwRaster.getPixel(w, h, new int[3])[0];
                    char c = this.schema.convert(color);
                    picture.append(c).append(c);
                }

                picture.append('\n');
            }

            return picture.toString();
        }
    }

    private double calculateScale(int width, int height) {
        if ((this.maxHeight >= height || this.maxHeight == 0) && (this.maxWidth >= width || this.maxWidth == 0)) {
            return 1.0D;
        } else {
            double heightScale = (double)height / (double)this.maxHeight;
            double widthScale = (double)width / (double)this.maxWidth;
            return Math.max(heightScale, widthScale);
        }
    }

    private boolean checkRatio(BufferedImage img) {
        if (this.maxRatio != 0.0D) {
            double currentRatio = (double)Math.abs(img.getWidth() / img.getHeight());
            return !(this.maxRatio < currentRatio);
        } else {
            return true;
        }
    }

    public void setMaxWidth(int width) {
        this.maxWidth = width;
    }

    public void setMaxHeight(int height) {
        this.maxHeight = height;
    }

    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    public void setTextColorSchema(TextColorSchema schema) {
        this.schema = schema;
    }
}
