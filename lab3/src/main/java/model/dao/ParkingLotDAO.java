/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;
import model.entity.ParkingLot;

/**
 *
 * @author makka
 */
@Stateless
public class ParkingLotDAO extends AbstractDAO<ParkingLot> {
    @Getter
    @Setter
    @PersistenceContext(unitName = "webweebs")
    private EntityManager entityManager;
    
    public ParkingLotDAO() {
        super(ParkingLot.class);
    }
    
    public int available_spaces(ParkingLot pl) {
        return pl.getCapacity() - pl.getCars().size();
    }
}