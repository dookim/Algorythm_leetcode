
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
    	int[] result = new int[nums.length];
    	int leftProduct = 1;
    	for(int i = 0; i < nums.length; ++i) {
    		result[i] = leftProduct;
    		leftProduct *= nums[i];
    	}
    	int rightProduct = 1;
    	for(int i = nums.length - 1; i > -1; --i) {
    		result[i] *= rightProduct;
    		rightProduct *= nums[i];
    	}
    	return result;
    }
    
    private void print(int[] arr) {
    	for(int i = 0; i < arr.length; ++i) {
    		System.out.print(arr[i] + " ");
    	}
    }
    
    public static void main(String[] args) {
		ProductExceptSelf pes = new ProductExceptSelf();
		int[] arr= {1,2,3,4};
		pes.print(pes.productExceptSelf(arr));
	}
}
