package project.mbti.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mbti.comment.dto.CommentDto;
import project.mbti.comment.dto.ReplytDto;
import project.mbti.comment.entity.Comment;
import project.mbti.MBTI;
import project.mbti.exception.CommentNameNotMatchException;
import project.mbti.exception.CommentNotFoundException;
import project.mbti.exception.CommentPasswordNotMatchException;
import project.mbti.exception.MbtiNotFoundException;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private String regex = "";

    @PostConstruct
    private void getBadWordsFromTxt() throws IOException {
        final File file = new File("bad_words.txt");
        try {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            String badWord = "";
            while ((badWord = bufferedReader.readLine()) != null) {
                regex += badWord;
                regex += "|";
            }
            regex = regex.substring(0, regex.length() - 1);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String filterText(String sText) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        Matcher m = p.matcher(sText);

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, maskWord(m.group()));
        }
        m.appendTail(sb);

        return sb.toString();
    }

    private String maskWord(String word) {
        StringBuffer buff = new StringBuffer();
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            buff.append("*");
        }
        return buff.toString();
    }

    @Transactional
    public Comment create(MBTI mbti, String name, String password, String content, Long parentId) {
        if (mbti.equals(MBTI.NOT_FOUND))
            throw new MbtiNotFoundException();

        final Comment comment = Comment.builder()
                .mbti(mbti)
                .name(name)
                .password(password)
                .content(filterText(content))
                .parent(commentRepository.findById(parentId))
                .build();

        return commentRepository.save(comment);
    }

    @Transactional
    public void delete(Long id, String name, String password) {
        final Comment findComment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        validateComment(name, password, findComment);

        commentRepository.deleteById(id);
    }

    private void validateComment(String name, String password, Comment findComment) {
        if (!findComment.getName().equals(name))
            throw new CommentNameNotMatchException();
        else if (!findComment.getPassword().equals(password))
            throw new CommentPasswordNotMatchException();
    }

    public Page<CommentDto> getCommentPage(int page, int size) {
        page = (page == 0 ? 0 : page - 1);
        Pageable pageable = PageRequest.of(page, size, Sort.by(DESC, "id"));
        return commentRepository.findCommentDtoPage(pageable);
    }

    public Page<ReplytDto> getReplyPage(Long parentId, int page, int size) {
        page = (page == 0 ? 0 : page - 1);
        Pageable pageable = PageRequest.of(page, size, Sort.by(ASC, "id"));
        return commentRepository.findReplyDtoPage(parentId, pageable);
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}
