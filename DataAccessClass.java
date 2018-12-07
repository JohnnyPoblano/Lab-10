import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.EOFException;

public class DataAccessClass {
 private RandomAccessFile stockFile = null ;
 private String fileName = null ;
 
 public DataAccessClass() {
 }

 public DataAccessClass( String fileNameParm, String accessMode ) {
  this.fileName = fileNameParm ;
  
  try {
   stockFile = new RandomAccessFile( fileName, accessMode );
   System.out.println("rec no: " + stockFile.getFD().toString() ) ;
  }
  
  catch (IOException e) {
   System.out.println("An IOException occurred while allocating the RandomAccessFile, " + fileName +".") ;
  }
  
  catch (Exception e) {
   System.out.println("A generic Exception occurred while allocating the RandomAccessFile, " + fileName +".") ;
  }
 }//end DataAccessClass
 
 //-------------------------------------------------------------------------------------------------
 public void writeData( StockItem item) {  
  try  {
   //System.out.println("Before writing rec no: " + stockFile.getFilePointer() ) ;
   stockFile.writeInt(item.getRecordStatus());
   //System.out.println("Before writing ISBN: " + stockFile.getFilePointer() ) ;
   stockFile.writeChars(item.getISBN());
   //System.out.println("Before writing desc: " + stockFile.getFilePointer() ) ;
   stockFile.writeChars(item.getTitle());
   //System.out.println("Before writing price: " + stockFile.getFilePointer() ) ;
   stockFile.writeDouble(item.getPrice());
   //System.out.println("Before writing year published: " + stockFile.getFilePointer() ) ;
   stockFile.writeInt(item.getYearPublished());
   //System.out.println("Before writing qoh: " + stockFile.getFilePointer() ) ;
   stockFile.writeInt(item.getQuantityOnHand());
  }
  //--------------------------------------------------------------------------------------------------
  catch (IOException e)  {
   System.out.println("An IOException occurred while writing data to the RandomAccessFile, " + fileName +".") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while writing data to the RandomAccessFile, " + fileName +".") ;
  }
 }
 
 public void setFilePointerToStart() { 
  try  {
   stockFile.seek(0) ;
  }
  
  catch (IOException e)  {
   System.out.println("An IOException occurred while setting the RandomAccessFile pointer back to the beginning.") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while setting the RandomAccessFile pointer back to the beginning.") ;
  }
 }
 
 //---------------------------------------------------------------------------------------------------
 public void readData( StockItem item) throws IOException, EOFException, Exception { 
  item.setRecordStatus( stockFile.readInt() );
  
  StringBuffer sb = new StringBuffer();
  
  // Access the characters for the ISBN.
  for (int i = 0 ; i < item.getISBNLength(); i++)  {
   sb.append(stockFile.readChar());
  }
  
  item.setISBN(sb.toString()) ;
  
  sb.setLength(0) ; // Clear the StringBuffer object.
  
  // Access the characters for the title.
  for (int i = 0 ; i < item.getTitleLength(); i++)  {
   sb.append(stockFile.readChar());
  }
  
  item.setTitle(sb.toString()) ;
  item.setPrice( stockFile.readDouble() ) ;
  item.setYearPublished( stockFile.readInt() ) ;
  item.setQuantityOnHand( stockFile.readInt() ) ;
 }

 //------------------------------------------------------------------------------------------------------
 public void readData( int recordToRead, StockItem item) throws IOException, EOFException, Exception { 
  long recordLocation = StockItem.recordLength * recordToRead ;
  
  stockFile.seek(recordLocation) ;
  
   readData(item) ;
 }
 
//------------------------------------------------------------------------------------------------------ 
 public void updateRecord( int numberOfRecordToUpdate, StockItem item) throws IOException, EOFException, Exception { 
  long recordLocation = StockItem.recordLength * numberOfRecordToUpdate ;
  
  System.out.println("Record to update: " + numberOfRecordToUpdate + 
               " StockItem.recordLength " + StockItem.recordLength + 
               " recordLocation: " + recordLocation) ;
  
  System.out.println("Update info: " + item.toString()) ;
  
  stockFile.seek(recordLocation) ;
  
  writeData( item);
 }
 
 //------------------------------------------------------------------------------------------------------ 
 public void closeFile() {
  try  {
   stockFile.close();
  }
  
  catch (IOException e)  {
   System.out.println("An IOException occurred while writing data to the RandomAccessFile, " + fileName +".") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while writing data to the RandomAccessFile, " + fileName +".") ;
  }
 }
}
