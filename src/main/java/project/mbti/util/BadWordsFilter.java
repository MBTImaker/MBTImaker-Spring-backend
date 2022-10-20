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
            final StringBuilder builder = new StringBuilder();
            while ((badWord = bufferedReader.readLine()) != null)
                builder.append(badWord).append("|");
            builder.deleteCharAt(builder.length() - 1);
            regex = builder.toString();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String filterText(String sText) {
        final Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        final Matcher m = p.matcher(sText);

        final StringBuilder builder = new StringBuilder();
        while (m.find())
            m.appendReplacement(builder, maskWord(m.group()));
        m.appendTail(builder);

        return builder.toString();
    }

    private String maskWord(String word) {
        final StringBuilder builder = new StringBuilder();
        final char[] ch = word.toCharArray();
        builder.append("*".repeat(ch.length));
        return builder.toString();
    }
}
