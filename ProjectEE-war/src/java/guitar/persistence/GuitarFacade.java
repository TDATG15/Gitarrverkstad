
package guitar.persistence;

import entities.Guitar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GuitarFacade extends AbstractFacade<Guitar> {

    @PersistenceContext(unitName = "ProjectEE-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuitarFacade() {
        super(Guitar.class);
    }
    
}
