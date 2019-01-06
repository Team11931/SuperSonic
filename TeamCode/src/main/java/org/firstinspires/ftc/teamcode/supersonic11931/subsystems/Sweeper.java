package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Sweeper {

    private DcMotor sweeperDrive = null;
    private Servo sweeperRelease = null;
    private LinearOpMode opMode;


    // Constructor method
    public Sweeper(DcMotor m, Servo n) {

        sweeperDrive = m;
        sweeperRelease = n;

    }


    public void runSweeper(boolean r, boolean l) {

        if (r)
        {
            sweeperDrive.setPower(1.0f);
        }
        else if (l)
        {
            sweeperDrive.setPower(-1.0f);
        }
        else
        {
            sweeperDrive.setPower(0.0f);
        }



    }

    public void runRelease(boolean O, boolean C){
        if (O){
            sweeperRelease.setPosition(0.2);
        }
        else if (C){
            sweeperRelease.setPosition(0);
        }
    }
}


    /*public void shutDown()
    {

    }*/
