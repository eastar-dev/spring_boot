package dev.eastar.mvc.account

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Account(@Id @GeneratedValue var id: Long = 0
                   , var username: String
                   , var password: String
                   , var email: String
)