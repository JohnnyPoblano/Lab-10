/*
** John Gumm
** CIS 131
** Lab 10
*/

import java.io.IOException;
import java.io.EOFException;

public class StockItemManagerV2 {
 public static void main(String[] args) {   
  DataAccessClass dacObject = new DataAccessClass("StockFile.dat", "rw");
     
  System.out.println("************** Begin Output Phase **************\n" ) ;
  
  Books item = null ;
  
  item = new Books(Books.ACTIVE_RECORD_STATUS , 
       "94680351", 
       "Intro to Java", 
       140.00, 
       2013, 
       50) ;
  dacObject.writeData(item);
  
  item = new Books(Books.ACTIVE_RECORD_STATUS , 
       "88800002", 
       "Harry Java", 
       25.00, 
       2003, 
       100) ;
  
  dacObject.writeData(item);
  
  item = new Books(Books.ACTIVE_RECORD_STATUS , 
       "00033303", 
       "Java Wars", 
       20.00, 
       1977, 
       100) ;
  
  dacObject.writeData(item);
  
  item = new Books(Books.ACTIVE_RECORD_STATUS , 
       "04440404", 
       "Java and Peace", 
       55.00, 
       2012, 
       100) ;
  
  dacObject.writeData(item);
  
  item = new Books(Books.ACTIVE_RECORD_STATUS , 
       "00555505", 
       "The Java Games", 
       35.00, 
       2013, 
       80) ;
  
  dacObject.writeData(item);
  
  item = new Books(Books.ACTIVE_RECORD_STATUS , 
       "60660006", 
       "Java Love", 
       50.00, 
       2010, 
       60) ;
  
  dacObject.writeData(item);
  
  System.out.println("************** Begin Input Phase **************\n" ) ;
  
  dacObject.setFilePointerToStart() ;
  
  Books inputItem = new Books();
  
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
  
  // Change title of record 0
  System.out.println("************** Update Record 0 **************\n" ) ;
  
  item.setRecordStatus(Books.ACTIVE_RECORD_STATUS) ; 
  item.setISBN("94680351") ; 
  item.setTitle("Donuts & Java") ; 
  item.setPrice(140.00) ; 
  item.setYearPublished(2013) ; 
  item.setQuantityOnHand(50) ;

  try  {
   dacObject.updateRecord(0, item);
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
  

  // Change price of record 1
  System.out.println("************** Update Record 1 **************\n" ) ;
  
  item.setRecordStatus(Books.ACTIVE_RECORD_STATUS) ; 
  item.setISBN("88800002") ; 
  item.setTitle("Harry Java") ; 
  item.setPrice(80.00) ; 
  item.setYearPublished(2003) ; 
  item.setQuantityOnHand(100) ;


  try  {
   dacObject.updateRecord(1, item);
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
  
  System.out.println("************** Display Record 0 After Updates **************\n" ) ;
  
  try  {
   dacObject.readData(0, inputItem) ;
   
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
  
System.out.println("************** Display Record 1 After Updates **************\n" ) ;
  
  try  {
   dacObject.readData(1, inputItem) ;
   
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