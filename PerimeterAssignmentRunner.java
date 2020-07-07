package CalculatingThePerimeterOfAShape;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
        public int getNumPoints (Shape s) {
        // Put code here
        int num=0;
        for (Point point:s.getPoints()){
            num=num+1;
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        Perimeter pr = new Perimeter();
        double total = pr.getPerimeter(s);
        double l = total/getNumPoints(s);
      
        return l;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestSide=0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(currDist > largestSide)
               largestSide=currDist;
            // Update totalPerim by currDist
            //totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }   
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = -1000.0;        
        for(Point currPt : s.getPoints()){
            double currX = currPt.getX();
            if(currX > largestX){
               largestX = currX;
            }
        }
        return largestX;
        
    }
  
    public double getLargestPerimeterMultipleFiles() {
        // Put code here
     
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        Perimeter pr = new Perimeter();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double eachPerim = pr.getPerimeter(s);
            if(eachPerim > largestPerim){
                largestPerim = eachPerim;
            }
        }
        return largestPerim;
        
    }

    public String getFileWithLargestPerimeter() {
        
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File thisFile = null;
        Perimeter pr = new Perimeter();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double eachPerim = pr.getPerimeter(s);
            if(eachPerim > largestPerim){
                largestPerim = eachPerim;
                thisFile = f;
            }
        }
        //File temp = thisFile;    // replace this code
        //return temp.getName();
        return thisFile.getName();
    }

    
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter among shapes = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileWithLargestPerim = getFileWithLargestPerimeter();
        System.out.println("file with largest perimeter = " + fileWithLargestPerim);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Perimeter pr = new Perimeter();
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = pr.getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        Perimeter pr = new Perimeter();
        pr.testPerimeter();
        //testPerimeterMultipleFiles();
    }
}
