package com.hernil.vent

import org.springframework.data.jpa.repository.JpaRepository

interface DataRepository : JpaRepository<Data, Long>