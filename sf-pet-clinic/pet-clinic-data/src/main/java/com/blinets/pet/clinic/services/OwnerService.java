package com.blinets.pet.clinic.services;

import com.blinets.pet.clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}


