package com.example.bankmanagement.repository;
import com.example.bankmanagement.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {

    //renvoie liste des opération du client passé en paramètre de la méthode
   public List<Operation> getOperationByClient_Id(Long client);
}
