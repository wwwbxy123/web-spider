package spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/** iuput the url we want to analysis using scanner*/
/** request use BufferedReader to read every line of the webpage*/


public class printHTML {

    /** iuput the url we want to analysis using scanner*/
    public static String getURL(){

        // input url we want to analysis
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the URL you want to analysis (end with several blank and a enter to execute the program)");
        String url = scanner.nextLine();

        //sample url for test
        //String url = "https://www.cnn.com/2013/06/10/politics/edward-snowden-profile/";
        //String url = "https://www.rei.com/blog/camp/how-to-introduce-your-indoorsy-friend-to-the-outdoors";
        //String url = "https://www.amazon.com/Cuisinart-CPT-122-Compact-2-SliceToaster/dp/B009GQ034C/ref=sr_1_1?s=kitchen&ie=UTF8&qid=1431620315&sr=1-1&keywords=toaster";
        return url;

    }

    /** request use BufferedReader to read every line of the webpage: input the url string, return the content string*/
    public static String getHTMLContent(String url){
        // define a string content to store the content of that webpage

        String content = "";
        // define a BufferedReader to read content from webpage
        BufferedReader in = null;
        try
        {
            // convert string to URL object
            URL realUrl = new URL(url);

            // initialize a URL Connection
            URLConnection connection = realUrl.openConnection();

            // connect webpage
            connection.connect();

            // initialize BufferedReader to read url response
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // store content line by line
            String line;
            while ((line = in.readLine()) != null)
            {
                // traverse everyline ans store them into content
                content += line + "\n";
            }

        } catch (Exception e)
        {
            System.out.println("get error" + e);
            e.printStackTrace();
        }
        // use finally to close the BufferedReader
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            } catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        return content;
    }

}
