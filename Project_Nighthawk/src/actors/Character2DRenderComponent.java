/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import java.awt.image.BufferedImage;

/**
 *
 * @author Mike
 */
public class Character2DRenderComponent extends BaseActorComponent implements IComponent
{

    private String type = "Character2DRenderComponent";
    private BufferedImage[] characterAnimation = null;
    private BufferedImage currentImage = null;
    private int slideNumber;
    private int totalSlides;

    public Character2DRenderComponent(BufferedImage[] images)
    {
        this.characterAnimation = images;
        this.currentImage = images[0];
    }

    @Override
    public String getType()
    {
        return type;
    }

    @Override
    public BufferedImage[] getCharacterAnimation()
    {
        return characterAnimation;
    }

    @Override
    public void setCharacterAnimation(BufferedImage[] characterAnimation)
    {
        this.characterAnimation = characterAnimation;
        currentImage = this.characterAnimation[0];
        slideNumber = 0;

        // This is the total amount of images in the array.
        totalSlides = this.characterAnimation.length - 1;
    }

    public BufferedImage getCurrentImage()
    {
        return currentImage;
    }

    @Override
    public void resetAnimation()
    {
        if (characterAnimation == null)
        {
            System.err.println("No animation to reset. Please set character animation.");
        }
        else
        {
            System.out.println("Resetting the animation in C2DRComp.resetAnimation()");
            currentImage = characterAnimation[0];
            slideNumber = 0;
        }
    }

//    @Override
//    public BufferedImage getStillImage()
//    {
//        resetAnimation();
//        return currentImage;
//    }
    
    @Override
    public void animate()
    {
        if (slideNumber != characterAnimation.length -1)
        {
            // Gets the next image in the array
            currentImage = characterAnimation[++slideNumber];
//            slideNumber++;
        }
        else if (slideNumber == characterAnimation.length - 1)
        {
            slideNumber = 0;
            currentImage = characterAnimation[slideNumber];
        }
        else
        {
            System.err.println("Image index out of bounds. Resetting it to 0.");
            slideNumber = 0;
            currentImage = characterAnimation[slideNumber];
        }
    }

    @Override
    public BufferedImage getAnimation()
    {
        System.out.println("Animating the actor.");
        if (slideNumber != characterAnimation.length - 1)
        {
            // Gets the next image in the array
            currentImage = characterAnimation[++slideNumber];
            System.out.println("Character image advanced to: " + slideNumber);
        }
        else if (slideNumber == characterAnimation.length - 1)
        {
            slideNumber = 0;
            currentImage = characterAnimation[slideNumber];
            System.out.println("Reached end of animation, setting it back to 0.");
        }
        else
        {
            System.err.println("Image index out of bounds. Resetting it to 0.");
            slideNumber = 0;
            currentImage = characterAnimation[slideNumber];
        }
        // For debugging purposes
//        try {
//            ImageIO.write(currentImage, "png", new File("../../Assets/out.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(Character2DRenderComponent.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return currentImage;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    public boolean isAnimationEmpty()
    {
        boolean result = false;
        if (characterAnimation[0] == null)
        {
            result = true;
        }
        return result;
    }
}