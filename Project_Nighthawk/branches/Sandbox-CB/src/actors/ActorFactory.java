/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

/**
 *
 * @author Mike
 */
import graphics2D.ImageUploader;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ActorFactory {

    private int nextId = 1;
    private static ActorFactory factory = new ActorFactory();
    private ImageUploader iu = ImageUploader.getInstance();

    private ActorFactory() {
    }

    public static ActorFactory getInstance() {
        return factory;
    }

    /**
     * This creates and returns an actor from an xml file.
     *
     * @param fileName The file location of the xml file.
     * @return
     */
    public Actor createActor(String fileName) {

        //Parses the provided XML document and gets the type of the root element
        Document doc = parseXmlFile(fileName);
        Element docEle = doc.getDocumentElement();
        String type = docEle.getAttribute("type");

        //Partially creates a new Actor from the parsed XML document
        Actor actor = new Actor(nextId, type);

        //Get's the components for the Actor and adds them to the actor
        NodeList nl = doc.getElementsByTagName("Component");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element e = (Element) nl.item(i);
                BaseActorComponent ac = getComponent(e);
                actor.addComponent(ac, ac.getType());
            }
        }

        List componentsList = new ArrayList();
        nextId++;
        return actor;
    }

    private Document parseXmlFile(String fileName) {
        //Get factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            //Using factory to get an instance of document builder
            DocumentBuilder db = factory.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            return db.parse(fileName);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error in parseXmlFile() in ActorFactory. Returning null.");
            ex.printStackTrace();
            return null;
        }
    }

    private BaseActorComponent getComponent(Element e) {
        String type = e.getAttribute("type");
        BaseActorComponent component = null;

        switch (type) {
            case "TransformComponent":
                component = createTransformComponent(e);
                break;
            case "Character2DRenderComponent":
                component = createCharacter2DRenderComponent(e);
                break;
            default:
                component = new BaseActorComponent();
        }
        return component;
    }

    private BaseActorComponent createTransformComponent(Element e) {
        Element el = null;
        int x = 0;
        int y = 0;
        BaseActorComponent component = null;

        NodeList nl = e.getElementsByTagName("Position");
        if (nl != null && nl.getLength() > 0) {
            el = (Element) nl.item(0);
            x = Integer.parseInt(el.getAttribute("x"));
            y = Integer.parseInt(el.getAttribute("y"));
        }

        component = new TransformComponent(x, y);

        return component;
    }

    private BaseActorComponent createCharacter2DRenderComponent(Element e) {
        Element el = null;
        String imagesLocation = "";
        String animationName = "";
        BufferedImage[] images = new BufferedImage[8];
        BaseActorComponent component = null;
        
        NodeList nl = e.getElementsByTagName("Image");
        if (nl != null && nl.getLength() > 0) {
            el = (Element) nl.item(0);
            imagesLocation = el.getAttribute("imagesZipFile");
            animationName = imagesLocation.substring(17).replace(".zip", "");
        }
        Iterator<String> iter = iu.getImages().keySet().iterator();
        int numOfImgs = 0;
        while(iter.hasNext()) {
            if(iter.next().contains(animationName)) {
                numOfImgs++;
            }
        }
        for(int i = 0; i < numOfImgs; i++) {
            images[i] = iu.getImages().get(animationName + i);
        }
        return component = new Character2DRenderComponent(images);
    }
}
