package data;

import java.sql.ResultSet;
import java.util.LinkedList;

import java.util.EnumMap;

public class Restaurants {




    public static ResultSet getRestaurantsOnCategories() {
        ResultSet result = Table.getAttributes("Restaurants", "nomPlat, descriptionPlat, prixPlat", "emailResto = '" + emailResto + "'");
    }

    public String getEmail(){
        return this.emailResto;
    }
    
    public String getNom(){
        return this.nomResto;
    }
    
    public int getNum(){
        return this.numResto;
    }
    
    public int getNbPlacesAssises(){
        return this.nbPlacesAssises;
    }
    
    public String getTextePresentation(){
        return this.textePresentation;
    }
    
    public int getSommeNote(){
        return this.sommeNote;
    }
    
    public int getCardinalNote(){
        return this.cardinalNote;
    }

    public float getNote(){
        return this.sommeNote / this.cardinalNote;
    }


    public EnumMap<TypeInfoResto, Object> getInfos(LinkedList<TypeInfoResto> ti){
        EnumMap<TypeInfoResto, Object> infos = new EnumMap<TypeInfoResto, Object>();

        for(TypeInfo info: ti){
            //infos[ti] = 
        }

        return infos;
    }

            

}

