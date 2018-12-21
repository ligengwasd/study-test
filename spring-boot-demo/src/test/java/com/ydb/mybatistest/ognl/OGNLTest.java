package com.ydb.mybatistest.ognl;

import com.ydb.mybatistest.pojo.Author;
import com.ydb.mybatistest.pojo.Blog;
import com.ydb.mybatistest.pojo.Post;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/12/21
 * @Time 下午7:33
 */
public class OGNLTest {
    @Test
    public void test1() throws OgnlException {
        Author author2 = new Author(2, "usernam2","pwd2","email2");
        context.put("author", author2);

        System.out.println(Ognl.getValue(Ognl.parseExpression("author"), context, context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("author.username"), context, context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("#author.username"), context, context.getRoot()));

    }

    @Before
    public void start() {
        Blog.staticField = "static field";

        Author author = new Author(1, "usernam1", "password1", "email1");

        Post post = new Post();
        post.setContent("PostContent");
        post.setAuthor(author);

        posts = new ArrayList<>();
        posts.add(post);

        blog = new Blog(1, "title", author, posts);

        context = new OgnlContext();
        context.put("blog", blog);
        context.setRoot(blog);
    }

    private static Blog blog;
    private static Author author;
    private static List<Post> posts;
    private static OgnlContext context;

    public static void main(String[] args) {

    }
}
