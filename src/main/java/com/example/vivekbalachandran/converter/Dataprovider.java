package com.example.vivekbalachandran.converter;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.Switch;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by Vivek Balachandran on 7/5/2015.
 */
public class Dataprovider {
    static HashMap<String,List<String>> dataprovider = new HashMap<String,List<String>>();
    static String[] length= {"milimeter=<-->centimeter",
            "centimeter<-->meter",
            "meter<-->kilometer",
            "miles<--->Kilometer",
            "Foot<-->meter"
    };
    static List<String> Length_Conversion = new ArrayList<String>();

    static String[] weight={
            "Kilograms to Pounds",
            "Pounds to Kilograms",
            "Kilograms to Stones",
            "grains to grams",
            "Grams to Ounces",
           " Ounces to Grams"
    };
    static List<String> weight_conversion= new ArrayList<>( );
    static String[] temperature = {
            "Celsius<-->kelvin",
            "kelvin<-->celsius",
            "celsius<-->fahrenheit"

    };
    static List<String> Temperature_conversion = new ArrayList<String>();
    static String[] Areas ={  "Hectares to Acres",
            "Acres to Hectares",
            "Hectares to Square Feet",
            "Square Feet to Hectares",
            "Square Meters to Square Feet",
            "Square Feet to Square Meters",
            "Square Meters to Square Yards",
            "Square Yards to Square Meters",
            "Square Kilometers to Square Miles",
            "Square Miles to Square Kilometers"

    };
    static List<String> Area_conversions=new ArrayList<String>();
    static String[] Time ={
             "Seconds",
            "Minutes",
            "Hour",
            "Day"

    };
    static List<String> Time_conversion=new ArrayList<String>();
    static String[] speed = {
            "Kilometer per hour to Miles per hour",
            "Miles per Hour to Kilometers per hour",
             "Meters per second",
             "Miles per second",
             "Kilometers per day",
            "Meters per minute",
             "Kilometers per minute",
             "Centimeters per minute",


    };
    static List<String> speed_conversion=new ArrayList<String>();
    static String[] volume={
            "liter to centimeter cube",
            "liter to galen"

    };
    static List<String> volume_conversion=new ArrayList<String>();

    public static HashMap<String,List<String>> getDataprovider( )
    {
        Length_Conversion.add("Milimeter=<-->centimeter");
        Length_Conversion.add("Centimeter<-->meter");
        Length_Conversion.add("Meter<-->kilometer");
        Length_Conversion.add("Miles<--->Kilometer");
        Length_Conversion.add("Foot<-->Meter");
        dataprovider.put("Length_Conversions", Length_Conversion);

        Temperature_conversion.add("Celsius<-->kelvin");
        Temperature_conversion.add("kelvin<-->fahrenheit");
        Temperature_conversion.add("celsius<-->fahrenheit");
        dataprovider.put("Temperature_conversion", Temperature_conversion);

        weight_conversion.add("Kilograms <--> Pounds");
        weight_conversion.add("Grams <--> Ounces");
        weight_conversion.add("Kilograms <--> Stones");
        weight_conversion.add("Grains <--> Grams");
        dataprovider.put("Weight_conversions", weight_conversion);

        Area_conversions.add("Hectares <--> Acres");
        Area_conversions.add("Hectares <--> Square Feet");
        Area_conversions.add("Square Kilometers <--> Square Miles");
        Area_conversions.add("Square Meters <--> Square Feet");
        Area_conversions.add("Square Meters <--> Square Yards");
        dataprovider.put("Area_Conversions", Area_conversions);

        Time_conversion.add("Seconds <--> Minutes");
        Time_conversion.add("Minute <--> hour");
        Time_conversion.add("Hours <--> day");
        Time_conversion.add("day <--> year");
        dataprovider.put("Time_conversions", Time_conversion);

        speed_conversion.add(  "Meters per second <--> Meter per Hour  ");
        speed_conversion.add("Miles per second <--> Miles per hour ");
        speed_conversion.add("Kilometer per hour <--> Miles per hour");
        speed_conversion.add("Meter per Hour <--> Kilometers per hour");
        speed_conversion.add("Meters per second <--> Kilometer per second");
        dataprovider.put("Speed_Conversions", speed_conversion);

        volume_conversion.add( "Liter <--> Centimeter cube");
        dataprovider.put("Volume_Conversions",volume_conversion);

        return dataprovider;
    }


   static int[] sizes={5,3,4,5,4,5,1};
  public static int getsize(int index)
  {
   return sizes[index];
  }
  public static Object getchildname(int grouppos,int childpos)
  {
      String my=new String();
      switch(grouppos)
      {
          case 0:
             my = Length_Conversion.get(childpos);
              break;
          case 1: my =Temperature_conversion.get(childpos);
              break;
          case 2:
              my= weight_conversion.get(childpos);
              break;
          case 3:
              my= Area_conversions.get(childpos);
              break;
          case 4:
              my=Time_conversion.get(childpos);
              break;
          case 5:
              my=speed_conversion.get(childpos);
              break;
          case 6:
               my=volume_conversion.get(childpos);
                 break;


      }
      return  my;
  }
    public static double convert(double init,int g,int c,boolean val)
    {
         double conv=0;
        switch(g)
        {
            case 0: switch(c)
            {
                case 0:if(val)
                        conv = init * 0.1; //mm to centimeter;
                    else conv=init/0.1;

                    break;
                case 1:if(val)
                    conv=init/10;// cm to meter
                    else
                conv=init*10;
                    break;
                case 2:if(val)
                    conv=init/1000;//meter to KM
                    else
                  conv=init*1000;
                    break;
                case 3:if(val)
                    conv=init*1.60934;//miles to km
                    else
                   conv=init/1.60934;
                    break;
                case 4:if(val)conv=init*0.305;
                    else conv=init/0.305;
                    break;
            }
                break;
            case 1:
                switch (c)
                {
                    case 0:if(val)
                        conv=init+273;
                        else conv=init-273;
                        break;
                    case 1:if(val)
                        conv=(init-273)*1.8+32;
                        else conv=((init-32)/1.8)+273;
                        break;
                    case 2:if(val)
                        conv=1.8*init+32;
                        else
                        conv=(init-32)/1.8;
                        break;
                }
                break;
            case 2:
                switch (c)
                {   case 0:
                    if(val) conv=init*2.2046;
                     else   conv=init/2.2046;
                    break;
                    case 1:if(val)conv=init*0.0353;
                        else conv=init/0.03527;
                        break;
                    case 2:if(val)conv=init*0.1575;
                        else conv=init/0.1575;
                        break;
                    case 3:if(val)
                        conv=init*0.0648;
                        else conv=init/0.0648;
                        break;
                }
                break;
            case 3:
                switch (c)
                {
                    case 0:if(val)
                        conv=init*2.4710;
                        else conv=init/2.4710;
                        break;
                    case 1:if(val)
                        conv=init*107639.00;
                      else conv=init/107639.00;
                        break;
                    case 2:if(val)
                        conv=init*00.38610;
                      else conv=init/0.38610;
                        break;
                    case 3:if(val)
                        conv=init*10.7639;
                        else conv=init/10.7639;
                        break;
                    case 4:if(val)
                        conv=init*1.19599;
                    else conv=init/1.19599;
                        break;
                     }
                break;
            case 4 : switch(c)
                {
                case 0:if(val)
                    conv=init/60;
                else conv=init*60;
                    break;
                case 1:if(val)
                    conv=init/60.00;
                else conv=init*60.00;
                    break;
                case 2:if(val)
                    conv=init/24.00;
                else conv=init*24.00;
                    break;
                case 3:if(val)
                    conv=init/365;
                else conv=init*365;
                    break;
               }
              break;
            case 5:switch (c)
            {
                case 0:if(val)
                    conv=init*3600.00;
                else conv=init/3600.00;
                    break;
                case 1:if(val)
                    conv=init*3600;
                else conv=init/3600;
                    break;
                case 2:if(val)
                    conv=init*0.6214;
                else conv=init/0.6214;
                    break;
                case 3:if(val)
                    conv=init*0.001;
                else conv=init*1000;
                    break;
                case 4:if(val)
                    conv=init*0.001;
                else conv=init*1000;
                    break;
            }
                break;
            case 6: switch (c)
            { case 0:
                if(val)
                    conv=init*1000.00;
                else conv=init/1000.00;
                break;
            }

        }
   return conv;
    }

    static String[] len1={"Millimeter","Centimeter","Meter","Miles","Foot"};
    static String[] len2={"Centimeter","Meter","kilometer","Kilometer","meter"};
    static String[] temp1={"Celsius","kelvin","celsius"};
    static String[] temp2={"Kelvin","fahrenheit","fahrenheit"};
    static String[] weigh1={"Kilograms","grams","Kilograms","grains" };
    static String[] weigh2={"pounds","ounce","stones","grams"};
    static String[] area1={"Hectares","Hector","Square Kilometers","Square Meters","Square Meters"};
    static String[] area2={"Acres","Square Feet","Square Miles","Square Feet","Square Yards"};
    static String[] time1={"Seconds","Minute","Hours","Day"};
    static String[] time2={"Minute","Hours","day","year"};
    static String[] speed1={"Meters per second","Miles Per second","Kilometer per hour","Meter per Hour","Meters per second"};
    static String[] speed2={"Meter per hour","Miles per hour","Miles per hour"," Kilometers per hour","Kilometers per second"};
    static String[] vol1={"liter"};
    static String[] vol2={"Cubic centimeter"};

 public static String getstring1(int g,int c)
 {
   String trans=new String();
     switch (g) {
         case 0:
             trans=len1[c];
             break;
         case 1:
             trans=temp1[c];
             break;
         case 2:
             trans=weigh1[c];
             break;
         case 3:
             trans=area1[c];
             break;
         case 4:
             trans=time1[c];
             break;
         case 5:
             trans=speed1[c];
             break;
         case 6:
             trans=vol1[c];
                 
     }

 return trans;
 }

    
    public static String getstring2(int g,int c)
    {
        String trans=new String();
        switch (g) {
            case 0:
                trans=len2[c];
                break;
            case 1:
                trans=temp2[c];
                break;
            case 2:
                trans=weigh2[c];
                break;
            case 3:
                trans=area2[c];
                break;
            case 4:
                trans=time2[c];
                break;
            case 5:
                trans=speed2[c];
                break;
            case 6:
                trans=vol2[c];

        }

        return trans;
    }
}
