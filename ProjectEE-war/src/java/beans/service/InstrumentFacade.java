
package beans.service;

import entities.Instrument;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Elementalist
 */
@Stateless
public class InstrumentFacade extends AbstractFacade<Instrument> {

    @PersistenceContext(unitName = "ProjectEE-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstrumentFacade() {
        super(Instrument.class);
    }
    
}
