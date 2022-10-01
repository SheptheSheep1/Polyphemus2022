// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //drive ports
        public static final int dtFrontLeftPort = 7;
        public static final int dtBackLeftPort = 8;
        public static final int dtFrontRightPort = 1;
        public static final int dtBackRightPort = 2;
    //power outputs
        public static final int kDriveSpeed = 7;
        public static final int kTurnSpeed = 7;
        //curvature drive
        public static final int cDriveSpeed = 7;
        public static final int cTurnSpeed = 7;
}
