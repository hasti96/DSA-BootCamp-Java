package recursion.freecodecamp.dynamicprogramming;

public class twilio {
    
    public static void main(String[] argv) {
        Integer a = 315;
        Integer b = 840;

        while(b > 0) {
            a %= b;
            
            Integer temp = a;
            a = b;
            b= temp;
        }

        System.out.println(func(3, 5));

    }

    public static int func(int a, int b) {
        if(b == 0) {
            return 1;
        }

        int temp = func(a, b/2);

        if(b%2 != 0) {
            return temp * temp * a;
        } else {
            return temp*temp;
        }

        // SELECT student.NAME from student INNER JOIN backlog ON student.ID = backlog.STUDENT_ID ORDER BY NAME ASC ; 


        // RestTemplate restTemplate = new RestTemplate(); 
       
    //    String url = "https://jsonmock.hackerrank.com/api/articles?author=author";
       
    //    ResponseEntity<String> responseEntity = restTemplate.getForEntity
    }
}
