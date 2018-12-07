import java.io.IOException;
import java.io.EOFException;

public class StockItemManagerV2 {
 public static void main(String[] args) {   
  DataAccessClass dacObject = new DataAccessClass("StockFile.dat", "rw");
     
  System.out.println("************** Begin Output Phase **************\n" ) ;
  
  StockItem item = null ;
  
  item = new StockItem(StockItem.ACTIVE_RECORD_STATUS , 
       "94680351", 
       "Intro to Java", 
       140.00, 
       2013, 
       50) ;
  dacObject.writeData(item);
  
  item = new StockItem(StockItem.ACTIVE_RECORD_STATUS , 
       "88800002", 
       "Harry Java", 
       25.00, 
       2003, 
       100) ;
  
  dacObject.writeData(item);
  
  item = new StockItem(StockItem.ACTIVE_RECORD_STATUS , 
       "00033303", 
       "Java Wars", 
       20.00, 
       1977, 
       100) ;
  
  dacObject.writeData(item);
  
  item = new StockItem(StockItem.ACTIVE_RECORD_STATUS , 
       "04440404", 
       "Java and Peace", 
       55.00, 
       2012, 
       100) ;
  
  dacObject.writeData(item);
  
  item = new StockItem(StockItem.ACTIVE_RECORD_STATUS , 
       "00555505", 
       "The Java Games", 
       35.00, 
       2013, 
       80) ;
  
  dacObject.writeData(item);
  
  item = new StockItem(StockItem.ACTIVE_RECORD_STATUS , 
       "60660006", 
       "Java Love", 
       50.00, 
       2010, 
       60) ;
  
  dacObject.writeData(item);
  
  System.out.println("************** Begin Input Phase **************\n" ) ;
  
  dacObject.setFilePointerToStart() ;
  
  StockItem inputItem = new StockItem();
  
  try  {
   while ( true)
   {
    dacObject.readData(inputItem) ;
   
    System.out.println(inputItem.toString());
   }
  }
  
  catch (EOFException e)  {
   System.out.println("An EOFException occurred while reading data from the RandomAccessFile.") ;
  }
  
  catch (IOException e)  {
   System.out.println("An IOException occurred while reading data from the RandomAccessFile.") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while reading data from the RandomAccessFile.") ;
  }
  
  System.out.println("************** Update Record 2 **************\n" ) ;
  
  item.setRecordStatus(StockItem.ACTIVE_RECORD_STATUS) ; 
  item.setISBN("20022202") ; 
  item.setTitle("Discount Java") ; 
  item.setPrice(17.50) ; 
  item.setYearPublished(2001) ; 
  item.setQuantityOnHand(110) ;

  try  {
   dacObject.updateRecord(2, item);
  }
  
  catch (EOFException e)  {
   System.out.println("An EOFException occurred while updating data in the RandomAccessFile.") ;
  }
  
  catch (IOException e)  {
   System.out.println("An IOException occurred while updating data in the RandomAccessFile.") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while updating data in the RandomAccessFile.") ;
  }
  
  System.out.println("************** Update Record 4 **************\n" ) ;
  
  item.setRecordStatus(StockItem.ACTIVE_RECORD_STATUS) ; 
  item.setISBN("00004444") ; 
  item.setTitle("Advanced Java") ; 
  item.setPrice(28.00) ; 
  item.setYearPublished(1996) ; 
  item.setQuantityOnHand(96) ;

  try  {
   dacObject.updateRecord(4, item);
  }
  
  catch (EOFException e)  {
   System.out.println("An EOFException occurred while updating data in the RandomAccessFile.") ;
  }
  
  catch (IOException e)  {
   System.out.println("An IOException occurred while updating data in the RandomAccessFile.") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while updating data in the RandomAccessFile.") ;
  }
  
  System.out.println("************** Display Record 2 After Updates **************\n" ) ;
  
  try  {
   dacObject.readData(2, inputItem) ;
   
   System.out.println(inputItem.toString());
  }
  
  catch (EOFException e)  {
   System.out.println("An EOFException occurred while reading data from the RandomAccessFile.") ;
  }
  
  catch (IOException e)  {
   System.out.println("An IOException occurred while reading data from the RandomAccessFile.") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while reading data from the RandomAccessFile.") ;
  }
  
System.out.println("************** Display Record 4 After Updates **************\n" ) ;
  
  try  {
   dacObject.readData(4, inputItem) ;
   
   System.out.println(inputItem.toString());
  }
  
  catch (EOFException e)  {
   System.out.println("An EOFException occurred while reading data from the RandomAccessFile.") ;
  }
  
  catch (IOException e)  {
   System.out.println("An IOException occurred while reading data from the RandomAccessFile.") ;
  }
  
  catch (Exception e)  {
   System.out.println("A generic Exception occurred while reading data from the RandomAccessFile.") ;
  }
  
  dacObject.closeFile() ;
 }//end main
}//end class