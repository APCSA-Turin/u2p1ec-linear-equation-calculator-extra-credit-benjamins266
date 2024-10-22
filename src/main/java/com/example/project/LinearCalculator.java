package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean isUndefined;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
        //Finding x1 and y1 of first point1
        int comma1 = point1.indexOf(",");
        int point1Length = point1.length();
        String firstCoord1 = point1.substring(1,comma1);
        String secondCoord1 = point1.substring(comma1+1, point1Length-1);

        //Finding x2 and y2 of second point2
        int comma2 = point2.indexOf(",");
        int point2Length = point2.length();
        String firstCoord2 = point2.substring(1,comma2);
        String secondCoord2 = point2.substring(comma2+1,point2Length-1);

        //Parsing the 4 Strings into integers
        x1 = Integer.parseInt(firstCoord1);
        x2 = Integer.parseInt(firstCoord2);
        y1 = Integer.parseInt(secondCoord1);
        y2 = Integer.parseInt(secondCoord2);

        isUndefined = false;
        if((x2-x1) == 0){
            isUndefined = true;
        }


    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){
        x1 = newX1;
    }
    public void setY1(int newY1){
        y1 = newY1;
    }
    public void setX2(int newX2){
        x2 = newX2;
    }
    public void setY2(int newY2){
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distanceFormula = Math.sqrt(Math.pow((y2-y1),2) + Math.pow((x2-x1),2)); //FIX NEGATIVES
        distanceFormula = roundedToHundredth(distanceFormula); //USE METHOD AT BOTTOM
        return distanceFormula;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if(isUndefined==true){
            return -999.99;
        }
        double yIntercept = roundedToHundredth(y1 - (slope()*x1));
        return yIntercept;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double slope1; 
        if (isUndefined == true) {
            return -999.99;    
        } else {
            slope1 = roundedToHundredth((double) (y2-y1) / (x2-x1)); 
        }
         return slope1;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        String equation1 = "";
        if (isUndefined == true){
            equation1 = "undefined";
        } else {
            if(yInt()==0){
                equation1 += "y=" + slope() + "x";
            } else if(yInt()<0){
                equation1 += "y=" + slope() + "x" + yInt();
            } else if (slope() ==0){
                equation1 += "y=" + yInt();
            } else{
                equation1 += "y=" + slope() + "x" + "+" + yInt();
            }
        
        }
        return equation1;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double round = Math.round(x*100.00) /100.00;
        return round;
    }


    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation() ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
        //ADD
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){

        if(x2==x1){
            return "Symmetric about the x-axis";
        } else if(y2==y1){
            return "Symmetric about the y-axis";
        } else if((x2==-x1) && (y2==-y1)){
            return "Symmetric about the origin";
        } else{
            return "No symmetry";
        }
        
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double midpointX = (x1+x2)/2;
        double midpointY = (y1+y2)/2;
        return "The midpoint of this line is: (" + midpointX + "," + midpointY + ")";
    }

}



