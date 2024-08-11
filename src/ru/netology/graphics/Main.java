//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.netology.graphics;

import ru.netology.graphics.image.Converter;
import ru.netology.graphics.image.TextGraphicsConverter;
import ru.netology.graphics.server.GServer;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new Converter();
        converter.setMaxHeight(100);
        converter.setMaxWidth(100);
        GServer server = new GServer(converter);
        server.start();
    }
}
