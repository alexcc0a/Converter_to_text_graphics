//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.netology.graphics.image;

public class TextColorSchemaDefault implements TextColorSchema {
    char[] macOS = new char[]{'▇', '●', '◉', '◍', '◎', '○', '☉', '◌', '-'};
    char[] windows = new char[]{'#', '$', '@', '%', '*', '+', '-', '\''};

    public TextColorSchemaDefault() {
    }

    public char convert(int color) {
        return System.getProperty("os.name").startsWith("Windows") ? this.windows[(int)Math.floor((double)color / (256.0D / (double)this.windows.length))] : this.macOS[(int)Math.floor((double)color / (256.0D / (double)this.macOS.length))];
    }
}
