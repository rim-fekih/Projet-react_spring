package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.modeles.CustomerEntity;
import com.example.demo.modeles.OwnerEntity;
import com.example.demo.modeles.ServiceEntity;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.ServiceRepository;
@Service
public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository repos;
	private ServiceRepository reposservice;
	public OwnerServiceImpl(OwnerRepository repos,ServiceRepository reposservice) {
		super();
		this.repos=repos;
		this.reposservice=reposservice;
}
	

	@Override
	public OwnerEntity createOwnerEntity(OwnerEntity Owner) {
		
		return repos.save(Owner);
	}

	@Override
	public OwnerEntity deleteOwnerEntityById(long id) {
		OwnerEntity entity = this.getOwnerEntityById(id);
		repos.deleteById(id);
		return entity;
		

	}


	@Override
	public OwnerEntity getOwnerEntityById(long id) {
		OwnerEntity entity;
		Optional<OwnerEntity> opt = repos.findById(id);
		if(opt.isPresent())
			entity=opt.get();
	else
			throw new NoSuchElementException("Owner with this id is not found");
		
		return entity;
		
	}


	@Override
	public ServiceEntity createServiceEntity(ServiceEntity Service) {
	
		return reposservice.save(Service);
	}


	@Override
	public ServiceEntity modifyServiceEntity(long id, ServiceEntity Service) {
		ServiceEntity oldService=this.getServiceEntityById(id);
		if(Service.getName() !=null)
			oldService.setName(Service.getName());
		if(Service.getDestination() !=null)
			oldService.setDestination(Service.getDestination());
			
		return reposservice.save(oldService);
	
	}


	@Override
	public ServiceEntity getServiceEntityById(long id) {
		ServiceEntity entity;
		Optional<ServiceEntity> opt = reposservice.findById(id);
		if(opt.isPresent())
			entity=opt.get();
	else
			throw new NoSuchElementException("service with this id is not found");
		
		return entity;
	
	}


	@Override
	public ServiceEntity deleteServiceEntityById(long id) {
		ServiceEntity entity = this.getServiceEntityById(id);
		reposservice.deleteById(id);
		return entity;
		
	}


	@Override
	public List<ServiceEntity> getAllServicesEntities() {
		// TODO Auto-generated method stub
		return reposservice.findAll();
	}

}
