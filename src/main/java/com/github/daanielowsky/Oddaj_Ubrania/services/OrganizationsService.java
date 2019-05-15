package com.github.daanielowsky.Oddaj_Ubrania.services;

import com.github.daanielowsky.Oddaj_Ubrania.Repositories.OrganizationsRepository;
import com.github.daanielowsky.Oddaj_Ubrania.dto.OrganizationsDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrganizationsService {


    private OrganizationsRepository organizationsRepository;

    public OrganizationsService(OrganizationsRepository organizationsRepository) {
        this.organizationsRepository = organizationsRepository;
    }


    @Transactional
    public void registerOrganization(OrganizationsDTO organizationsDTO){
        Organizations organizations = new Organizations();
        organizations.setName(organizationsDTO.getName());
        organizations.setMission(organizationsDTO.getMission());
        organizationsRepository.save(organizations);
    }

    @Transactional
    public int getNumberOfOrganizations(){
        return organizationsRepository.getAll();
    }

    @Transactional
    public List<Organizations> getAllOrganizations(){
        return organizationsRepository.getAllBy();
    }
}
