package com.github.daanielowsky.Oddaj_Ubrania.services;

import com.github.daanielowsky.Oddaj_Ubrania.Repositories.CollectionRepository;
import com.github.daanielowsky.Oddaj_Ubrania.Repositories.OrganizationsRepository;
import com.github.daanielowsky.Oddaj_Ubrania.dto.CollectionDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Collections;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Organizations;
import com.github.daanielowsky.Oddaj_Ubrania.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.github.daanielowsky.Oddaj_Ubrania.services.Converter.*;


@Service
public class CollectionsService {

    private UserService userService;
    private OrganizationsService organizationsService;
    private OrganizationsRepository organizationsRepository;
    private CollectionRepository collectionRepository;

    public CollectionsService(UserService userService, OrganizationsService organizationsService, OrganizationsRepository organizationsRepository, CollectionRepository collectionRepository) {
        this.userService = userService;
        this.organizationsService = organizationsService;
        this.organizationsRepository = organizationsRepository;
        this.collectionRepository = collectionRepository;
    }

    @Transactional
    public void saveCollection(CollectionDTO dto){
        Collections collections = convertToCollectionFromDTO(dto);

        User loggerUser = userService.getLoggerUser();

        collections.setUser(loggerUser);

        Long id = collections.getOrganizations().getId();
        Organizations organizationsById = organizationsRepository.getOrganizationsById(id);
        Long numberOfCollections = organizationsById.getNumberOfCollections();
        numberOfCollections++;
        organizationsById.setNumberOfCollections(numberOfCollections);

        organizationsRepository.save(organizationsById);

        collectionRepository.save(collections);
    }

    @Transactional
    public List<Collections> getListOfCollections(Long id){
        return collectionRepository.getSortedListOfCollections(id);
    }
}
