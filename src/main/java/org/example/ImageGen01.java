package org.example;

import java.awt.image.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;

public class ImageGen01
{
    final static int LIMIT = 255;
    final static int SIDE = 1024;
    final static int TYPE = BufferedImage.TYPE_INT_RGB;

    public static void main (String[] args)
    {
        BufferedImage image = new BufferedImage(SIDE, SIDE, TYPE);
        int red;
        int blue;
        int green;
        Color color;

        for (int ix = 0; ix < SIDE; ix++)
            for (int jx = 0; jx < SIDE; jx++)
            {
                red = (ix + jx) % LIMIT;

                blue = (ix * jx) % LIMIT;

                green = (ix - jx) % LIMIT;
                if (green < 0) green += LIMIT;
                color =  new Color(red, blue, green);
                image.setRGB(ix, jx, color.getRGB());
            }

        try
        {
            String fileOut = "newfile.jpg";
            File outputfile = new File(fileOut);
            ImageIO.write(image, "jpg", outputfile);
        }
        catch (IOException e)
        {
            System.out.println("could not save file ...");

        }
    }
}
