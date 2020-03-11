package dev.eastar.mvc.account

import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<Account, String> {

}
