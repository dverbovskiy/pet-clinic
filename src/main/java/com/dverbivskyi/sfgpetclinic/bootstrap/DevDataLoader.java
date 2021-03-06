package com.dverbivskyi.sfgpetclinic.bootstrap;

import com.dverbivskyi.sfgpetclinic.model.Owner;
import com.dverbivskyi.sfgpetclinic.model.Vet;
import com.dverbivskyi.sfgpetclinic.service.OwnerService;
import com.dverbivskyi.sfgpetclinic.service.PetService;
import com.dverbivskyi.sfgpetclinic.service.VetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DevDataLoader implements CommandLineRunner {

    private static final Logger LOG = LogManager.getLogger();

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;

    @Autowired
    public DevDataLoader(OwnerService ownerService,
                         VetService vetService,
                         PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        LOG.info("Owners were loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        LOG.info("Vets were loaded");
    }
}
