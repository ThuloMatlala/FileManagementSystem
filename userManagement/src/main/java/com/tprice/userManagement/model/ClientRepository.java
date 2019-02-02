package com.tprice.userManagement.model;

import org.springframework.data.jpa.repository.JpaRepository;

interface  ClientRepository extends JpaRepository<Client, Long> {

}
