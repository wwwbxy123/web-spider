package spider;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.URL;
        import java.net.URLConnection;

        import java.io.PrintWriter;
        import java.io.File;
        import java.io.*;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.TreeMap;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // 定义即将访问的链接
        String url = "https://www.cnn.com/2013/06/10/politics/edward-snowden-profile/";
        //String url = "https://www.rei.com/blog/camp/how-to-introduce-your-indoorsy-friend-to-the-outdoors";
        //String url = "https://www.amazon.com/Cuisinart-CPT-122-Compact-2-SliceToaster/dp/B009GQ034C/ref=sr_1_1?s=kitchen&ie=UTF8&qid=1431620315&sr=1-1&keywords=toaster";


        // 定义一个字符串用来存储网页内容
        String result = "";
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try
        {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null)
            {
                // 遍历抓取到的每一行并将其存储到result里面
                result += line + "\n";
            }

        } catch (Exception e)
        {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } // 使用finally来关闭输入流
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

        /*
        File file = new File ("/Users/xinyi.babs/github/web spider/content/content.txt");
        PrintWriter printWriter = new PrintWriter ("content.txt");
        printWriter.println (result);
        printWriter.close ();
        */

        //System.setOut(new PrintWriter("/Users/xinyi.babs/github/web spider/content/content.txt"));
        System.out.println(FilterHtmlUtil.Html2Text(result));

        BufferedReader br = new BufferedReader(new FileReader("/Users/xinyi.babs/github/web spider/content/2totext.txt"));
        List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表
        String readLine = null;
        while((readLine = br.readLine()) != null){
            String[] wordsArr1 = readLine.split("[^a-zA-Z]");  //过滤出只含有字母的
            for (String word : wordsArr1) {
                if(word.length() != 0){  //去除长度为0的行
                    lists.add(word);
                }
            }
        }

        br.close();

        Map<String, Integer> wordsCount = new TreeMap<String, Integer>();  //存储单词计数信息，key值为单词，value为单词数

        //单词的词频统计
        for (String li : lists) {
            if(wordsCount.get(li) != null){
                wordsCount.put(li,wordsCount.get(li) + 1);
            }else{
                wordsCount.put(li,1);
            }

        }

        WordCount.SortMap(wordsCount);    //按值进行排序
    }
}
