import java.io.*;
import minipython.lexer.Lexer;
import minipython.node.Token;

public class LexerTest
{
  public static void main(String[] args)
  {
    try
    {
      Lexer lexer =
        new Lexer(
        new PushbackReader(
        new FileReader(args[0].toString()), 1024));

      Token token = lexer.next();
      while ( ! token.getText().equals("") )
      { 
        // System.out.print(token);
        //System.out.println(token+"."+token.getClass());
        System.out.println(token.getClass().getSimpleName() + ": " + token.getText());
        token = lexer.next(); 
      }
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }
}
