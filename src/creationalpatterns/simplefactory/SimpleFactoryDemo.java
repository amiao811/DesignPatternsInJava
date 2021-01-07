package creationalpatterns.simplefactory;

/**
 * Abstract post class. Represents a generic post on a web site.
 */
abstract class Post {
    private Long id;
    private String title;
    private String content;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}

/**
 * Represents a blog post.
 */
class BlogPost extends Post {
    public BlogPost() {
        System.out.println("BlogPost created!");
    }
}

/**
 * Represents a news post.
 */
class NewsPost extends Post {
    public NewsPost() {
        System.out.println("NewsPost created!");
    }
}

/**
 * This class acts as a simple factory for creation of
 * different posts on web site.
 */
class PostFactory {
    public static Post createPost(String type) {
        switch (type){
           case "news":
               return new NewsPost();
            case "blog":
                return new BlogPost();
            default:
                throw new IllegalArgumentException("Post type is unknown");
        }
    }
}

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        PostFactory.createPost("blog");
    }
}
