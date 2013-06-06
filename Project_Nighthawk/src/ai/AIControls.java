/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.*;
import utilities.MersenneTwisterFast;

/**
 *
 * @author Cody
 */

public class AIControls{
    Point pPos;
    Point pTarget;
    
    int x, y, iTime, iIndex, iTheta;
    int iLogic;
    int iState;
    int iTimeState;

    AIControls() {
        pPos = new Point(150, 90);
        pTarget = new Point(0, 0);
        iLogic=2;
        iState=0;
    }
    
    public void setTarget(int x, int y)
    {
        pTarget.move(x, y);
    }

    public void setLogic(int log)
    {
        iLogic = log;
    }
    
    public void move()
    {
        // Call the selected method
        switch ( iLogic )
        {
        case 1:
            logicChase();
            break;
        case 2:
            logicRetreat();
            break;
        case 3:
            logicPattern();
            break;
        case 4:
            logicCircle();
            break;
        case 5:
            logicRandom();
            break;
        }

        pPos.translate(x, y);

        //Checks Boundaries of the map
        if (pPos.x < 97) pPos.x = 97;
        if (pPos.x > 272) pPos.x = 272;

        if (pPos.y < 12) pPos.y = 12;
        if (pPos.y > 127) pPos.y = 127;

    }
    
     private void logicChase()
    {

        int xdif = Math.abs(pPos.x - pTarget.x);
        int ydif = Math.abs(pPos.y - pTarget.y);

        if ( xdif > ydif ) {
            x = 2;
            y = 1;
        }

        if ( ydif > xdif ) {
            y = 2;
            x = 1;
        }

        if ( xdif == 0 ) {
            y = 3;
            x = 0;
        }

        if ( ydif == 0 ) {
            x = 3;
            y = 0;
        }

        if ( xdif == ydif ) {
            x = 1;
            y = 1;
        }

        if ( pPos.x > pTarget.x )
            x*= -1;
        if ( pPos.y > pTarget.y )
            y*=-1;
    }
     
    private void logicRetreat()
    {
        logicChase();

        x*=-1;
        y*=-1;
    }
    
    private void logicPattern()
    {
        int iPattern[] = {  3, 0, 4,
                            -1, -2, 4,
                            -2, -1, 4,
                            -3, 0, 4,
                            0, 3, 12,
                            -2, -1, 4,
                            -1, -2, 4,
                            0, -3, 4,
                            3, 0, 8 };
        int iPatSize = 9;

        if ( iTime == 0 ) {

            x = iPattern[ 3 * iIndex ];
            y = iPattern[ 3 * iIndex + 1];
            iTime = iPattern[ 3 * iIndex + 2];

            iIndex++;

            iIndex %= iPatSize;
        }

        iTime--;

    }
    
    private void logicCircle()
    {
        Point pTemp = new Point( pTarget.x, pTarget.y );

        pTarget.x = pTarget.x + (int) Math.round(100 * Math.cos(iTheta * Math.PI / 180));
		pTarget.y = pTarget.y + (int) Math.round(-100 * Math.sin(iTheta * Math.PI / 180));

		logicChase();

		iTheta-=3;
		iTheta+=360;
		iTheta%=360;

		pTarget.move( pTemp.x, pTemp.y );
    }
    
    private void logicRandom()
    {
        MersenneTwisterFast rand = new MersenneTwisterFast();
        if (iTime == 0) {

            x = (int) ( rand.nextInt() * 4 );
            y = 3 - x;

            if ( rand.nextInt() * 100 < 50 )
                x*= -1;
            if ( rand.nextInt() * 100 < 50 )
                y*= -1;

            iTime = (int) ( rand.nextInt() * 10 + 1);
        }

        iTime--;
    }
    
    private void logicPerimeter()
    {
        int iPattern[] = {1, 1, 
                          2, 2, 
                          3, 3, 
                          4, 4};
        
        int iPatSize = 4;
        
        if ( iTime == 0 ) {

            x = iPattern[ 2 * iIndex ];
            y = iPattern[ 2 * iIndex + 1];
            iTime = iPattern[ 2 * iIndex + 2];

            iIndex++;

            iIndex %= iPatSize;
        }

        iTime--;
    }
}