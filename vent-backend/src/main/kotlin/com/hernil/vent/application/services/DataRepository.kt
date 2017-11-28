package com.hernil.vent.application.services

import com.hernil.vent.application.domain.Data
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DataRepository : JpaRepository<Data, Long>