
/**
 * Represents a <strong>book</strong> by
 * <ul>
 * <li>title</li>
 * <li>author</li>
 * <li>publisher</li>
 * <li>date published</li>
 * <li>edtion</li>
 * </ul>
 * @author Gruppe 26
 * @version 2019-02-06
 */
public class Book
{
    private String title;
    private String author;
    private String publisher;
    private String published;
    private int edition;
    
    /**
     * Constructor of class Book
     * @param title set the title of the book
     * @param author set the author of the book
     * @param publisher set the publisher of the book
     * @param published set the publishing date of the book
     * @param edition set the book editions number
     */
    public Book(String title, String author, String publisher, 
    String published, int edition)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.published = published;
        validateEdition(edition);
    }
    
    /**
     * Small constructor for testing purpose.
     * @param title title of the book
     */
    public Book(String title)
    {
        this.title = title;
    }
    
    /**
     * @return title Returns title of the book
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * @return author Returns author of the book
     */
    public String getAuthor()
    {
        return this.author;
    }
    
    /**
     * @return published Returns publisher of the book
     */
    public String getPublisher()
    {
        return this.publisher;
    }
    
    /**
     * @return published Returns date of publishing
     */
    public String getDatePublished()
    {
        return this.published;
    }
    
    /**
     * @return edition Returns edition number of the book
     * @param edition of the book
     */
    private boolean validateEdition(int edition)
    {
        boolean validEdition = true;
        this.edition = edition;
        if(edition < 0)
        {
            validEdition = false;
            this.edition = 0;
        }
        return validEdition;
    } 
    
    public int getEdition()
    {
        return this.edition;
    }
    
} // END OF CLASS Book 