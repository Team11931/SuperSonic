package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class SweeperSupersonic {

    private DcMotor sweeperDrive = null;
    private LinearOpMode opMode;
    final double FORWARD = 1;
    final double REVERSE = -1;
    final double STOP = -1;


    // Constructor method
    public SweeperSupersonic(DcMotor m){

        sweeperDrive = m;

    }


    public void runSweeper(boolean button1, boolean button2)
    {
        boolean forward  = button1;
        boolean reverse  = button2;

        if (forward)
        {
            sweeperDrive.setPower(FORWARD);
        }
        else if (reverse)
        {
            sweeperDrive.setPower(REVERSE);
        }
        else
        {
            sweeperDrive.setPower(STOP);
        }
    }


    public void shutDown()
    {
        // stop the motor
        sweeperDrive.setPower(STOP);
    }


}
