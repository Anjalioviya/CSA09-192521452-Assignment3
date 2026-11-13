import java.io.*;
class ExamException extends Exception{ExamException(String m){super(m);} ExamException(String m,Throwable c){super(m,c);}}
class SubmissionStorageException extends ExamException{SubmissionStorageException(String m,Throwable c){super(m,c);}}
class ExamWindowClosedException extends ExamException{ExamWindowClosedException(String m){super(m);}}
class StudentNotRegisteredException extends ExamException{StudentNotRegisteredException(String m){super(m);}}
class Storage{void save(String f,long kb)throws SubmissionStorageException{try{if(kb>500)throw new IOException("Disk quota exceeded");System.out.println("Saved "+f);}catch(IOException e){throw new SubmissionStorageException("Could not store "+f,e);}}}
class ExamService{Storage s=new Storage();void submit(String f,long kb,boolean registered,boolean open)throws ExamException{if(!open)throw new ExamWindowClosedException("Exam window closed");if(!registered)throw new StudentNotRegisteredException("Student not registered");s.save(f,kb);}}
public class StorageDemo{public static void main(String[]x){ExamService s=new ExamService();Object[][] cases={{"answer01.pdf",120L,true,true},{"answer02.pdf",800L,true,true},{"answer03.pdf",100L,false,true},{"answer04.pdf",100L,true,false}};
 for(Object[]c:cases)try{s.submit((String)c[0],(Long)c[1],(Boolean)c[2],(Boolean)c[3]);}catch(ExamException e){System.out.println("Error: "+e.getMessage());System.out.println("Cause: "+(e.getCause()==null?"none":e.getCause().getMessage()));}
 try{s.submit("large.pdf",900,true,true);}catch(ExamException e){System.out.println("Chained trace:");e.printStackTrace(System.out);System.out.println("getCause(): "+e.getCause());}
}}