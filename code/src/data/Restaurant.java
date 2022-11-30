package data;

import java.util.LinkedList;
import java.util.Map;
import java.util.EnumMap;

public class Restaurant {
    
    public enum TypeInfoResto {
        EMAIL,
        NOM,
        NUM,
        NB_PLACES,
        TEXTE,
        SOMME_NOTE,
        CARDINAL_NOTE

    }

    
    /*
            
    private EnumMap<TypeInfoResto, Object> infos;


    public Restaurant(String emailResto, String nomResto,int numResto, int nbPlacesAssises, String textePresentation, int sommeNote, int cardinalNote){
        LinkedList<TypeInfoResto> cles = new LinkedList<TypeInfoResto>();
        
        for(TypeInfoResto info: TypeInfoResto.values()){
            cles.add(info);
        }

        this.infos = new EnumMap<TypeInfoResto, Object>();
        this.infos[TypeInfoResto.EMAIL] = emailResto;
        this.infos[] = nomResto;
        this.infos[] = numResto;
        this.infos[] = nbPlacesAssises;
        this.infos[] = textePresentation;
        this.infos[] = sommeNote;
        this.infos[] = cardinalNote;
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


    */
            

}

