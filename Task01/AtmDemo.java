import java.io.*; import java.nio.file.*; import java.util.*;
class InvalidAccountException extends Exception { InvalidAccountException(String m){super(m);} }
class InsufficientFundsException extends Exception { InsufficientFundsException(String m){super(m);} }
public class AtmDemo {
 static double withdraw(String a,int n,double b)throws InvalidAccountException,InsufficientFundsException{
  if(a==null||!a.matches("\\d{8}"))throw new InvalidAccountException("Account must contain 8 digits");
  if(n<0)throw new IllegalArgumentException("Negative withdrawal");
  if(n==0)throw new IllegalArgumentException("Amount must be positive");
  if(n>b)throw new InsufficientFundsException("Insufficient balance"); return b-n;
 }
 static void test(String label,String account,String amount,Path card){
  System.out.println("\\n-- "+label+" --");
  try { if(!Files.exists(card))throw new IOException("Card-reader file missing");
   int n; try(Scanner s=new Scanner(amount)){if(!s.hasNextInt())throw new NumberFormatException("Amount is not numeric"); n=s.nextInt();}
   System.out.println("Approved. Remaining balance: "+withdraw(account,n,5000));
  } catch(NumberFormatException|IOException e){System.out.println("Input/device error: "+e.getMessage());}
    catch(InvalidAccountException|InsufficientFundsException e){System.out.println("Rejected: "+e.getMessage());}
    catch(IllegalArgumentException e){System.out.println("Invalid amount: "+e.getMessage());}
    finally{System.out.println("finally executed");}
 }
 public static void main(String[]x)throws Exception{Path p=Path.of("data/card-reader.txt");Files.createDirectories(p.getParent());Files.writeString(p,"READY");
  test("Valid","12345678","500",p);test("Letters","12345678","abc",p);test("Negative","12345678","-50",p);test("Over balance","12345678","9000",p);test("Bad account","12A","100",p);test("Missing device","12345678","100",Path.of("data/no-card.txt"));
 }
}