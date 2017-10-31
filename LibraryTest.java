import org.junit.*;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

  Library universityLibrary;
  Book book1;

  @Before
  public void before() {
    this.universityLibrary = new Library("Edinburgh University", 500);
    this.book1 = new Book();
  }

  @Test
  public void hasLocation() {
    assertEquals("Edinburgh University", universityLibrary.getLocaiton());
  }

  @Test
  public void hasReaders(){
    assertEquals(500, universityLibrary.getReaders());
  }

  @Test
  public void hasMaxBookCapacity() {
    Book[] collection1 = universityLibrary.getCollection();
    assertEquals(20000, collection1.length);
  }

  @Test
  public void collectionStartsEmpty() {
    assertEquals(0, universityLibrary.bookCount());
  }

  @Test
  public void canAddBooks() {
    universityLibrary.addNewBookIn(book1);
    assertEquals(1, universityLibrary.bookCount());
  }

  @Test
  public void libraryStockIsFull() {
    for(int i = 0; i < 20000; i++) {
      universityLibrary.addNewBookIn(book1);
    }
    assertEquals(true, universityLibrary.libraryStockIsFull());
  }

  @Test
  public void canNotAddBooksWhenFull() {
    for(int i = 0; i < 20002; i++) {
      universityLibrary.addNewBookIn(book1);
    }
    assertEquals(20000, universityLibrary.bookCount());
  }

  @Test
  public void shouldBeAbletoCleanLibrary() {
    universityLibrary.addNewBookIn(book1);
    universityLibrary.cleanLibrary();
    assertEquals(0, universityLibrary.bookCount());
  }

  @Test
  public void notReadyToShutTheDoor() {
    boolean result = universityLibrary.timeToCloseDoorWhenReachesCapacity();
    assertEquals(false, result);
  }

  @Test
  public void readyToShutTheDoor() {
    Library testLibrary = new Library("Test location", 501);
    boolean result = testLibrary.timeToCloseDoorWhenReachesCapacity();
    assertEquals(true, result);
  }



}
