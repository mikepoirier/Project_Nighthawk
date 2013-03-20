/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

/**
 *
 * @author Mike
 */
public class TransformComponent extends BaseActorComponent implements IComponent
{

    int x;
    int y;
    String type = "TransformComponent";

    public TransformComponent(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getType()
    {
        return type;
    }

    @Override
    public synchronized int getX()
    {
        return x;
    }

    @Override
    public synchronized void setX(int x)
    {
        this.x = x;
    }

    @Override
    public synchronized int getY()
    {
        return y;
    }

    @Override
    public synchronized void setY(int y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Position: (" + x + ", " + y + ")";
    }
}
