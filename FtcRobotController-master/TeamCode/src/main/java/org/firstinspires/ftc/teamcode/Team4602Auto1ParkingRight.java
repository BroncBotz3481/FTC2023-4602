package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Team4602Auto1ParkingRight", group="4602")

public class Team4602Auto1ParkingRight extends LinearOpMode
{
    Team4602HWMap2023 robot = new Team4602HWMap2023();
    ElapsedTime Time = new ElapsedTime();

    double multy = 0.3; // Multiply how much the wheels turn
    double groundFriction = 0.2; // To be used
    int OPG = 0; // 1 = Orange, 2 = Green, 3 = Purple | These are values for colours of the cone
    float[] hsvValues = new float[3];
    int count = 0;

    @Override
    public void runOpMode()
    {
        robot.Map(hardwareMap);

        if (robot.ColorSensor instanceof SwitchableLight)
        {
            ((SwitchableLight) robot.ColorSensor).enableLight(true);
        }

        waitForStart();

        //Cone Scoring
        //Turn Left and Elevator up
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(multy);
            robot.ElevatorMotor.setPower(1);
        }

        //Forwards
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftFront.setPower(multy);
            robot.DriveRightBack.setPower(multy);
            robot.DriveLeftBack.setPower(multy);
        }

        //Strafe Right
        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 800) {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(multy);
        }

        sleep(1500);

        //Release
        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 1000) {
            robot.leftGripper.setPosition(0.1);
            robot.rightGripper.setPosition(0.5);
        }

        //Strafe Right
        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 800) {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(multy);
        }

        //Turn Right and Elevator Down
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftBack.setPower(-multy);
            robot.ElevatorMotor.setPower(-1);
        }

        //Forwards
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftFront.setPower(multy);
            robot.DriveRightBack.setPower(multy);
            robot.DriveLeftBack.setPower(multy);
        }

        //Grab
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.leftGripper.setPosition(0.1);
            robot.rightGripper.setPosition(0.5);
        }

        //Back
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveRightFront.setPower(-multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(-multy);
        }

        //Turn Right and Elevator Up
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftBack.setPower(-multy);
            robot.ElevatorMotor.setPower(1);
        }

        sleep(500);

        //Release
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000) {
            robot.leftGripper.setPosition(0.4);
            robot.rightGripper.setPosition(0.1);
        }

        //Number of cones scored
        for (int numCones = 0; numCones < 3; numCones++)
        {
            //Turn left and elevator down
            Time.reset();
            while(opModeIsActive() && Time.milliseconds() < 2000) {
                robot.DriveLeftFront.setPower(-multy);
                robot.DriveRightBack.setPower(multy);
                robot.ElevatorMotor.setPower(1);
            }

            //Forwards
            Time.reset();
            while(opModeIsActive() && Time.milliseconds() < 2000) {
                robot.DriveRightFront.setPower(multy);
                robot.DriveLeftFront.setPower(multy);
                robot.DriveRightBack.setPower(multy);
                robot.DriveLeftBack.setPower(multy);
            }

            //Back
            Time.reset();
            while(opModeIsActive() && Time.milliseconds() < 2000) {
                robot.DriveRightFront.setPower(-multy);
                robot.DriveLeftFront.setPower(-multy);
                robot.DriveRightBack.setPower(-multy);
                robot.DriveLeftBack.setPower(-multy);
            }

            //Turn Right and elevator up
            Time.reset();
            while(opModeIsActive() && Time.milliseconds() < 2000) {
                robot.DriveRightFront.setPower(multy);
                robot.DriveLeftBack.setPower(-multy);
                robot.ElevatorMotor.setPower(1);
            }

            sleep(500);

            //Release
            Time.reset();
            while(opModeIsActive() && Time.milliseconds() < 2000) {
                robot.leftGripper.setPosition(0.4);
                robot.rightGripper.setPosition(0.1);
            }
        }

        //Back to Original Position
        //Strafe Left and Elevator Down
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000) {
            robot.DriveRightFront.setPower(-multy);
            robot.DriveLeftFront.setPower(multy);
            robot.DriveRightBack.setPower(multy);
            robot.DriveLeftBack.setPower(-multy);

            robot.ElevatorMotor.setPower(-1);
        }

        //Forwards
        Time.reset();
        while(opModeIsActive() && Time.milliseconds() < 2000) {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftFront.setPower(multy);
            robot.DriveRightBack.setPower(multy);
            robot.DriveLeftBack.setPower(multy);
        }

        //Turn Left
        while(opModeIsActive() && Time.milliseconds() < 2000) {
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(multy);
        }

        //Strafe Right
        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 800) {
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(multy);
        }

        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveRightFront.setPower(-multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(-multy);
        }

        //Turn Right
        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 2000)
        {
            robot.DriveLeftFront.setPower(multy);
            robot.DriveRightBack.setPower(-multy);
        }

        //Color Scoring
        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 1200)
        {
            robot.DriveRightFront.setPower(-multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(-multy);
        }
        sleep(500);

        Time.reset();
        while (opModeIsActive() && count < 5)
        {
            if (robot.ColorSensor instanceof SwitchableLight)
            {
                SwitchableLight light = (SwitchableLight) robot.ColorSensor;
                light.enableLight(!light.isLightOn());
            }
            NormalizedRGBA colors = robot.ColorSensor.getNormalizedColors();
            Color.colorToHSV(colors.toColor(), hsvValues);

            telemetry.addLine()
                    .addData("H", "%.3f", hsvValues[0])
                    .addData("S", "%.3f", hsvValues[1])
                    .addData("V", "%.3f", hsvValues[2]);
            telemetry.addLine()
                    .addData("a", "%.3f", colors.alpha)
                    .addData("r", "%.3f", colors.red)
                    .addData("g", "%.3f", colors.green)
                    .addData("b", "%.3f", colors.blue);
            telemetry.update();
            /** We also display a conversion of the colors to an equivalent Android color integer.
             * @see Color */
            int color = colors.toColor();

            float max = Math.max(Math.max(Math.max(colors.red, colors.green), colors.blue), colors.alpha);
            colors.red /= max;
            colors.green /= max;
            colors.blue /= max;
            color = colors.toColor();
            count++;
        }

        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 300)
        {
            int Hvalue = (int) hsvValues[0];
            if (Hvalue >= 0 && Hvalue <= 135) OPG = 1;
            else if (Hvalue > 135 && Hvalue <= 152) OPG = 2;
            else OPG = 3;
        }

        Time.reset();
        while (opModeIsActive() && Time.milliseconds() < 700)
        {
            robot.DriveRightFront.setPower(-multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(-multy);
        }
        sleep(1500);

        if (OPG == 1)
        {
            Time.reset();
            while (opModeIsActive() && Time.milliseconds() < 2300)
            {
                robot.DriveRightFront.setPower(-multy);
                robot.DriveLeftFront.setPower(multy);
                robot.DriveRightBack.setPower(multy);
                robot.DriveLeftBack.setPower(-multy);
            }
            sleep(1000);
        }
        else if (OPG == 3)
        {
            Time.reset();
            while (opModeIsActive() && Time.milliseconds() < 2100)
            {
                robot.DriveRightFront.setPower(multy);
                robot.DriveLeftFront.setPower(-multy);
                robot.DriveRightBack.setPower(-multy);
                robot.DriveLeftBack.setPower(multy);
            }
            sleep(500);
        }
        sleep(100);
    }
}