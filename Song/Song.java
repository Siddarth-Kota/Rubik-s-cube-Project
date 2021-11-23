import java.util.LinkedHashSet;
import java.util.Scanner;
import java.io.File;

public class Song
{
  public static void main(String [] args)
  {

    readData();
  }

  //colors
  public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
  public static final String RED_BRIGHT = "\033[0;91m";    // RED
  public static final String RESET = "\033[0m";  // Text Reset
  public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
  public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW

  public static void readData()
  {
    try {

      Scanner in  = new Scanner(new File("songs_new_line.txt"));
      Scanner lines  = new Scanner(new File("songs_new_line.txt"));
     
      //finds first number of words
      Scanner wordcountfirst  = new Scanner(new File("songs_new_line.txt"));
      wordcountfirst.nextLine();
      String longestartist = wordcountfirst.nextLine();
      wordcountfirst.nextLine();

      //initiallize all variables needed
        int i = 0; int Wordsum = 0; int subcount = 1; int z = 0;
        //final variables
        int songs = 0; int avgwords = 0; int mostwords = -1; int leastwords = Integer.parseInt(wordcountfirst.nextLine());
        int permcount = 0; String mostartist = ""; String mostwordsong = ""; String leastwordsong = "";

      //finding number of songs for arrays
      while(lines.hasNext()) {
        songs++;
        lines.nextLine();
      }
      songs = songs/4;

      //initializing arrays with value of songs to fit them just right
      String[] namearr = new String[songs];
      String[] artistarr = new String[songs];
      Integer[] yeararr = new Integer[songs];
      Integer[] numWordsarr = new Integer[songs];
      String[] repeatedsongsarr = new String[songs];
      LinkedHashSet<String> repeatedsongshash = new LinkedHashSet<String>();


      while(in.hasNext()) {
        //find out the different info about each song
        String name = in.nextLine();
        String artist = in.nextLine();
        String yearstr = in.nextLine();
        String numWordsstr = in.nextLine();
        //change year and word count from string to int
        int year = Integer.parseInt(yearstr);
        int numWords = Integer.parseInt(numWordsstr);
        
        //putting the names into arrays
        namearr[i] = name;
        artistarr[i] = artist;
        yeararr[i] = year;
        numWordsarr[i] = numWords;
        i++;
      }

      //calculation work
      for(int count = 0; count < numWordsarr.length; count++) {
        //total words
        Wordsum += numWordsarr[count];
        //most words
        if(mostwords < numWordsarr[count]) {
          mostwordsong = namearr[count];
          mostwords = numWordsarr[count];
        }
        //least words
        if(leastwords > numWordsarr[count]) {
          leastwordsong = namearr[count];
          leastwords = numWordsarr[count];
        }
      //average words
      avgwords = (Wordsum/songs);
      }
      
      
      for(int x = 0; x < artistarr.length; x++) {
        subcount = 1;
        for(int y = x + 1; y < artistarr.length; y++) {
          //artist that appears most
          if(artistarr[x].equals(artistarr[y])) {
            subcount++;
          }
          if(namearr[x].equals(namearr[y])) {
            repeatedsongsarr[z] = namearr[x];
            z++;
          }
        }
        if(subcount > permcount) {
          mostartist = artistarr[x];
          permcount = subcount;
        }
        //longest artist name
        if(longestartist.length() < artistarr[x].length()) {
          longestartist = artistarr[x];
        }
      }
      for(int w = 0; w < repeatedsongsarr.length; w++) {
        repeatedsongshash.add(repeatedsongsarr[w]);
      }
    

    //print stream
    System.out.println("");
    System.out.println(CYAN_BRIGHT + "The total number of songs is " + RED_BRIGHT + songs + RESET);
    System.out.println("");
    System.out.println(GREEN_BRIGHT + "The average nummber of words per song is " + YELLOW_BRIGHT + avgwords + RESET);
    System.out.println("");
    System.out.println(CYAN_BRIGHT + "The song with the least number of words is " + RED_BRIGHT + leastwordsong + CYAN_BRIGHT + " with " + RED_BRIGHT + leastwords + CYAN_BRIGHT + " words " + RESET);
    System.out.println("");
    System.out.println(GREEN_BRIGHT + "The song with the most number of words is " + YELLOW_BRIGHT + mostwordsong + GREEN_BRIGHT + " with " + YELLOW_BRIGHT + mostwords + GREEN_BRIGHT + " words " + RESET);
    System.out.println("");
    System.out.println(CYAN_BRIGHT + "The artist with the longest name is " + RED_BRIGHT + longestartist);
    System.out.println("");
    System.out.println(GREEN_BRIGHT + "The artist that appears the most number of times is " + YELLOW_BRIGHT + mostartist + GREEN_BRIGHT + " and they appear " + YELLOW_BRIGHT + permcount + GREEN_BRIGHT + " times" + RESET);
    System.out.println("");
    System.out.println(CYAN_BRIGHT + "Songs that repeated more than once are: " + RED_BRIGHT + repeatedsongshash + RESET);
    

    }
    catch (Exception e) {
      System.out.println("your program failed :(");
    }
  }
}