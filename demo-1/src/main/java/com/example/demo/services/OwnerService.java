package com.example.demo.services;

import java.util.List;

import com.example.demo.modeles.BookingEntity;
import com.example.demo.modeles.OwnerEntity;
import com.example.demo.modeles.ServiceEntity;

public interface OwnerService {
	OwnerEntity createOwnerEntity(OwnerEntity Owner);
	OwnerEntity getOwnerEntityById(long id);
	OwnerEntity deleteOwnerEntityById(long id);
	
	ServiceEntity createServiceEntity(ServiceEntity Service);
	ServiceEntity modifyServiceEntity(long id, ServiceEntity Service);
	ServiceEntity getServiceEntityById(long id);
	ServiceEntity deleteServiceEntityById(long id);
	List<ServiceEntity> getAllServicesEntities();
	
	
}
