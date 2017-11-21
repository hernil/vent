package com.hernil.vent.services

import com.hernil.vent.domain.Data
import org.springframework.data.jpa.repository.JpaRepository

interface DataRepository : JpaRepository<Data, Long>