
public class Book {
	
	private int quantity;
	private String title;
	private String author = "unknown";
	private String year;
/*	
	public Book(String title, String year) {
		this(title,year,0);
	}
	
	public Book(String title, String year, int quantity) {
		this.title = title;
		this.year = year;
		this.quantity = quantity;
	}
*/	
	public Book(String title, String author, String year){
		this(title,author,year,0);
	}
	
	public Book(String title, String author, String year, int quantity) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.quantity = quantity;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void println(){
		System.out.println(this.getTitle() + " " + this.getAuthor() + " " + this.getYear() + " " + this.getQuantity());
	}
	
}
