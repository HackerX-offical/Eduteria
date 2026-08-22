package com.tuyenmonkey.mkloader.util;

import com.tuyenmonkey.mkloader.exception.InvalidNumberOfPulseException;
import com.tuyenmonkey.mkloader.type.ClassicSpinner;
import com.tuyenmonkey.mkloader.type.FishSpinner;
import com.tuyenmonkey.mkloader.type.LineSpinner;
import com.tuyenmonkey.mkloader.type.LoaderView;
import com.tuyenmonkey.mkloader.type.PhoneWave;
import com.tuyenmonkey.mkloader.type.Pulse;
import com.tuyenmonkey.mkloader.type.Radar;
import com.tuyenmonkey.mkloader.type.Sharingan;
import com.tuyenmonkey.mkloader.type.TwinFishesSpinner;
import com.tuyenmonkey.mkloader.type.Whirlpool;
import com.tuyenmonkey.mkloader.type.Worm;

/* JADX INFO: loaded from: classes9.dex */
public class LoaderGenerator {
    public static LoaderView generateLoaderView(int i) {
        switch (i) {
            case 0:
                return new ClassicSpinner();
            case 1:
                return new FishSpinner();
            case 2:
                return new LineSpinner();
            case 3:
                try {
                    return new Pulse(3);
                } catch (InvalidNumberOfPulseException e2) {
                    e2.printStackTrace();
                    break;
                }
            case 4:
                try {
                    return new Pulse(4);
                } catch (InvalidNumberOfPulseException e3) {
                    e3.printStackTrace();
                    break;
                }
            case 5:
                try {
                    return new Pulse(5);
                } catch (InvalidNumberOfPulseException e4) {
                    e4.printStackTrace();
                    break;
                }
            case 6:
                return new Radar();
            case 7:
                return new TwinFishesSpinner();
            case 8:
                return new Worm();
            case 9:
                return new Whirlpool();
            case 10:
                return new PhoneWave();
            case 11:
                return new Sharingan();
            default:
                return new ClassicSpinner();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static LoaderView generateLoaderView(String str) {
        str.hashCode();
        switch (str) {
            case "FourPulse":
                try {
                    return new Pulse(4);
                } catch (InvalidNumberOfPulseException e2) {
                    e2.printStackTrace();
                    break;
                }
                break;
            case "FishSpinner":
                return new FishSpinner();
            case "TwinFishesSpinner":
                return new TwinFishesSpinner();
            case "Worm":
                return new Worm();
            case "LineSpinner":
                return new LineSpinner();
            case "Radar":
                return new Radar();
            case "Whirlpool":
                return new Whirlpool();
            case "Sharingan":
                return new Sharingan();
            case "ClassicSpinner":
                return new ClassicSpinner();
            case "ThreePulse":
                try {
                    return new Pulse(3);
                } catch (InvalidNumberOfPulseException e3) {
                    e3.printStackTrace();
                    break;
                }
                break;
            case "FivePulse":
                try {
                    return new Pulse(5);
                } catch (InvalidNumberOfPulseException e4) {
                    e4.printStackTrace();
                    break;
                }
                break;
            case "PhoneWave":
                return new PhoneWave();
            default:
                return new ClassicSpinner();
        }
    }
}
