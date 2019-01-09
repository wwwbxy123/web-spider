package spider;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        String url = printHTML.getURL();

        String result = printHTML.getHTMLContent(url);

        String htmlRemoveTag = FilterHtmlUtil.Html2Text(result);

        System.out.println("***************************************************************************************************");
        System.out.println("content of this website: " + url + " is: ");
        System.out.println("***************************************************************************************************");
        System.out.println(htmlRemoveTag.trim());
        System.out.println("===================================================================================================");

        WordCount.wordCount(htmlRemoveTag);
    }
}
