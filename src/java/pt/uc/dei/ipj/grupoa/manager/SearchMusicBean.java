/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.manager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import static pt.uc.dei.ipj.grupoa.entities.UserPlay_.music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

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
    
    @EJB
    private MusicFacade musicFacade;

    private String introducedText;
   
    public String showSpecificMusic() {
        musicFacade.listOfAllMusics();
        return "searchmusic";
    }
    
    public String showSpecificAuthor(){
       musicFacade.searchedAuthor();
       return "searchMusic";
    }

    public String getIntroducedText() {
        return introducedText;
    }

    public void setIntroducedText(String introducedText) {
        this.introducedText = introducedText;
    }
}
