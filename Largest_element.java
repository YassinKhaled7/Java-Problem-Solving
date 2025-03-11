class Largest_element
{
    static int arr[] = {20, 10, 20, 4, 100}; 
    static int largest() {
        int max = arr[0]; 
        for (int i = 1; i < arr.length; i++) 
            if (arr[i] > max) 
                max = arr[i]; 
        
        return max; 
    } 
    public static void main(String[] args) {
        System.out.println(largest()); 
    } 
} 
