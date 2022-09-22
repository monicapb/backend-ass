/**
 * 
 */
package com.aelion.suivi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.entities.PoeEntity;
import com.aelion.suivi.repositories.POERepository;

/**
 * @author jean-luc
 *
 */
@Service
public class PoeService implements ICrud<PoeEntity> {
	
	@Autowired
	private POERepository repository;

	@Override
	public PoeEntity add(PoeEntity item) {
		return this.repository.save(item);
	}

	@Override
	public PoeEntity[] add(PoeEntity[] items) {
		return null;
	}

	@Override
	public void update(PoeEntity item) {
		this.repository.save(item);
		
	}

	/**
	 * Si mon id est Long je dois faire d'une autre façon voir code du document 
	 */
	@Override
	public void delete(PoeEntity item) {
		this.repository.delete(item);
		
	}
	
	/**
	 * Methode delete via l'id crée uniquement dans mon service et pas dans le icrud
	 * Overload que si la signature est different , on peut faire deux methodes pour une meme classe
	 * @param id
	 */
	public void deleteById(int id) throws Exception {
		Optional<PoeEntity> oEntity = this.findOne((long) id);
		if(oEntity.isPresent()) {
			try {
				this.repository.deleteById(id);
				
			} catch(IllegalArgumentException e) {
				throw new IllegalArgumentException();
			}
		}
		throw new Exception("POE with id: "+ id + " was not found");
		
	}

//	@Override
//	public List<PoeEntity> findAll() {
//		UNE FAÇON D'AFFICHER LA LISTE DE POES EN FAISANT UN CAST --> (List<PoeEntity>)
	
//		return C this.repository.findAll();
//	}

	@Override
	public List<PoeEntity> findAll() {
		return (List<PoeEntity>) this.repository.findAll();
	}
	
//    @Override
//    public List<PoeEntity> findAll() {
//        // TODO Auto-generated method stub
//        //return (List<InternEntity>) this.repository.findAll();
//        
//        Iterable<PoeEntity> itpoes = this.repository.findAll();
//        Iterator<PoeEntity> itrpoes = itpoes.iterator();
//        
//        ArrayList<PoeEntity> alpoes = new ArrayList<>();
//        
//        while(itrpoes.hasNext()) {
//            alpoes.add(itrpoes.next());
//        }
//        return alpoes;
//    }
    
    
	@Override
	public Optional<PoeEntity> findOne(Long id) {
		int intId = id.intValue();
		return this.repository.findById(intId);
	
	}
	
	public PoeEntity getOne(Long id) throws Exception{
		
		Optional<PoeEntity> oEntity = this.repository.findById(id.intValue());
		if(oEntity.isPresent()) {
			return oEntity.get();
	}
		throw new Exception ("the POE with" + id + "not found");
	}
}
	


