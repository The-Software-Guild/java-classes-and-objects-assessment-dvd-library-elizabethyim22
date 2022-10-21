package com.sal.dvdlibrary.ui;
import java.util.*;

/**
 *
 * @author Elizabeth Yim
 *
 * */
public class UserIOConsoleImpl implements UserIO{
    final private Scanner input = new Scanner(System.in);
    @Override
    public void print(String msg){
        System.out.println(msg);
    }
    @Override
    public double readDouble(String prompt){
        while(true){
            try {
                return Double.parseDouble(this.readString(prompt));
            } catch (NumberFormatException e){
                this.print("Input error. Please try again. ");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double inputDouble;
        do {
            inputDouble = readDouble(prompt);
        } while (inputDouble < min || inputDouble > max);
        return inputDouble;
    }

    @Override
    public float readFloat(String prompt){
        while(true){
            try {
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e){
                this.print("Input error. Please try again. ");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max){
        float inputFloat;
        do{
            inputFloat=readFloat(prompt);
        } while (inputFloat<min || inputFloat>max);
        return inputFloat;
    }

    @Override
    public int readInt(String prompt) {
        while(true){
            try {
                return Integer.parseInt(this.readString(prompt));
            } catch (NumberFormatException e){
                this.print("Input error. Please try again. ");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max){
        int inputInt;
        do{
            inputInt=readInt(prompt);
        } while (inputInt<min || inputInt>max);
        return inputInt;
    }

    @Override
    public long readLong(String prompt){
        while(true){
            try{
                return Long.parseLong(this.readString(prompt));
            } catch(NumberFormatException e){
                this.print("Input error. Please try again. ");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max){
        long inputLong;
        do {
            inputLong=readLong(prompt);
        } while (inputLong<min || inputLong>max);
        return inputLong;
    }

    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        return input.nextLine();
    }
}
