class Test {  

    public static void main(String[] args){
        int n = 0;
        for (int i = 0; i < 5; i++)
            for (int k = i ; k < 5-i; k++)
            {
                n++;
                System.out.println(n + ": i is " + i + " and k is " + k);
            }  
    }
}