package com.ydb.mybatistest.ognl;

import com.ydb.mybatistest.pojo.Author;
import com.ydb.mybatistest.pojo.Blog;
import com.ydb.mybatistest.pojo.Post;
import org.apache.ibatis.ognl.OgnlContext;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/12/21
 * @Time 下午7:33
 */
public class OGNLTest {
    @Before
    public void start() {
        Blog.staticField = "static field";

        Post post = new Post();
        post.setContent("PostContent");
        post.setAuthor(new Author(1,"usernam1","password1","email1"));

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
