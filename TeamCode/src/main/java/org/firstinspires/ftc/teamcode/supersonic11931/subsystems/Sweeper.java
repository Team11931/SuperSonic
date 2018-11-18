package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Sweeper {

    private DcMotor sweeperDrive = null;
    //private DcMotor sweeperDrive2 = null;
    private LinearOpMode opMode;


    // Constructor method
    public Sweeper(DcMotor m) {

        sweeperDrive = m;
        //sweeperDrive2 = n;

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
}


    /*public void shutDown()
    {

    }*/
