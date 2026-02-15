package first_level;

/*
Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre.

Exercici 2
Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un arbre de directoris amb el contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla en ordre alfabètic dins de cada nivell, indicant a més si és un directori (D) o un fitxer (F), i la seva última data de modificació.

Exercici 3
Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla, guarda el resultat en un fitxer TXT.

Exercici 4
Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola.

Exercici 5
Ara el programa ha de serialitzar un Objecte Java a un fitxer .ser i després l’ha de desserialitzar.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.sort;

public class FirstLevel {

    public static void main (String[] args){
        try{
            File directory = new File("/Users/ines/IdeaProjects/TascaS1.03/src/main/java/first_level/exercise3");
            String[] dirContent;
            dirContent = directory.list();
            if (dirContent != null){
                System.out.println(dirContent.length);
            ArrayList<String> elementsArray = new ArrayList<>(Arrays.asList(dirContent));
            //TODO SORT
            for(String element : dirContent){
                System.out.println(element);
            }
            }

        }catch (Exception e){e.printStackTrace();}
    }
}
