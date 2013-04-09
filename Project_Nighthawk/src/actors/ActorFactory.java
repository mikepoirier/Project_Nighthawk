/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

/**
 *
 * @author Mike
 */
import gameView.GameWindow;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import resourceCache.ResourceCache;

public class ActorFactory
{

    private int nextId;
    private static ActorFactory factory;
    private ResourceCache rc;
    private List<Actor> actorsList;
    private GameWindow currentGameWindow;

    private ActorFactory()
    {
        init();
    }

    /**
     *  This returns the static instance of the Actor Factory.
     * 
     * @return static ActorFactory instance.
     */
    public static ActorFactory getInstance()
    {
        if(factory == null)
        {
            factory = new ActorFactory();
        }
        
        return factory;
    }

    /**
     *  This returns the master list of all the actors created in the game.
     * 
     * @return master actor list
     */
    public List<Actor> getActorList()
    {
        return actorsList;
    }

    public GameWindow getCurrentGameWindow()
    {
        return currentGameWindow;
    }

    public void setCurrentGameWindow(GameWindow currentGameWindow)
    {
        this.currentGameWindow = currentGameWindow;
    }

    /**
     * This creates and returns an actor from an xml file.
     *
     * @param fileName The file location of the xml file.
     * @return
     */
    public Actor createActor(String fileName)
    {

        //Parses the provided XML document and gets the type of the root element
        Document doc = parseXmlFile(fileName);
        Element docEle = doc.getDocumentElement();
        String type = docEle.getAttribute("type");
        String resourceFile = docEle.getAttribute("resource");

        //Partially creates a new Actor from the parsed XML document
        Actor actor = new Actor(nextId, type, currentGameWindow);

        //Get's the components for the Actor and adds them to the actor
        NodeList nl = doc.getElementsByTagName("Component");
        if (nl != null && nl.getLength() > 0)
        {
            for (int i = 0; i < nl.getLength(); i++)
            {
                Element e = (Element) nl.item(i);
                BaseActorComponent ac = getComponent(e, resourceFile);
                ac.setOwner(actor);
                actor.addComponent(ac, ac.getType());
            }
        }

        List componentsList = new ArrayList();
        actor.init();
        actorsList.add(actor);
        nextId++;
        return actor;
    }
    
    public void removeActor(Actor actor)
    {
        actorsList.remove(actor.getmActorID());
        actor = null;
    }

    private Document parseXmlFile(String fileName)
    {
        //Get factory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

        try
        {
            //Using factory to get an instance of document builder
            DocumentBuilder db = docFactory.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            return db.parse(fileName);

        } catch (ParserConfigurationException | SAXException | IOException ex)
        {
            System.out.println("Error in parseXmlFile() in ActorFactory. Returning null.");
            ex.printStackTrace();
            return null;
        }
    }

    private BaseActorComponent getComponent(Element e, String resource)
    {
        String type = e.getAttribute("type");
        BaseActorComponent component = null;

        switch (type)
        {
            case "TransformComponent":
                component = createTransformComponent(e);
                break;
            case "Character2DRenderComponent":
                component = createCharacter2DRenderComponent(e, resource);
                break;
            case "ControlsComponent":
                component = createControlsComponent(e);
                break;
            default:
                component = new BaseActorComponent();
                break;
        }
        return component;
    }

    private BaseActorComponent createControlsComponent(Element e)
    {
        // Will add functionality to choose a different control map and custom controls.
        String actorType = null;
        Element el = null;
        BaseActorComponent component = null;
        NodeList nl = e.getElementsByTagName("Controls");

        if (nl != null && nl.getLength() > 0)
        {
            el = (Element) nl.item(0);
            actorType = el.getAttribute("actor");
        }
        component = new ControlsComponent(actorType);
        return component;
    }

    private BaseActorComponent createTransformComponent(Element e)
    {
        Element el = null;
        int x = 0;
        int y = 0;
        BaseActorComponent component = null;

        NodeList nl = e.getElementsByTagName("Position");
        if (nl != null && nl.getLength() > 0)
        {
            el = (Element) nl.item(0);
            x = Integer.parseInt(el.getAttribute("x"));
            y = Integer.parseInt(el.getAttribute("y"));
        }

        component = new TransformComponent(x, y);

        return component;
    }

    private BaseActorComponent createCharacter2DRenderComponent(Element e, String resource)
    {
        Element el = null;
        String imagesLocation = resource;
        String animationName = "";
        BaseActorComponent component = null;

        NodeList nl = e.getElementsByTagName("Image");
        if (nl != null && nl.getLength() > 0)
        {
            el = (Element) nl.item(0);
            imagesLocation = imagesLocation + el.getAttribute("imagesZipFile");
            animationName = el.getAttribute("imagesZipFile").replaceAll(".zip", "");
        }

        rc.setResourceLocation(imagesLocation);
        BufferedImage[] images = rc.parseImages(animationName);
        return component = new Character2DRenderComponent(images);
    }

    private void init()
    {
        nextId = 0;
        rc = ResourceCache.getInstance();
        actorsList = new ArrayList<>();
    }
}
