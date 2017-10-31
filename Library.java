public class Library {
  private String location;
  private int readers;
  private Book[] collection;

  public Library (String location, int readers) {
    this.location = location;
    this.readers = readers;
    this.collection = new Book[20000];
  }

  public String getLocaiton() {
    return this.location;
  }

  public void setLocation(String newLocation) {
    this.location = newLocation;
  }

  public int getReaders() {
    return this.readers;
  }

  public void setReaders(int newReaders) {
    this.readers = newReaders;
  }

  public Book[] getCollection() {
    return this.collection;
  }

  public void setCollection(Book[] newCollection) {
    this.collection = newCollection;
  }

  public int bookCount() {
    int count = 0;
    for(Book book : collection) {
      if(book != null) {
        count++;
      }
    }
    return count;
  }

  public boolean libraryStockIsFull() {
    return bookCount() == collection.length;
  }

 public void addNewBookIn(Book book) {
   if(libraryStockIsFull()){
     return;
   }
   int bookcount = bookCount();
   collection[bookcount] = book;
 }

   public void cleanLibrary() {
     for (int i = 0; i < collection.length; i++) {
       collection[i] = null;
     }
   }

  public boolean timeToCloseDoorWhenReachesCapacity() {
    return this.readers > 500;
  }

}
