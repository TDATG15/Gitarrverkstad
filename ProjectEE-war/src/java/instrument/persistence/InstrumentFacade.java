/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrument.persistence;

import entities.Instrument;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elementalist
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
