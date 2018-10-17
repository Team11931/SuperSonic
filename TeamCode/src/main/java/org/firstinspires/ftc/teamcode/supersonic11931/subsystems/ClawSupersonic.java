package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.Servo;


public class ClawSupersonic {

    private Servo clawDrive = null;


    // Constructor method
    public ClawSupersonic(Servo c){

        clawDrive = c;

    }


    public void runClaw(boolean button1, boolean button2)
    {

        if (button1)
        {
            // clawDrive.setPower(FORWARD);
        }
        else if (button2)
        {
            // clawDrive.setPower(REVERSE);
        }
        else
        {
            // clawDrive.setPower(STOP);
        }
    }


    public void shutDown()
    {
        //clawDrive.
    }

}
