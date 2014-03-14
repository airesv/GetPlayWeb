/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.uc.dei.ipj.grupoa.entities.Music;
import org.apache.commons.lang3.StringUtils;
import org.josql.Query;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import org.josql.QueryResults;
import static pt.uc.dei.ipj.grupoa.entities.UserPlay_.music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

/**
 *
 * @author alvaro
 */
@Stateless
public class SearchMusic {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    @EJB
    private MusicFacade musicFacade;

    
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Music> searchByMusic(String text) throws QueryParseException, QueryExecutionException {
        String[] fields = {"Name", "Artist", "Album", "Year of Release"};
        String[] words = StringUtils.split(text);
        Query query = (Query) em.createNamedQuery("Music.findAll", Music.class);
        String sql = "SELECT * FROM Music WHERE ";

        for (int c = 0; c < fields.length; c++) {
            if (c > 0) {
                sql += " OR ";
            }
            sql += fields[c] + " $LIKE '%"; // $LIKE perform a case-insensitive comparison
            sql += StringUtils.join(words, "%' OR " + fields[c] + " $LIKE '%");
            sql += "%'";
        }
        query.parse(sql);
        QueryResults queryResults = query.execute(musicFacade.listOfAllMusics());

        return (List<Music>) queryResults.getResults();
    }

}
