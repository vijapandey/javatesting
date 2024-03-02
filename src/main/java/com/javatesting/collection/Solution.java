import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getResponses' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY valid_auth_tokens
     *  2. 2D_STRING_ARRAY requests
     */

    public static List<String> getResponses(List<String> valid_auth_tokens, List<List<String>> requests) {
    List <String> response = new ArrayList<>();
    int start;
                int end;
                 String name;
                    String result ="INVALID";
        for (List<String> lists : requests) {
           
                String httpType = lists.get(0);
                String value = lists.get(1);
                System.out.println("httpTpe :" + httpType +", Value : " + value);
                
                switch(httpType){
                case "GET" :
                     start =  value.indexOf("token=");
                     end =value.indexOf("&name");
                     result ="INVALID";
                    String token = value.substring(start, end);
                    System.out.println("GET Token :" +token);    
                     if(valid_auth_tokens.contains(token)){
                          start =  value.indexOf("&name=");
                           name = value.substring(start);
                           result ="VALID,name,"+name;
                           System.out.println("Valid GET result :" +result); 
                     }
                     response.add(result);
                     break;               
                case "POST":
                    int startd =  value.indexOf("token=");
                     end =value.indexOf("&");
                   
                     token = value.substring(startd, end);
                    System.out.println("POST Token :" +token);    
                     if(valid_auth_tokens.contains(token)){
                         if(value.indexOf("&csrf") > -1){
                         String csrf = value.substring(value.indexOf("&csrf=") , value.indexOf("&name"));
                          if(!csrf.isEmpty() && csrf.length()>=9){
                           name = value.substring(value.indexOf("&name="));
                           result ="VALID,name,"+name;
                           System.out.println("Valid POST result :" +result); 
                          }
                         }
                     }
                     response.add(result);
                     break; 
                
                default: break;
                
                                    
                }
                
            
        }
        return response;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valid_auth_tokensCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> valid_auth_tokens = IntStream.range(0, valid_auth_tokensCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int requestsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int requestsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> requests = new ArrayList<>();

        IntStream.range(0, requestsRows).forEach(i -> {
            try {
                requests.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> result = Result.getResponses(valid_auth_tokens, requests);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getResponses' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY valid_auth_tokens
     *  2. 2D_STRING_ARRAY requests
     */

    public static List<String> getResponses(List<String> valid_auth_tokens, List<List<String>> requests) {
    List <String> response = new ArrayList<>();
    int start;
                int end;
                 String name;
                    String result ="INVALID";
        for (List<String> lists : requests) {
           
                String httpType = lists.get(0);
                String value = lists.get(1);
                System.out.println("httpTpe :" + httpType +", Value : " + value);
                
                switch(httpType){
                case "GET" :
                     start =  value.indexOf("token=");
                     end =value.indexOf("&name");
                     result ="INVALID";
                    String token = value.substring(start, end);
                    System.out.println("GET Token :" +token);    
                     if(valid_auth_tokens.contains(token)){
                          start =  value.indexOf("&name=");
                           name = value.substring(start);
                           result ="VALID,name,"+name;
                           System.out.println("Valid GET result :" +result); 
                     }
                     response.add(result);
                     break;               
                case "POST":
                    int startd =  value.indexOf("token=");
                     end =value.indexOf("&");
                   
                     token = value.substring(startd, end);
                    System.out.println("POST Token :" +token);    
                     if(valid_auth_tokens.contains(token)){
                         if(value.indexOf("&csrf") > -1){
                         String csrf = value.substring(value.indexOf("&csrf=") , value.indexOf("&name"));
                          if(!csrf.isEmpty() && csrf.length()>=9){
                           name = value.substring(value.indexOf("&name="));
                           result ="VALID,name,"+name;
                           System.out.println("Valid POST result :" +result); 
                          }
                         }
                     }
                     response.add(result);
                     break; 
                
                default: break;
                
                                    
                }
                
            
        }
        return response;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valid_auth_tokensCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> valid_auth_tokens = IntStream.range(0, valid_auth_tokensCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int requestsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int requestsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> requests = new ArrayList<>();

        IntStream.range(0, requestsRows).forEach(i -> {
            try {
                requests.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> result = Result.getResponses(valid_auth_tokens, requests);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
