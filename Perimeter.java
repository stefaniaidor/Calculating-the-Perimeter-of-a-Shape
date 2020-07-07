package CalculatingThePerimeterOfAShape;


import edu.duke.*;
import java.io.File;

public class Perimeter {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int n = pr.getNumPoints(s);
        System.out.println("The number of points is: " + n );
        
        double avgLength = pr.getAverageLength(s);
        System.out.println("The average side length is " + avgLength );
        
        double largestside = pr.getLargestSide(s);
        System.out.println("The longest side  is " + largestside );
        
        pr.testFileWithLargestPerimeter();
        //pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
      
       // double largestperimeter = getLargestPerimeterMultipleFiles();
       // System.out.println("The largest perimeter multiple files   is " + largestperimeter );
        //printFileNames();
        //testPerimeterMultipleFiles();
        //testFileWithLargestPerimeter();
    }

    
     public static void main (String[] args) {
        Perimeter pr = new Perimeter();
        pr.testPerimeter();
    }

}
