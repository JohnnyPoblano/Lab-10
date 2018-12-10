//package cis131.RandomAccessFileProcessing;

public class StockItem   //books
{
 static final int ACTIVE_RECORD_STATUS  = 1 ;
 static final int DELETED_RECORD_STATUS = 0 ;
 
 final int TITLE_LENGTH = 15 ;
 final int ISBN_LENGTH = 8 ;
 
 private int    recordStatus ;
 private String ISBN ;              // sku
 private String title ;             // description
 private double price ;             // cost
 private int    yearPublished;
 private int    quantityOnHand ; 
 
 static public int recordLength = 0 ;
 
 public void setRecordLength()
 {
  // Integer and Double sizes are in bits therefore we must divide by 8 to obtain bytes.
  // Java uses wide characters which contain two bytes therefore we must multiply
  // ISBN_LENGTH and TITLE_LENGTH by 2.
  recordLength = (Integer.SIZE / 8 ) + (ISBN_LENGTH * 2)+ (TITLE_LENGTH * 2) + 
      (Double.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8);
 }
 
 public int getRecordLength() {  return recordLength ; }
 
 public StockItem () {
  setRecordStatus(ACTIVE_RECORD_STATUS) ;
  
  setISBN( "" ) ;
  setTitle( "" ) ;
  setPrice( 0.0 ) ;
  setYearPublished ( 0 ) ;
  setQuantityOnHand( 0 ) ;
  setRecordLength() ;
 }
 
 public StockItem (int recordStatus, String ISBN, String title, double price, int yearPublished, int quantityOnHand) {
  setRecordStatus( recordStatus) ;
  setISBN( ISBN ) ;
  setTitle( title ) ;
  setPrice( price ) ;
  setYearPublished( yearPublished ); 
  setQuantityOnHand( quantityOnHand ) ;
  setRecordLength() ;
 }
 
 public StockItem (int recordStatus, String ISBN, String title, double price, int yearPublished) {
  setRecordStatus( recordStatus) ;
  setISBN( ISBN ) ;
  setTitle( title ) ;
  setPrice( price ) ;
  setYearPublished (yearPublished);
 }
 
 public void setRecordStatus (int recordStatus) {
  this.recordStatus = recordStatus ;
 }

 public int getRecordStatus () {
  return this.recordStatus ;
 }
 
 public void setISBN (String ISBN) {
  StringBuffer ISBNSB = new StringBuffer( ISBN ) ;
  
  if (ISBNSB.length() != ISBN_LENGTH) 
   ISBNSB = setCorrectLength( ISBNSB, ISBN_LENGTH) ;
  
  this.ISBN = ISBNSB.toString() ;
 }
 
 public String getISBN () {
  return this.ISBN ;
 }
 
 public void setTitle (String title) {
  StringBuffer titleSB = new StringBuffer( title ) ;
  
  if (titleSB.length() != TITLE_LENGTH) 
   titleSB = setCorrectLength( titleSB, TITLE_LENGTH) ;
  
  this.title = titleSB.toString() ;
 }
 
 public String getTitle () {
  return this.title ;
 }
 
 public void setPrice (double price) {
  this.price = price ;
 }
 
 public double getPrice () {
  return this.price ;
 }
 
 public void setYearPublished (int yearPublished) {
  this.yearPublished = yearPublished ;
 }

 public int getYearPublished () {
  return this.yearPublished ;
 }
  
 public void setQuantityOnHand (int quantityOnHand) {
  this.quantityOnHand = quantityOnHand ;
 }

 public int getQuantityOnHand () {
  return this.quantityOnHand ;
 }
 
 public StringBuffer setCorrectLength( StringBuffer sb, int correctLength) {
  if (sb.length() > correctLength) sb.setLength(correctLength) ;
  
  if (sb.length() < correctLength)   {
   while (sb.length() < correctLength)
    sb.append(' ');      // right pad the length with spaces.
  }
  return sb ;
 }
 
 public int getTitleLength() {
  return TITLE_LENGTH ;
 }
 
 public int getISBNLength() {
  return ISBN_LENGTH ;
 }
 
 public String toString() {
  return "Record status    : " + Integer.toString(this.getRecordStatus())     + "\n" +
         "ISBN             : " + this.getISBN()                               + "\n" +
         "Title            : " + this.getTitle()                              + "\n" +
         "Year Published   : " + Integer.toString(this.getYearPublished() )   + "\n" +
         "Price            : " + Double.toString(this.getPrice() )            + "\n" +
         "Quantity on-hand : " + Integer.toString(this.getQuantityOnHand() )  + "\n" ;
 }
 
}//end of class