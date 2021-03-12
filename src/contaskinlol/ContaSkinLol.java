/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaskinlol;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import org.jsoup.nodes.Element;
import java.util.*;

/**
 *
 * @author federico
 */
public class ContaSkinLol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ArrayList<String>  maschi = new ArrayList<>();
          ArrayList<String>  femmine = new ArrayList<>();
          int maschiCount = 0,femmineCount=0;
           String champ = "";
          maschi = new ArrayList<String> 
                (Arrays.asList("aatrox","alistar","amumu","aphelios","aurelion_sol","azir","bard","blitzcrank","brand","braum","dr._mundo","draven"
                        ,"ekko","ezreal","corki","darius","cho%27gath","fiddlesticks","fizz","galio","gangplank","garen","gnar",
                        "gragas","graves","hecarim","heimerdinger","ivern","jarvan_iv","jax","jayce","jhin","karthus",
                        "kassadin","kayn","kennen","kha%27zix","kled","kog%27maw","lee_sin","lucian","malphite","malzahar","maokai"
                        ,"master_yi","mordekaiser","nasus","nautilus","nocturne","nunu_%26_willump","olaf"
                        ,"ornn","pantheon","pyke","rakan","rammus","rek%27sai","renekton","rengar","rumble","ryze","sett","shaco","shen","singed",
                        "sion","skarner","swain","sylas","tahm_kench","taliyah","talon","taric","teemo","thresh","trundle","tryndamere",
                        "twisted_fate","twitch","udyr","urgot","varus","veigar","vel%27koz","viego","viktor","vladimir","volibear","warwick","wukong"
                        ,"xin_zhao","yasuo","yone","yorick","zac","zed","ziggs","zilean","xerath"));
          femmine = new ArrayList<String> 
                (Arrays.asList("ahri","akali","anivia","annie","ashe","caitlyn","camille","cassiopeia","diana","elise","evelynn","fiora",
                        "illaoi","irelia","janna","jinx","kai%27sa","kalista","karma","katarina","kayle","kindred",
                        "leblanc","leona","lillia","lissandra","lulu","lux","miss_fortune","morgana","nami","neeko","nidalee"
                        ,"orianna","poppy","qiyana","quinn","rell","riven","samira","sejuani","senna","seraphine","shyvana",
                        "sivir","sona","soraka","syndra","tristana","vayne","vi","xayah","yuumi","zoe","zyra"));
      
        try {
        File skins = new File("C:/Users/federico/Documents/NetBeansProjects/ContaSkinLol/src/contaskinlol/listaSkins.txt");
      Scanner myReader = new Scanner(skins);
      
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
       
        if(data.length()>8)
        {
            data = data.substring(4,data.length() -4);
            Document doc = Jsoup.parse(data);
            Element link = doc.select("a").first();
            champ = link.attr("href");
            champ = champ.substring(6);
            champ = champ.toLowerCase();
            
            
            if(maschi.contains(champ))
                maschiCount++;
            else
            {
                if(femmine.contains(champ))
                    femmineCount++;
                else
                    System.out.println("errore champ non trovato: "+champ);
        }
        
       
       
      }
     
      }
       myReader.close();
      maschiCount-=maschi.size();
      femmineCount-=femmine.size();
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
       System.out.println("tot skin maschi: "+maschiCount);
       System.out.println("tot skin femmine: "+femmineCount);
    }
    
}
