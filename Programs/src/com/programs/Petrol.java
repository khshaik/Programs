package com.programs;
//Java program to find circular tour for a truck 
  
public class Petrol  
{ 
    // A petrol pump has petrol and distance to next petrol pump 
    static class petrolPump 
    { 
        int petrol; 
        int distance; 
          
        // constructor 
        public petrolPump(int petrol, int distance)  
        { 
            this.petrol = petrol; 
            this.distance = distance; 
        } 
    } 
      
    // The function returns starting point if there is a possible solution, 
    // otherwise returns -1 
    static int printTour(petrolPump arr[], int n) 
    {   
        int start = 0; 
        int end = 1; 
        int curr_petrol = arr[start].petrol - arr[start].distance; 
        System.out.println("Petrol at start:"+arr[start].petrol+" | Distance at start:"+arr[start].distance);
          
        // If current amount of petrol in truck becomes less than 0, then 
        // remove the starting petrol pump from tour 
        while(end != start || curr_petrol < 0) 
        { 
              
            // If current amount of petrol in truck becomes less than 0, then 
            // remove the starting petrol pump from tour 
            while(curr_petrol < 0 && start != end) 
            { 
                // Remove starting petrol pump. Change start 
                curr_petrol -= arr[start].petrol - arr[start].distance; 
                System.out.println("Petrol at subtraction:"+arr[start].petrol+" | Distance at start:"+arr[start].distance);
                System.out.println("Changed value of Petrol at subration:"+curr_petrol);

                start = (start + 1) % n; 
                System.out.println("Changed value of start:"+start);
                  
                // If 0 is being considered as start again, then there is no 
                // possible solution 
                if(start == 0) 
                    return -1; 
            } 
            // Add a petrol pump to current tour 
            curr_petrol += arr[end].petrol - arr[end].distance; 
            System.out.println("Petrol at addition:"+arr[end].petrol+" | Distance at start:"+arr[end].distance);
            System.out.println("Changed value of Petrol at addition:"+curr_petrol);

            end = (end + 1)%n; 
            System.out.println("Changed value of end:"+end);
            System.out.println("--------------------------");
        } 
          
        // Return starting point 
        return start; 
    } 
      
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
          
    	// (6,4) -> (3,6) -> (7,3)
        petrolPump[] arr = {new petrolPump(6, 4), 
                            new petrolPump(3, 6), 
                            new petrolPump(7, 3)}; 
          
        int start = printTour(arr, arr.length); 
          
        System.out.println(start == -1 ? "No Solution" : "Start = " + start);  
  
    } 
    
    /*Petrol at start:6 | Distance at start:4
    Petrol at addition:3 | Distance at start:6
    Changed value of Petrol at addition:-1
    Changed value of end:2
    --------------------------
    Petrol at subtraction:6 | Distance at start:4
    Changed value of Petrol at subration:-3
    Changed value of start:1
    Petrol at subtraction:3 | Distance at start:6
    Changed value of Petrol at subration:0
    Changed value of start:2
    Petrol at addition:7 | Distance at start:3
    Changed value of Petrol at addition:4
    Changed value of end:0
    --------------------------
    Petrol at addition:6 | Distance at start:4
    Changed value of Petrol at addition:6
    Changed value of end:1
    --------------------------
    Petrol at addition:3 | Distance at start:6
    Changed value of Petrol at addition:3
    Changed value of end:2
    --------------------------
    Start = 2*/
} 