package project.mbti.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BadWordsFilter {

    private String regex = "";

    @PostConstruct
    private void getBadWordsFromTxt() throws IOException {
        final File file = new File("bad_words.txt");
        try {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            String badWord = "";
            while ((badWord = bufferedReader.readLine()) != null)
                regex += badWord + "|";
            regex = regex.substring(0, regex.length() - 1);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String filterText(String sText) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        Matcher m = p.matcher(sText);

        StringBuffer sb = new StringBuffer();
        while (m.find())
            m.appendReplacement(sb, maskWord(m.group()));
        m.appendTail(sb);

        return sb.toString();
    }

    private String maskWord(String word) {
        StringBuilder buff = new StringBuilder();
        char[] ch = word.toCharArray();
        buff.append("*".repeat(ch.length));
        return buff.toString();
    }
}
