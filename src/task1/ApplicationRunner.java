package task1;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ApplicationRunner {

    public static void main(String[] args) 
    {
      System.out.println("\n************************** CIPHERED TEXT ***************************\n");
        String dataFile = System.getProperty("user.dir") + File.separator + "datafile.txt";
        
                   int cCount = 0;
                   int vCount = 0;
                   String s = "";
        try 
        {
            //Create an object of the load file
             File dataObject = new File(dataFile);
             Scanner fileRead = new Scanner(dataObject);

             //loop until file does not have next line
             while(fileRead.hasNextLine())
             {

                String data = fileRead.nextLine();

                //Character in index
                for(int i = 0; i < data.length(); i++)
                {
                  //Reset tmpString, ready for next consonant or vowel cipher.
                  String tmpString = "";

                  //If the next character is a 'C' (consonant)
                  if(data.charAt(i) == 'C')
                  {
                    //Loop until iteration is not a digit
                    for(int c = i + 1; c < data.length(); c++)
                    {  
                      
                      //if it is a digit, then add to tmpString readying for the cipher.
                      if(Character.isDigit(data.charAt(c)))
                      {
                        //If digit and if that digit is the last character of the line, break
                        if(c == data.length() - 1)
                        {
                          tmpString += data.charAt(c);
                          s += consonants("" + tmpString);
                          break;
                        
                        }
                        //Else if it isnt the end of the line.
                        else 
                        {
                        tmpString += data.charAt(c);
                        }
                      }
                      
                      //If it is a space, calculate what the consonant was, input space and break.
                      else if(data.charAt(c) == ' ')
                      {
                        s += consonants(tmpString) + " ";
                        break;
                      }
                      //Else if it is not a digit, then cipher what the consonant is and break.
                      else
                      {
                        s += consonants(tmpString);
                        break;
                      }
                    }
                  }

                  //If the next character is a 'V' (vowel)
                  else if(data.charAt(i) == 'V')
                  {
                    //Loop until iteration is not a digit
                    for(int v = i+1; v < data.length(); v++)
                    {
                      //If it is a digit, then add to tmpString readying for the cipher
                      if(Character.isDigit(data.charAt(v)))
                      {
                        //If digit and if that digit is the last character of the line, cipher & break
                        if(v == data.length() - 1)
                        {
                          tmpString += data.charAt(v);
                          s += vowels("" + tmpString);
                          break;
                        }
                        //else if it isnt the end of the line;
                        else
                        {
                        tmpString += data.charAt(v);
                        }
                      }
                      //If it is a space, cipher what the vowel was, input space  and break
                      else if(data.charAt(v) == ' ')
                      {
                        s += vowels(tmpString) + " ";
                        break;
                      }
                      //Else if iteration is not a digit, then cipher what the vowel is and break
                      else
                      {
                        s += vowels(tmpString);
                        break;
                      }
                    }
                  }
                  //if iteration is at the end of line
                  if(i == data.length() - 1)
                  {
                    //print new line at the end of cipher line
                    s += "\n";

                  }
                } 
             }
        System.out.println(s);  
        
        //Try to write on file
        try 
        {
        //File to write on.
        FileWriter resultObject = new FileWriter("results.txt");
        resultObject.write(s + "\n");
        resultObject.close();
        }
        catch(IOException e)
        {
          System.out.println("COULD NOT WRITE ON FILE");
          e.printStackTrace();
        }
        System.out.println("\n****************************** E N D ******************************\n");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Could not find file...");    
            e.printStackTrace();
        }
	}

  //Procedure for if it is a vowel
  public static char vowels(String number)
  {
    char deciphered = 0;
    int vowelPos = Integer.parseInt(number);
    
    switch(vowelPos)
    {
      case 1:
        deciphered = 'a';
        break;
      case 2:
        deciphered = 'A';
        break;
      case 3:
        deciphered = 'e';
        break;
      case 4:
        deciphered = 'E';
        break;
      case 5:
        deciphered = 'i';
        break;
      case 6:
        deciphered = 'I';
        break;
      case 7:
        deciphered = 'o';
        break;
      case 8:
        deciphered = 'O';
        break;
      case 9:
        deciphered = 'u';
        break;
      case 10:
        deciphered = 'U';
        break;
      case 11:
        deciphered = 'y';
        break;
      case 12:
        deciphered = 'Y';
        break;
    }
    return deciphered;
  }

  //Procedure if it was a consonant
  public static char consonants(String number)
  {
      char deciphered = 0;
      int consonantPos = Integer.parseInt(number);
      switch(consonantPos)
      {
        case 1:
            deciphered = 'b';
            break;
        case 2:
            deciphered = 'B';
            break;
        case 3:
            deciphered = 'c';
            break;
        case 4:
            deciphered = 'C';
            break;
        case 5:
            deciphered = 'd';
            break;
        case 6:
            deciphered = 'D';
            break;
        case 7:
            deciphered = 'f';
            break;
        case 8:
            deciphered = 'F';
            break;
        case 9:
            deciphered = 'g';
            break;
        case 10:
            deciphered = 'G';
            break;
        case 11:
            deciphered = 'h';
            break;
        case 12:
            deciphered = 'H';
            break;
        case 13:
            deciphered = 'j';
            break;
        case 14:
            deciphered = 'J';
            break;
        case 15:
            deciphered = 'k';
            break;
        case 16:
            deciphered = 'K';
            break;
        case 17:
            deciphered = 'l';
            break;
        case 18:
            deciphered = 'L';
            break;
        case 19:
            deciphered = 'm';
            break;
        case 20:
            deciphered = 'M';
            break;
        case 21:
            deciphered = 'n';
            break;
        case 22:
            deciphered = 'N';
            break;
        case 23:
            deciphered = 'p';
            break;
        case 24:
            deciphered = 'P';
            break;
        case 25:
            deciphered = 'q';
            break;
        case 26:
            deciphered = 'Q';
            break;
        case 27:
            deciphered = 'r';
            break;
        case 28:
            deciphered = 'R';
            break;
        case 29:
            deciphered = 's';
            break;
        case 30:
            deciphered = 'S';
            break;
        case 31:
            deciphered = 't';
            break;
        case 32:
            deciphered = 'T';
            break;
        case 33:
            deciphered = 'v';
            break;
        case 34:
            deciphered = 'V';
            break;
        case 35:
            deciphered = 'w';
            break;
        case 36:
            deciphered = 'W';
            break;
        case 37:
            deciphered = 'x';
            break;
        case 38:
            deciphered = 'X';
            break;
        case 39:
            deciphered = 'z';
            break;
        case 40:
            deciphered = 'Z';
            break;
      }
      return deciphered;
  }
}
