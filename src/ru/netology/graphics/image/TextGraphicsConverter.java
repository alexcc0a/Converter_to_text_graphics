//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.netology.graphics.image;

import java.io.IOException;

public interface TextGraphicsConverter {
   String convert(String var1) throws IOException, BadImageSizeException;

   void setMaxWidth(int var1);

   void setMaxHeight(int var1);

   void setMaxRatio(double var1);

   void setTextColorSchema(TextColorSchema var1);
}
