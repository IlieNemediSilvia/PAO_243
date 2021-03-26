package streams;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Main8 {
    public static void main(String[] args) {
        try {
            BufferedImage imageA = ImageIO.read(new File("data/imageA.png"));
            BufferedImage imageB = ImageIO.read(new File("data/imageB.png"));

            if(imageA.getWidth() != imageB.getWidth() || imageA.getHeight() != imageB.getHeight()){
                throw new IllegalArgumentException("Dimensions are not the same.");
            }
            BufferedImage imageAB = new BufferedImage(imageA.getWidth(), imageA.getHeight(), TYPE_INT_RGB);
            for(int y= 0; y < imageAB.getHeight(); y++){
                for(int x = 0; x< imageAB.getWidth(); x++){
                    imageAB.setRGB(x, y, imageA.getRGB(x, y) & imageB.getRGB(x, y));
                }
            }
            ImageIO.write(imageAB, "png", new File("data/imageAB.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
