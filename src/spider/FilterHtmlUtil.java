package spider;
import java.util.regex.Pattern;

/** remove HTML, Style, Script tags using regular expression */
/** define script regular expression as {<script[^>]*?>[\\s\\S]*?<\\/script> } */
/** define style regular expression as {<style[^>]*?>[\\s\\S]*?<\\/style> } */
/**  define html regular expression as {<[^>]+>} */

public class FilterHtmlUtil {
    public static String Html2Text(String inputString){
        String htmlStr = inputString; //input String with HTML tags
        String textStr ="";

        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        try{

            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //define script regular expression{<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //define regular expression {<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; //define html regular expression

            p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);

            //remove script tags
            htmlStr = m_script.replaceAll("");
            p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);

            //remove style tags
            htmlStr = m_style.replaceAll("");
            p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);

            //remove html tags
            htmlStr = m_html.replaceAll("");
            textStr = htmlStr;

        }catch(Exception e){
            e.printStackTrace();
        }

        //return HTML content without tags
        return textStr;
    }
}




