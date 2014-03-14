/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.manager;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import pt.uc.dei.ipj.grupoa.EJB.SearchMusic;
import pt.uc.dei.ipj.grupoa.entities.Music;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "SearchMusicBean")
@SessionScoped
public class SearchMusicBean {

    /**
     * Creates a new instance of SearchMusic
     */
    public SearchMusicBean() {
    }
    
    private String introducedText;
    
    @EJB
    private SearchMusic searchMusic;
    
   
    
//    public String showSpecificMusic() throws QueryParseException, QueryExecutionException{
//
//        List<Music>=searchMusic.searchByMusic(getIntroducedText());
//        
//        return "searchmusic";
//    }
    
    public String showSpecificAuthor(){
        
        
       return "searchMusic";
    }

    public String getIntroducedText() {
        return introducedText;
    }

    public void setIntroducedText(String introducedText) {
        this.introducedText = introducedText;
    }

  
    
    
}
