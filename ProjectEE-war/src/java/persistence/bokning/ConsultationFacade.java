
package persistence.bokning;

import entities.Consultation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ConsultationFacade extends AbstractFacade<Consultation> {

    @PersistenceContext(unitName = "ProjectEE-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultationFacade() {
        super(Consultation.class);
    }
    
}
