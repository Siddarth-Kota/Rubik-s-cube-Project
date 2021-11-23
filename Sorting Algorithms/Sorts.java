import org.w3c.dom.stylesheets.LinkStyle;

public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();

        steps = 0;
        for (int outer = 0; outer < list.length - 1; outer++){
            for (int inner = 0; inner < list.length-outer-1; inner++){
                steps += 3;//count one compare and 2 gets
                if (list[inner]>(list[inner + 1])){
                    steps += 4;//count 2 gets and 2 sets
                    int temp = list[inner];
                    list[inner] = list[inner + 1];
                    list[inner + 1] = temp;
                }
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();

        
        for (int i = 0; i < list.length - 1; i++){  
            int index = i;  
            for (int j = i + 1; j < list.length; j++){  
                if (list[j] < list[index]){  
                    index = j;  
                }  
            }  
            int smallerNumber = list[index];   
            list[index] = list[i];  
            list[i] = smallerNumber;  
        }    
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(int [] list){
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();

        int n = list.length;  
        for (int j = 1; j < n; j++) {  
            int key = list[j];  
            int i = j-1;  
            while ((i > -1) && (list[i] > key)) {  
                list[i+1] = list[i];  
                i--;  
            }  
            list[i+1] = key;  
        }  
    }

     /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void mergeSort(int [] list){
        System.out.println();
        System.out.println("Merge Sort");
        System.out.println();

        
    }
    
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}
