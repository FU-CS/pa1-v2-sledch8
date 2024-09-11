package pa1_v2;

/**
 * Vector class represents a vector in n-dimensional space with basic operations.
 */
public class Vector {

    // Attributes
    private int n;
    private int[] data;

    /**
     * Constructor to initialize the Vector with the specified number of 
     * dimensions (n) and sets all elements to -1.
     * @param n The number of dimensions of the vector.
     */
    public Vector(int n) {
        this.n = n;
        this.data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = -1;
        }
    }

    /**
     * Get the number of dimensions of the vector.
     * @return The number of dimensions.
     */
    public int getDimension() {
        return this.n;

    }

    /**
     * Get the element at the specified index in the vector.
     * @param index The index of the element.
     * @return The element at the specified index.
     */
    public int read(int index) {
        if (0 <= index & index < this.n){
            return this.data[index];
        }
        return -1;

    }

    /**
     * Set the element at the specified index in the vector to the given value.
     * @param index
     * @param value
     */
    public void update(int index, int value) {
        this.data[index] = value;

    }

    /**
     * Remove the element at the specified index in the vector.
     * @param index The index of the element to remove.
     */
    public void delete(int index) {
        int[] newlist = new int[n - 1];
    
        for (int i = 0, j = 0; i < n; i++) {
            if (i != index) {
                newlist[j++] = this.data[i];
            }
        }
        
        this.data = newlist;
        n--;  
    }

    /**
     * Add the elements of the given vector v to the current vector.
     * The vectors must have the same number of dimensions.
     * @param v The vector to add.
     */
    public void add(Vector v) {
        for(int i = 0; i < this.n; i++){
            this.data[i] += v.data[i];
        }
    }

    /**
     * Subtract the elements of the given vector v from the current vector.
     * @param v
     */
    public void subtract(Vector v) {
        for(int i = 0; i < this.n; i++){
            this.data[i] -= v.data[i];
        }

    }

    /**
     * Get the maximum element in the vector.
     * @return The maximum element.
     */
    public int max() {
        int maximum;
        maximum = this.data[0];
        for (int i = 0; i < n; i++){
            if (this.data[i]> maximum){
                maximum = this.data[i];
            }
        }
        return maximum;
        }


    /**
     * Get the minimum element in the vector.
     * @return The minimum element.
     */
    public int min() {
        int minimum;
        minimum = this.data[0];
        for (int i = 0; i < n; i++){
            if (this.data[i]< minimum){
                minimum = this.data[i];
            }
        }
        return minimum;

    }

    /**
     * Get the average of all elements in the vector.
     * @return The average of all elements.
     */
    public double average() {
        int sum = 0;
        for (int i = 0; i <= data.length; i++){
            sum = sum + data[i];
        }
        return sum/this.n;

        
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int search(int value) {
        for (int i = 0; i < this.n; i++){
            if (value == this.data[i]){
                return i;
            }
        }
        return -1;
        
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * This method is optimized for speed using the Binary Search Algorithm.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int searchFast(int value) {
        int low = 0;
        int high = this.n;
        while (low <= high){
            int mid = (high+low)/2;
            if (this.data[mid] == value){
                return mid;
            } 
            else if (this.data[mid] < value){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;

    }

    /**
     * Sort the elements of the vector in ascending order.
     */
    public void sort() {
        for (int i = 0; i < this.n; i++){
            int lower = this.data[i];
            int j = i - 1;
            while (j >= 0 && this.data[j] > lower) {
                this.data[j + 1] = this.data[j];
                j = j - 1;
            }
            this.data[j + 1] = lower;
        }

    }
    
}
