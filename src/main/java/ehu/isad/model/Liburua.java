package ehu.isad.model;

public class Liburua {
    private String thumbnail_url;
    private String isbn;
    private String title;
    private String[] authors;
    private String publish_date;

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors[1] = authors;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors[1];

    }

    public String getPublish_date() {
        return publish_date;
    }

    public Liburua() {
    }

}
